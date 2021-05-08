package com.example.ht.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HT on 2016/10/14.
 */

public class SecondActivity extends Activity {

    private Button log_in ;
    private EditText account;
    private EditText pass_word;
    private String acc;
    private String pss_wd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        final Intent intent = new Intent(SecondActivity.this,MainActivity.class);//实现从这个活动跳到下一个活动
        log_in=(Button)findViewById(R.id.log_in);
        account=(EditText) findViewById(R.id.ET_1);
        pass_word=(EditText)findViewById(R.id.ET_2);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc=account.getText().toString();
                pss_wd=pass_word.getText().toString();
                //if (acc=="3160106014"&&pss_wd=="123456")
                //{
                  startActivity(intent);
                //}
                //else
                /*{
                    Toast.makeText(SecondActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                }*/
            }

        });
    }

}
