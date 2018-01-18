package com.example.liuwen.jian_shu.Module;

import java.io.Serializable;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 15:20
 * desc   :
 */
public class UserModel implements Serializable {
    private String userUrl;//用户头像
    private String userName;//用户名称
    private String userTime;//用户时间
    private String userTitle;//标题
    private String userContent;//用户内容
    private String userContentUrl;//用户图片
    private String userContentPhoto;//内存图片
    private String userWatchNumber;//用户观看次数
    private String userComment;//用户评论
    private String userAgree;//用户点赞


    public UserModel() {
    }

    public UserModel(String userUrl, String userName, String userTime, String userContent, String userContentUrl, String userWatchNumber, String userComment, String userAgree) {
        this.userUrl = userUrl;
        this.userName = userName;
        this.userTime = userTime;
        this.userContent = userContent;
        this.userContentUrl = userContentUrl;
        this.userWatchNumber = userWatchNumber;
        this.userComment = userComment;
        this.userAgree = userAgree;
    }

    public String getUserContentPhoto() {
        return userContentPhoto;
    }

    public void setUserContentPhoto(String userContentPhoto) {
        this.userContentPhoto = userContentPhoto;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }

    public String getUserContentUrl() {
        return userContentUrl;
    }

    public void setUserContentUrl(String userContentUrl) {
        this.userContentUrl = userContentUrl;
    }

    public String getUserWatchNumber() {
        return userWatchNumber;
    }

    public void setUserWatchNumber(String userWatchNumber) {
        this.userWatchNumber = userWatchNumber;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getUserAgree() {
        return userAgree;
    }

    public void setUserAgree(String userAgree) {
        this.userAgree = userAgree;
    }


    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }
}
