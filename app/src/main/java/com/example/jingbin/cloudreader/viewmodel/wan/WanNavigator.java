package com.example.jingbin.cloudreader.viewmodel.wan;

import com.example.jingbin.cloudreader.bean.wanandroid.DuanZiBean;

import java.util.List;

import io.reactivex.disposables.Disposable;



public interface WanNavigator {


    interface JokeModelNavigator {
        void loadSuccess(List<DuanZiBean> lists);

        void loadFailed();

        void addSubscription(Disposable disposable);

    }

    /**
     * 收藏或取消收藏
     */
    interface OnCollectNavigator {
        void onSuccess();

        void onFailure();
    }

}
