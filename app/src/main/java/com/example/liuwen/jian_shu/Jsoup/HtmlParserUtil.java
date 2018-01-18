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
            Elements elements3 = document.select("li.have-img");
            String str[] = null;
            String text = "";
            for (int i = 0; i < elements3.size(); i++) {
                UserModel model = new UserModel();
                Log.e(Config.TAG, "userUrl: " + elements3.select("div.content").get(i).select("a.avatar").select("img").attr("src"));
                Log.e(Config.TAG, "username: " + elements3.select("div.content").get(i).select("div.info").select("a.nickname").text());
                Log.e(Config.TAG, "time " + elements3.select("div.content").get(i).select("span.time").attr("data-shared-at"));
                Log.e(Config.TAG, "title: " + elements3.select("div.content").get(i).select("a.title").text());
                Log.e(Config.TAG, "content:" + elements3.select("div.content").get(i).select("p.abstract").text());
                Log.e(Config.TAG, "contentUrl:" + elements3.select("div.content").get(i).select("a.title").attr("href"));
                Log.e(Config.TAG, "WatchNumber:" + elements3.select("div.content").get(i).select("div.meta").text());
                Log.e(Config.TAG, "contentPhoto:" + elements3.select("a.wrap-img").get(i).select("img").attr("data-echo"));
                text = elements3.select("div.content").get(i).select("div.meta").text();
                str = text.split(" ");
                model.setUserUrl(elements3.select("div.content").get(i).select("a.avatar").select("img").attr("src"));
                model.setUserName(elements3.select("div.content").get(i).select("div.info").select("a.nickname").text());
                model.setUserTime(elements3.select("div.content").get(i).select("span.time").attr("data-shared-at"));
                model.setUserTitle(elements3.select("div.content").get(i).select("a.title").text());
                model.setUserContent(elements3.select("div.content").get(i).select("p.abstract").text());
                model.setUserContentUrl(elements3.select("div.content").get(i).select("a.title").attr("href"));
                model.setUserContentPhoto(elements3.select("a.wrap-img").get(i).select("img").attr("data-echo"));
                model.setUserWatchNumber(str[0]);
                model.setUserComment(str[1]);
                model.setUserAgree(str[2]);
                list.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
