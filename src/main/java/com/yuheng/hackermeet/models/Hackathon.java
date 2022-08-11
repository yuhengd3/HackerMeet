package com.yuheng.hackermeet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hackathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String type;

    private String location;

    



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
