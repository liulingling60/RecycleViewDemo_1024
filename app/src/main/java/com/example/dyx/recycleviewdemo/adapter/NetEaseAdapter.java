package com.example.dyx.recycleviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dyx.recycleviewdemo.R;
import com.example.dyx.recycleviewdemo.entity.NetEase;
import com.example.dyx.recycleviewdemo.utils.XImageUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/24.
 */

public class NetEaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public NetEaseAdapter(List<NetEase> dataList) {
        this.dataList = dataList;
    }

    public List<NetEase> getDataList() {
        return dataList;
    }

    public void setDataList(List<NetEase> dataList) {
        this.dataList = dataList;
    }

    private List<NetEase> dataList;

    /***
     * 根据视图类型决定视图的布局，使用哪个holder创建视图
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.layout_item_one_img, null);
        OneImageHolder holder = new OneImageHolder(view);
        return holder;
    }

    /**
     * 通过位置确定当前的视图类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * 给每个holder设置对应的数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneImageHolder) {
            OneImageHolder h = (OneImageHolder) holder;
            NetEase netEase = dataList.get(position);
            XImageUtil.display(h.mImgLeft, netEase.imgsrc);
            h.mTvTitle.setText(netEase.title);
            h.mTvFollow.setText(netEase.replyCount + "");
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    public static class OneImageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_left)
        ImageView mImgLeft;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_follow)
        TextView mTvFollow;

        public OneImageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ThreeImageLoader extends RecyclerView.ViewHolder {

        public ThreeImageLoader(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
