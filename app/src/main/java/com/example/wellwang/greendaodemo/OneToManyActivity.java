package com.example.wellwang.greendaodemo;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Well Wang on 2017/12/19.
 */

public class OneToManyActivity extends AppCompatActivity {
    private BossDao bossDao;
    private MemberDao memberDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bossDao=AFaApplication.getApplication().getDaoSession().getBossDao();
        memberDao=AFaApplication.getApplication().getDaoSession().getMemberDao();
        initView();
    }

    private void initView() {
        bossDao.deleteAll();
        memberDao.deleteAll();
        Boss boss1=new Boss(new Long(10),1,"a");
        Boss boss2=new Boss(null,2,"b");
        bossDao.insert(boss1);
        bossDao.insert(boss2);
        //Member member1=new Member(null,"a1",boss1.getId());
      //  Member member2=new Member();
    }
}