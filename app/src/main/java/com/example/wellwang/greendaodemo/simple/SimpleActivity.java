package com.example.wellwang.greendaodemo.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.wellwang.greendaodemo.AFaApplication;
import com.example.wellwang.greendaodemo.R;
import com.example.wellwang.greendaodemo.TempDao;

import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Well Wang on 2018/4/25.
 */

public class SimpleActivity extends AppCompatActivity {
    TempDao mTempDao;
    double min;
    double max;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mTempDao = AFaApplication.getApplication().getDaoSession().getTempDao();
        for (int i=0;i<20;i++){
            Temp temp=new Temp();
            temp.setTemp(i*0.8);
            mTempDao.insert(temp);
        }
        long count= mTempDao.queryBuilder().count();
        List<Temp> tempList = mTempDao.queryBuilder()
                .where(TempDao.Properties.Id.ge(count-9))
                .orderAsc(TempDao.Properties.Id)
                .build().list();
        Log.d("MainActivity","size="+tempList.size());
        min=tempList.get(0).getTemp();
        max=tempList.get(0).getTemp();
        for (int i=0;i<tempList.size();i++){
            if (min>tempList.get(i).getTemp()){
                min=tempList.get(i).getTemp();
            }
            if (max<tempList.get(i).getTemp()){
                max=tempList.get(i).getTemp();
            }
            Log.d("MainActivity","temp="+tempList.get(i).getTemp());
            tempList.get(i).save(new SaveListener<String>() {
                @Override
                public void done(String objectId,BmobException e) {
                    if(e==null){
                        Log.d("MainActivity","添加数据成功，返回objectId为："+objectId);
                    }else{
                        Log.d("MainActivity","创建数据失败：" + e.getMessage());
                    }
                }
            });
        }
//        try {
//            CountFragment fragment=(CountFragment)getActivity().getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.view_pager + ":1");
//            if (fragment!=null){
//                if (fragment.getView()!=null){
                //
//                    fragment.loadView();
//                }
//            }
//        }catch (Exception e){
//        }

        float divide=(float) (max-min)/10;
        Log.d("MainActivity","min="+min);
        Log.d("MainActivity","max="+max);

    }
}
