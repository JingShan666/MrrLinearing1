package com.example.administrator.mrrlinearing.view;

import com.example.administrator.mrrlinearing.entry.Book;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface BookView extends View{

    void onSuccess(Book mBook);

    void onError(String msg);



}
