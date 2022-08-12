package com.yuheng.hackermeet.repositories;

import com.yuheng.hackermeet.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
    Optional<Skill> findSkillByName(String name);
}
