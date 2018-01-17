package com.example.liuwen.jian_shu.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuwen.jian_shu.Module.UserModel;
import com.example.liuwen.jian_shu.R;
import com.example.liuwen.jian_shu.Utils.GlideUtils;

import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/16 15:27
 * desc   :
 */
public class MyChildAdapter extends RecyclerView.Adapter<MyChildAdapter.MyViewHolder> {
    private List<UserModel> mList;
    private List<String> mList2;
    private Context mContext;


    public MyChildAdapter(List<UserModel> mList, List<String> mList2, Context mContext) {
        this.mList = mList;
        this.mList2 = mList2;
        this.mContext = mContext;
    }

    public void updateList(List<UserModel> list) {
        if (isListNotEmpty(list)) {
            mList = list;
        } else {
            mList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateListPic(List<String> list) {
        if (isListNotEmpty(list)) {
            mList2 = list;
        } else {
            mList.clear();
        }
        notifyDataSetChanged();
    }


    private static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_my_child, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        UserModel model = mList.get(position);
        GlideUtils.loadImage(viewHolder.imgUserUrl, "http:" + model.getUserUrl(), R.mipmap.ic_default_gray_avatar, R.mipmap.ic_default_gray_avatar);
        viewHolder.tvUserName.setText(model.getUserName());
        viewHolder.tvUserTime.setText(model.getUserTime());
        viewHolder.tvUserTitle.setText(model.getUserTitle());
        viewHolder.tvUserContent.setText(model.getUserContent());
        viewHolder.tvUserWatchNumber.setText(model.getUserWatchNumber());
        viewHolder.tvUserComment.setText(model.getUserComment());
        viewHolder.tvUserLike.setText(model.getUserAgree());
        if (mList2.size() != 0 && mList2.size() == mList.size()) {
            GlideUtils.loadImage(viewHolder.ImgUserContentUrl, "http:" + mList2.get(position), R.mipmap.ic_default_gray_avatar, R.mipmap.ic_default_gray_avatar);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        TextView tvUserTime;
        TextView tvUserTitle;
        ImageView imgUserUrl;
        TextView tvUserContent;
        ImageView ImgUserContentUrl;
        TextView tvUserWatchNumber;
        TextView tvUserComment;
        TextView tvUserLike;

        public MyViewHolder(View view) {
            super(view);
            imgUserUrl = (ImageView) view.findViewById(R.id.img_user_url);
            tvUserName = (TextView) view.findViewById(R.id.txt_user_name);
            tvUserTime = (TextView) view.findViewById(R.id.txt_user_time);
            tvUserTitle = (TextView) view.findViewById(R.id.txt_title);
            tvUserContent = (TextView) view.findViewById(R.id.txt_content);
            ImgUserContentUrl = (ImageView) view.findViewById(R.id.img_content_url);
            tvUserWatchNumber = (TextView) view.findViewById(R.id.txt_watch_number);
            tvUserComment = (TextView) view.findViewById(R.id.txt_comment);
            tvUserLike = (TextView) view.findViewById(R.id.txt_like);
        }
    }
}
