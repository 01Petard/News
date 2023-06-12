package com.example.wwwapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Xinwen1Activity extends AppCompatActivity{
    ListView lvpinglun;
    LinkedList<Review> reviews = new LinkedList<>();
    EditText et_pinhlun;
    int position;
    byte[] picture;

//    private static final double ZOOM_IN_SCALE = 1.25;//放大系数
//    private static final double ZOOM_OUT_SCALE = 0.8;//缩小系数
    private  ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinwen1);
//        setContentView(new Zoom(this));
//        Bitmap btm1 = BitmapFactory.decodeResource(Xinwen1Activity.this.getResources(), R.drawable.t2);
//        BitmapDrawable bd1= new BitmapDrawable(btm1);
//        imageView.setBackgroundDrawable(bd1);
//
//        Bitmap btm2=Bitmap.createScaledBitmap(btm1, 40, 50, false); //自定义
//        BitmapDrawable bd2= new BitmapDrawable(btm2);
//        imageView.setBackgroundDrawable(bd2);

        et_pinhlun = findViewById(R.id.et_pinhlun);
        lvpinglun = findViewById(R.id.list_comment);
        //提交评论点击事件
        Button btnReview = findViewById(R.id.btn_fabu);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先检查是否为空
                if(CheckInput()) {
                    PinglunDbHelper dbHelper = new PinglunDbHelper(getApplicationContext(),PinglunDbHelper.DB_NAME,null,1);
                    Review review = new Review();
                    review.setContent(et_pinhlun.getText().toString());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                    //获取当前时间
                    Date date = new Date(System.currentTimeMillis());
                    review.setCurrentTime(simpleDateFormat.format(date));
                    String stuId = getIntent().getStringExtra("stuId");
//                    comment.setName("评论者"+(data.size()+1)+"：");
                    review.setStuId(stuId);
                    review.setPosition(position);
                    dbHelper.addReview(review);
                    //评论置为空
                    et_pinhlun.setText("");
                    Toast.makeText(getApplicationContext(),"提交成功!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        final ReviewAdapter adapter = new ReviewAdapter(getApplicationContext());
        final PinglunDbHelper dbHelper = new PinglunDbHelper(getApplicationContext(),PinglunDbHelper.DB_NAME,null,1);
        reviews = dbHelper.readReviews(position);
        adapter.setData(reviews);
        //设置适配器
        lvpinglun.setAdapter(adapter);
        //刷新页面
        TextView tvRefresh = findViewById(R.id.tv_refresh);
        tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviews = dbHelper.readReviews(position);
                adapter.setData(reviews);
                lvpinglun.setAdapter(adapter);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }


public boolean CheckInput() {
    String comment = et_pinhlun.getText().toString();
    if (comment.trim().equals("")) {
        Toast.makeText(this,"评论内容不能为空!",Toast.LENGTH_SHORT).show();
        return false;
    }
    return true;
}


}
