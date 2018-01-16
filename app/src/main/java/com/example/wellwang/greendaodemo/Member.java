package com.example.wellwang.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Well Wang on 2017/12/19.
 */
@Entity
public class Member {
    @Id
    Long id;
    int age;
    String name;
    Long leaderId;
    public Long getLeaderId() {
        return this.leaderId;
    }
    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1508412161)
    public Member(Long id, int age, String name, Long leaderId) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.leaderId = leaderId;
    }
    @Generated(hash = 367284327)
    public Member() {
    }
}
