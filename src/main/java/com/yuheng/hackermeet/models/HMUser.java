package com.yuheng.hackermeet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HMUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // Auth0User ID
    private String sub;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    private String email;

    private String username;

    private String github;

    private String website;

    @OneToMany(mappedBy = "user")
    private List<Skill> skills = new ArrayList<Skill>();

    public Long getId() {
        return id;
    }


}
