package com.example.wellwang.greendaodemo.simple;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import cn.bmob.v3.BmobObject;

/**
 * Created by Well Wang on 2018/4/25.
 */
@Entity
public class Temp extends BmobObject {
    @Id(autoincrement = true)
    Long id;

    double temp;

    public double getTemp() {
        return this.temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 911748239)
    public Temp(Long id, double temp) {
        this.id = id;
        this.temp = temp;
    }

    @Generated(hash = 1524106993)
    public Temp() {
    }

   
}
