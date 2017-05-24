package com.byl.listviewwithgrid;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.byl.listviewwithgrid.adapter.TestListViewAdapter;
import com.byl.listviewwithgrid.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listview;
    private TestListViewAdapter listViewAdapter;
    private List<TestBean> listBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBean = new ArrayList<TestBean>();
        initView();
        initData();
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);

    }

    private void initData() {
        TestBean bean = new TestBean();
        List<String> path= new ArrayList<String>();
        bean.setUsername("郭富城");
        bean.setHeadphoto("http://t11.baidu.com/it/u=3158457091,3429860559&fm=58");
        bean.setContent("大家好，我是郭富城");
        bean.setTime("1小时前");
        path.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        bean.setImgPath(path);
        TestBean bean2 = new TestBean();
        List<String> path2= new ArrayList<String>();
        bean2.setUsername("郭富城");
        bean2.setHeadphoto("http://t11.baidu.com/it/u=3158457091,3429860559&fm=58");
        bean2.setContent("大家好，我是郭富城");
        bean2.setTime("1小时前");
        path2.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path2.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        bean2.setImgPath(path2);

        TestBean bean3= new TestBean();
        List<String> path3= new ArrayList<String>();
        bean3.setUsername("郭富城");
        bean3.setHeadphoto("http://t11.baidu.com/it/u=3158457091,3429860559&fm=58");
        bean3.setContent("大家好，我是郭富城");
        bean3.setTime("1小时前");
        path3.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path3.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path3.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        path3.add("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
        bean3.setImgPath(path3);
        listBean.add(bean);//添加进list
        listBean.add(bean2);//添加进list
        listBean.add(bean3);//添加进list
        listViewAdapter = new TestListViewAdapter(this, listBean);
        listview.setAdapter(listViewAdapter);
        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(MainActivity.this, "点击了第" + (arg2 + 1) + "项", Toast.LENGTH_LONG).show();
            }
        });
    }

}
