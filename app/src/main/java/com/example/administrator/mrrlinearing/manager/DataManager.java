package com.example.administrator.mrrlinearing.manager;

import android.content.Context;

import com.example.administrator.mrrlinearing.entry.Book;
import com.example.administrator.mrrlinearing.net.RetrofitHelper;
import com.example.administrator.mrrlinearing.net.RetrofitService;

import rx.Observable;

/**
 * Created by Administrator on 2018/5/8.
 */


    public class DataManager {
        private RetrofitService mRetrofitService;
        public DataManager(){
            this.mRetrofitService = RetrofitHelper.getIntance().getRetrofitService();
        }
        public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
            return mRetrofitService.getSearchBooks(name,tag,start,count);
        }
    }

