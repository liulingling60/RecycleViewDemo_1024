package com.example.dyx.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.dyx.recycleviewdemo.biz.Xhttp;
import com.example.dyx.recycleviewdemo.entity.NetEase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView1)
    RecyclerView mRecyclerView1;
    //1.ButterKnife ,2,网络,Volley,XUtil3,Retrofit,3,RecyclerView
String url="http://c.m.163.com/nc/article/list/T1348647909107/0-20.html";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Xhttp.getNewsList(url,"T1348647909107",listener);
    }


    private Xhttp.OnSuccessListener listener=new Xhttp.OnSuccessListener() {
        @Override
        public void setNewsList(List<NetEase> neteaseNews) {
            //适配器的工作：将集合添加到适配器

        }
    };
}
