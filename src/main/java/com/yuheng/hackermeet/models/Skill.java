package com.yuheng.hackermeet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private HMUser user;

    private String name;

    public HMUser getUser() {
        return user;
    }

    public void setUser(HMUser user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }
}
