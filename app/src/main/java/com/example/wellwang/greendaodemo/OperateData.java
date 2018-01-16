package com.example.wellwang.greendaodemo;

import android.os.Build;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Well Wang on 2017/12/19.
 */

public class OperateData {
    /**
     * 插入
     * @param userDao
     * @param user
     */
    public static void insert(UserDao userDao,User user){
        userDao.insert(user);
    }

    /**
     * 删除等于name的所有user
     * @param userDao
     * @param name
     */
    public static void deleteName(UserDao userDao,String name){
        List<User> userList = (List<User>) userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().list();
         for (User user : userList) {
              userDao.delete(user);
           }
    }

    /**
     * 删除所有
     * @param userDao
     */
    public static void deleteAll(UserDao userDao){
        userDao.deleteAll();
    }

    /**
     * 更新指定
     * @param userDao
     * @param user
     */
    public static void upate(UserDao userDao,User user){
        userDao.update(user);
    }

    /**
     * 根据ID查询单个
     * @param userDao
     * @param id
     * @return
     */
    public static User query(UserDao userDao,long id){
        User user1=userDao.load(id);
        return user1;
    }

    /**
     * 查询所有name
     * @param userDao
     * @param name
     */
    public static List<User> queryNameList(UserDao userDao,String name){
        List<User> userList = (List<User>) userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().list();
        return userList;
    }
    /**
     * 查询所有方法1
     * @param userDao
     * @return
     */
    public static List<User> queryAll(UserDao userDao){
        List<User> users = userDao.loadAll();
        return users;
    }

    /**
     * 查询所有方法2
     * @param userDao
     * @return
     */
    public static List<User> queryAll1(UserDao userDao){
        List<User> users = userDao.queryBuilder().build().list();
        return users;
    }
}

