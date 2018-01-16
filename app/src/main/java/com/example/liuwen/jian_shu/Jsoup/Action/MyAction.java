package com.example.liuwen.jian_shu.Jsoup.Action;

import android.content.Context;

import com.example.liuwen.jian_shu.Jsoup.HtmlParserUtil;
import com.example.liuwen.jian_shu.Module.UserModel;
import com.example.liuwen.jian_shu.R;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/15 15:29
 * desc   :
 */
public class MyAction {

    public static void searchMyDate(final Context context, final String url, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<UserModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<UserModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMyData(url));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<UserModel>>() {
            @Override
            public void accept(@NonNull List<UserModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }
}
