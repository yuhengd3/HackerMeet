package com.yuheng.hackermeet.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class HMUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Auth0User ID
    @Column(unique = true)
    private String sub;

    private String email;

    private String username;

    private String github;

    private String website;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_id")
    @ManyToMany
    private Set<Skill> skills = new HashSet<Skill>();

    protected HMUser() {

    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return "HMUser{" +
                "id=" + id +
                ", sub='" + sub + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", github='" + github + '\'' +
                ", website='" + website + '\'' +
                ", skills=" + skills +
                '}';
    }


}
