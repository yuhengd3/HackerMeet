package com.yuheng.hackermeet.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuheng.hackermeet.models.HMUser;
import com.yuheng.hackermeet.services.HMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Objects;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final HMUserService hmUserService;

    @Autowired
    public UserController(HMUserService hmUserService) {
        this.hmUserService = hmUserService;
    }

    @GetMapping("/{id}")
    public HMUser getUser(@PathVariable Long id) {
        return hmUserService.findHMUserById(id).orElseThrow();
    }

    @PostMapping
    public HMUser saveUser(@RequestBody HMUser user,
                           @RequestHeader (name="Authorization") String token) {
        System.out.println(user);
        return hmUserService.saveHMUser(user);
    }

    @PutMapping("/{id}")
    public HMUser updateUser(@RequestBody HMUser user, @PathVariable Long id,
                             @RequestHeader(name="Authorization") String token) throws JsonProcessingException {
        String sub = parsePayloadFromJWT(token).get("sub").asText();
        if (!Objects.equals(user.getSub(), sub)) {
            throw new RuntimeException("Auth0 id from awt doesn't match user object");
        }
        return hmUserService.findHMUserById(id).filter(storedUser ->
                Objects.equals(storedUser.getId(), user.getId())
                        && Objects.equals(storedUser.getSub(), user.getSub()))
                .map(storedUser -> {
                    storedUser.setGithub(user.getGithub());
                    return hmUserService.saveHMUser(user);
                })
                .orElseThrow();
    }
    public static JsonNode parsePayloadFromJWT(String token) throws JsonProcessingException {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(payload);
    }


}
