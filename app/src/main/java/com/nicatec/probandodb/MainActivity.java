package com.nicatec.probandodb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper.configure(DBConstants.TABLE_TWEETS,getApplicationContext());

        DBHelper d = DBHelper.getInstance();

        TweetDAO tweetDAO = new TweetDAO();

        TweetMessage m = new TweetMessage(0,"Hola, esto es un tweet");
        tweetDAO.insert(m);

    }
}
