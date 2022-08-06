package com.yuheng.hackermeet.models;

import javax.persistence.CascadeType;
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

    protected HMUser() {

    }

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Skill> skills = new ArrayList<Skill>();

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HMUser(Long id, String sub, String email, String username, String github, String website, List<Skill> skills) {
        this.id = id;
        this.sub = sub;
        this.email = email;
        this.username = username;
        this.github = github;
        this.website = website;
        this.skills = skills;
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
