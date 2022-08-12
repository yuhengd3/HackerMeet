package com.yuheng.hackermeet.services;

import com.yuheng.hackermeet.models.HMUser;
import com.yuheng.hackermeet.models.Skill;
import com.yuheng.hackermeet.repositories.HMUserRepository;
import com.yuheng.hackermeet.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class HMUserService {
    private final HMUserRepository hmUserRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public HMUserService(HMUserRepository hmUserRepository, SkillRepository skillRepository) {
        this.hmUserRepository = hmUserRepository;
        this.skillRepository = skillRepository;
    }

    public HMUser saveHMUser(HMUser user) {
        Set<Skill> newSet = new HashSet<Skill>();
        for (Skill skill : user.getSkills()) {
            Optional<Skill> s = skillRepository.findSkillByName(skill.getName());
            newSet.add(s.orElseGet(() -> skillRepository.save(skill)));
        }
        user.setSkills(newSet);
        return hmUserRepository.save(user);
    }

    public Optional<HMUser> findHMUserById(Long id) {
        return hmUserRepository.findById(id);
    }
}
