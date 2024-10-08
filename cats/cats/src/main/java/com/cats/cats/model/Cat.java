package com.cats.cats.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cat {
    private Long id;
    private Integer position;
    private String name;
    private Integer obtainedPoints;

    public Cat(Long id, Integer position, String name, Integer obtainedPoints) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.obtainedPoints = obtainedPoints;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Integer getObtainedPoints() {
        return obtainedPoints;
    }
}
