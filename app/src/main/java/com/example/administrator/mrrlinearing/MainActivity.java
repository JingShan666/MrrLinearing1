package com.example.administrator.mrrlinearing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mrrlinearing.entry.Book;
import com.example.administrator.mrrlinearing.presenter.BookPresenter;
import com.example.administrator.mrrlinearing.view.BookView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button;
    private BookPresenter mBookPresenter = new BookPresenter();

    private BookView mBookView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);

            }
        });

        mBookView= new BookView(){

            @Override
            public void onSuccess(Book mBook) {
                text.setText(mBook.toString());

            }

            @Override
            public void onError(String msg) {

                text.setText(msg);

            }
        };

        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }
}
