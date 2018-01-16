package com.example.wellwang.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Well Wang on 2017/12/19.
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String age;
    private String sex;
    private String salary;
    private long wifeId;
    @ToOne(joinProperty = "wifeId")
    private Wife wife;
    @Generated(hash = 963033483)
    private transient Long wife__resolvedKey;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    public String getSalary() {
        return this.salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1236968118)
    public void setWife(@NotNull Wife wife) {
        if (wife == null) {
            throw new DaoException(
                    "To-one property 'wifeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.wife = wife;
            wifeId = wife.getId();
            wife__resolvedKey = wifeId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1911600541)
    public Wife getWife() {
        long __key = this.wifeId;
        if (wife__resolvedKey == null || !wife__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WifeDao targetDao = daoSession.getWifeDao();
            Wife wifeNew = targetDao.load(__key);
            synchronized (this) {
                wife = wifeNew;
                wife__resolvedKey = __key;
            }
        }
        return wife;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
    public long getWifeId() {
        return this.wifeId;
    }
    public void setWifeId(long wifeId) {
        this.wifeId = wifeId;
    }
    @Generated(hash = 819226236)
    public User(Long id, String name, String age, String sex, String salary,
            long wifeId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.wifeId = wifeId;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
