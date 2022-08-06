package com.yuheng.hackermeet.repositories;

import com.yuheng.hackermeet.models.HMUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HMUserRepository extends CrudRepository<HMUser, Long> {
    Optional<HMUser> findHMUserBySub(String sub0);
}
