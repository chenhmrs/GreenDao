package com.example.wellwang.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDao dao;
    private WifeDao wifeDao;
    //
    private DaoSession mDaoSession;
    private String id;
    private String name;
    private String nameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao =AFaApplication.getApplication().getDaoSession().getUserDao();
        wifeDao=AFaApplication.getApplication().getDaoSession().getWifeDao();
        //测试DaoSession的clear方法
        mDaoSession=AFaApplication.getApplication().getDaoSession();
        initView();
    }

    private void initView() {
        OperateData.deleteAll(dao);
        wifeDao.deleteAll();
        //别用这个，清缓存每次打开还是会增加数据
        //mDaoSession.clear();
        Long wifeId1=new Long(100);
        Long wifeId2=new Long(200);
        Long wifeId3=new Long(300);

        User user1=new User(null,"a","1","man","11",wifeId1);
        User user2=new User(null,"b","2","man","22",wifeId2);
        User user3=new User(null,"c","3","man","33",wifeId3);
        OperateData.insert(dao,user1);
        OperateData.insert(dao,user2);
        OperateData.insert(dao,user3);
        Wife wife1=new Wife(wifeId1,100,"A");
        Wife wife2=new Wife(wifeId2,200,"B");
        Wife wife3=new Wife(wifeId3,300,"C");
        wifeDao.insert(wife1);
        wifeDao.insert(wife2);
        wifeDao.insert(wife3);
        List<User> userList =OperateData.queryAll1(dao);
        Log.d("MainActivity","size="+userList.size());
        for (int i = 0; i < userList.size(); i++) {
             name+= userList.get(i).getName() + "的wife是"+userList.get(i).getWife().getName();
        }
        Log.d("MainActivity","name="+name);
        /**List<User> userList1=OperateData.queryNameList(dao,"b");
        Log.d("MainActivity","when name is b ,age="+userList.get(0).getAge());
        OperateData.deleteName(dao,"b");
        List<User> userList2 =OperateData.queryAll1(dao);
        Log.d("MainActivity","size="+userList2.size());
        for (int i = 0; i < userList2.size(); i++) {
            nameList+= userList2.get(i).getName() + ",";
        }
        Log.d("MainActivity",nameList);
         **/


    }
}
