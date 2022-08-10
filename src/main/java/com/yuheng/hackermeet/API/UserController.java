package com.yuheng.hackermeet.API;

import com.yuheng.hackermeet.models.HMUser;
import com.yuheng.hackermeet.services.HMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public HMUser saveUser(@RequestBody HMUser user) {
        return hmUserService.saveHMUser(user);
    }


}
