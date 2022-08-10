package com.yuheng.hackermeet.services;

import com.yuheng.hackermeet.models.HMUser;
import com.yuheng.hackermeet.models.Skill;
import com.yuheng.hackermeet.repositories.HMUserRepository;
import com.yuheng.hackermeet.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HMUserService {
    private final HMUserRepository hmUserRepository;

    @Autowired
    public HMUserService(HMUserRepository hmUserRepository) {
        this.hmUserRepository = hmUserRepository;
    }

    public HMUser saveHMUser(HMUser user) {
        return hmUserRepository.save(user);
    }

    public Optional<HMUser> findHMUserById(Long id) {
        return hmUserRepository.findById(id);
    }
}
