package com.example.SpringBoot_Start.domain;

import java.sql.Date;

public class TWorld {

    private Long id;

    private String uuid;

    private Short active;

    private String worldName;

    private Integer worldAge;

    private String worldDesc;

    private Float worldRadius;

    private Double worldWeight;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public Integer getWorldAge() {
        return worldAge;
    }

    public void setWorldAge(Integer worldAge) {
        this.worldAge = worldAge;
    }

    public String getWorldDesc() {
        return worldDesc;
    }

    public void setWorldDesc(String worldDesc) {
        this.worldDesc = worldDesc;
    }

    public Float getWorldRadius() {
        return worldRadius;
    }

    public void setWorldRadius(Float worldRadius) {
        this.worldRadius = worldRadius;
    }

    public Double getWorldWeight() {
        return worldWeight;
    }

    public void setWorldWeight(Double worldWeight) {
        this.worldWeight = worldWeight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // @PrePersist
    // public void init() {
    //     this.uuid = UUID.randomUUID().toString().replace("-", "");
    // }

}
