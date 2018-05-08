package com.example.administrator.mrrlinearing.presenter;

import android.content.Context;

import com.example.administrator.mrrlinearing.entry.Book;
import com.example.administrator.mrrlinearing.manager.DataManager;
import com.example.administrator.mrrlinearing.view.BookView;
import com.example.administrator.mrrlinearing.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2018/5/8.
 */

public class BookPresenter implements Presenter {

    private DataManager mDataManager;

    private Context mContext;

    private CompositeSubscription mCompositeSubscription;

    private BookView mBookView;

    private Book mBook;

    private DataManager manager;

    @Override
    public void onCreate() {

        manager= new DataManager();
        mCompositeSubscription= new CompositeSubscription();

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mBookView= (BookView) view;
    }

    public void getSearchBooks(String name,String tag,int start,int count){
        mCompositeSubscription.add(manager.getSearchBooks(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (mBook != null){
                            mBookView.onSuccess(mBook);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mBookView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(Book book) {
                        mBook = book;
                    }
                })
        );
    }
}
