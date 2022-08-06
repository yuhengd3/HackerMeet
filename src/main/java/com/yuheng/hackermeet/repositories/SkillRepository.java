package com.yuheng.hackermeet.repositories;

import com.yuheng.hackermeet.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

}
