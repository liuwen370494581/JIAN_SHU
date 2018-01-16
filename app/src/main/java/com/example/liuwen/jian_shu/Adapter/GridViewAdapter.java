package com.example.liuwen.jian_shu.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liuwen.jian_shu.Module.IndexModel;
import com.example.liuwen.jian_shu.R;

import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 11:32
 * desc   :
 */
public class GridViewAdapter extends BaseAdapter {

    private List<IndexModel> mList;
    private Context mContext;


    public GridViewAdapter(List<IndexModel> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.message_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        IndexModel indexModel = mList.get(position);
        holder.appName.setText(indexModel.getName());
        holder.appIcon.setImageResource(indexModel.getIcon());
        return convertView;
    }

    static class ViewHolder {
        ImageView appIcon;
        TextView appName;

        ViewHolder(View view) {
            appIcon = (ImageView) view.findViewById(R.id.appIcon);
            appName = (TextView) view.findViewById(R.id.appName);
        }
    }
}
