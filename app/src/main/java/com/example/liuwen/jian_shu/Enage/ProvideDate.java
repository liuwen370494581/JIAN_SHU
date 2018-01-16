package com.example.liuwen.jian_shu.Enage;

import com.example.liuwen.jian_shu.Module.IndexModel;
import com.example.liuwen.jian_shu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 11:35
 * desc   :
 */
public class ProvideDate {


    public static List<IndexModel> getMessageDate() {
        List<IndexModel> list = new ArrayList<>();
        list.add(new IndexModel(R.mipmap.image_talk, "评论"));
        list.add(new IndexModel(R.mipmap.image_like, "喜欢和赞"));
        list.add(new IndexModel(R.mipmap.image_guanzhu, "关注"));
        list.add(new IndexModel(R.mipmap.image_ask, "投稿请求"));
        list.add(new IndexModel(R.mipmap.image_reward, "赞赏"));
        list.add(new IndexModel(R.mipmap.image_other, "其他提醒"));
        return list;
    }
}
