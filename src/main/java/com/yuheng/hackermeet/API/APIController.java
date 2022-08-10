package com.yuheng.hackermeet.API;

import com.yuheng.hackermeet.models.HMUser;
import com.yuheng.hackermeet.models.Skill;
import com.yuheng.hackermeet.repositories.HMUserRepository;
import com.yuheng.hackermeet.services.HMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    private HMUserService hmUserService;

    @Autowired
    private HMUserRepository repo;

    @Autowired
    public APIController(HMUserService hmUserService) {
        this.hmUserService = hmUserService;
    }

    @GetMapping
    String getResponse() {
        return "Hello";
    }

    @PostMapping("/user")
    String getUser(@RequestBody HMUser user) {


//        Skill j = new Skill(user, "Java");
//        user.addSkill(j);
//        Skill p = new Skill(user, "Python");
//        user.addSkill(p);
//        System.out.println(user);
//        HMUser newUser = hmUserService.saveHMUser(user);
        repo.save(user);
//        System.out.println(user);

//        user.getSkills().remove(p);
//        p.setUser(null);
//        System.out.println(user);
//        repo.save(user);
//        repo.delete(user);
//        newUser.setSub("newSub");
        return "success";
    }
}
