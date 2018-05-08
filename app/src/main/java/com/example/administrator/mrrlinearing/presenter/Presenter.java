package com.example.administrator.mrrlinearing.presenter;

import com.example.administrator.mrrlinearing.view.View;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface Presenter {

    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(View view);
}
