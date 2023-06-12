package com.example.wwwapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guangchang1Activity extends AppCompatActivity {
    ImageButton imageButton1, imageButton2, imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guangchang1);
        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);

        imageButton1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //重新设置按下时的背景图片
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.mipmap.pql));
                }
//                else if(event.getAction() == MotionEvent.ACTION_UP){
//                    //再修改为抬起时的正常图片
//                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.mipmap.like));
//                }
                return false;
            }

        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Guangchang1Activity.this, "点赞成功", Toast.LENGTH_LONG).show();


            }
        });


        imageButton2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //重新设置按下时的背景图片
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.mipmap.pql));
                }
//                else if(event.getAction() == MotionEvent.ACTION_UP){
//                    //再修改为抬起时的正常图片
//                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.mipmap.like));
//                }
                return false;
            }

        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//

                Toast.makeText(Guangchang1Activity.this, "点赞成功", Toast.LENGTH_LONG).show();


            }
        });


        imageButton3.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //重新设置按下时的背景图片
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.mipmap.pql));
                }
//                else if(event.getAction() == MotionEvent.ACTION_UP){
//                    //再修改为抬起时的正常图片
//                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.mipmap.like));
//                }
                return false;
            }

        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//

                Toast.makeText(Guangchang1Activity.this, "点赞成功", Toast.LENGTH_LONG).show();


            }
        });


    }


}
