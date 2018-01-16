package com.example.liuwen.jian_shu.Jsoup;

import android.content.Context;
import android.util.Log;
import android.widget.ListPopupWindow;

import com.example.liuwen.jian_shu.Base.Config;
import com.example.liuwen.jian_shu.Module.UserModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liuwen on 2017/6/22.
 * jsoup爬取网页封装类
 */
public class HtmlParserUtil {

    public static List<UserModel> searchMyData(String url) {
        List<UserModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements3 = document.select("div.content");
            // Log.e(Config.TAG, elements3.toString());
            Log.e(Config.TAG, elements3.size() + "");
            UserModel model = new UserModel();
            for (int i = 0; i < elements3.size(); i++) {
                Log.e(Config.TAG, elements3.select("a.avatar").select("img").attr("src"));
                Log.e(Config.TAG, elements3.select("div.info").select("a.nickname").text());
                Log.e(Config.TAG, elements3.select("span.time").attr("data-shared-at"));
                Log.e(Config.TAG, elements3.select("a.title").text());
                Log.e(Config.TAG, elements3.select("p.abstract").text());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
