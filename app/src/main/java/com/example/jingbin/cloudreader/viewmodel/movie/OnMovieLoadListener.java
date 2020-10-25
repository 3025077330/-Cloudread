package com.example.jingbin.cloudreader.viewmodel.movie;

import com.example.jingbin.cloudreader.bean.HotMovieBean;



public interface OnMovieLoadListener {

    void onSuccess(HotMovieBean bean);

    void onFailure();
}
