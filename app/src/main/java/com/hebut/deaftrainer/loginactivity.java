package com.hebut.deaftrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginactivity extends AppCompatActivity {
    private Button mBtnText3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        mBtnText3=findViewById(R.id.text3);
        mBtnText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到TextView演示界面
               Intent intent = new Intent(loginactivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
