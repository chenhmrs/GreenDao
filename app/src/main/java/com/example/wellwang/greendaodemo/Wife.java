package com.example.wellwang.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Well Wang on 2017/12/19.
 */
@Entity
public class Wife  {
    @Id
    Long id;
    int age;
    String name;
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
    @Generated(hash = 2129875654)
    public Wife(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    @Generated(hash = 1846179238)
    public Wife() {
    }
}
