package com.yuheng.hackermeet.services;

import com.yuheng.hackermeet.models.HMUser;
import com.yuheng.hackermeet.models.Skill;
import com.yuheng.hackermeet.repositories.HMUserRepository;
import com.yuheng.hackermeet.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HMUserService {
    private HMUserRepository hmUserRepository;
    private SkillRepository skillRepository;

    @Autowired
    public HMUserService(HMUserRepository hmRepo, SkillRepository skillRepo) {
        hmUserRepository = hmRepo;
        skillRepository = skillRepo;
    }

    public HMUser saveHMUser(HMUser user) {
        HMUser updatedUesr = hmUserRepository.save(user);
        skillRepository.saveAll(user.getSkills());
        return updatedUesr;
    }
}
