package com.example.dyx.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dyx.recycleviewdemo.adapter.NetEaseAdapter;
import com.example.dyx.recycleviewdemo.biz.Xhttp;
import com.example.dyx.recycleviewdemo.entity.NetEase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import view.RecycleViewDivider;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView1)
    RecyclerView mRecyclerView1;
    //1.ButterKnife ,2,网络,Volley,XUtil3,Retrofit,3,RecyclerView
    String url = "http://c.m.163.com/nc/article/list/T1348647909107/0-20.html";
    NetEaseAdapter mNetEaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Xhttp.getNewsList(url, "T1348647909107", listener);
    }

    private Xhttp.OnSuccessListener listener = new Xhttp.OnSuccessListener() {
        @Override
        public void setNewsList(List<NetEase> neteaseNews) {
            //适配器的工作：将集合添加到适配器
            mNetEaseAdapter = new NetEaseAdapter(neteaseNews);
            mRecyclerView1.setAdapter(mNetEaseAdapter);
            //必须要设置一个布局管理器 //listview,gridview,瀑布流
            mRecyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            //   mRecyclerView1.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
            // mRecyclerView1.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, GridLayoutManager.HORIZONTAL, false));
            //   mRecyclerView1.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            //分割线
            mRecyclerView1.addItemDecoration(new RecycleViewDivider(MainActivity.this, LinearLayoutManager.HORIZONTAL));

        }
    };
}
