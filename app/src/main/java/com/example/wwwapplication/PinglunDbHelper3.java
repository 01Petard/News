package com.example.wwwapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class PinglunDbHelper3 extends SQLiteOpenHelper {

    //定义数据库表名
    public static final String DB_NAME = "tb_pinglun3";
    /** 创建评论信息表 **/
    private static final String CREATE_PINGLUN3_DB = "create table tb_pinglun3 (" + "id integer primary key autoincrement," + "stuId text," + "currentTime text," + "content text," +
            "position integer )";

    public PinglunDbHelper3(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PINGLUN3_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 添加评论
     * @param review 评论对象
     */
    public void addReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("stuId",review.getStuId());
        values.put("currentTime",review.getCurrentTime());
        values.put("content",review.getContent());
        values.put("position",review.getPosition());
        db.insert(DB_NAME,null,values);
        values.clear();
    }

    /**
     * 根据商品项编号读取相应的评论信息
     * @return 评论对象数组
     */
    public LinkedList<Review> readReviews(int  position) {
        LinkedList<Review> reviews = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_pinglun3 where position=?",new String[]{String.valueOf(position)});
        if(cursor.moveToFirst()) {
            do{
                String stuId = cursor.getString(cursor.getColumnIndex("stuId"));
                String currentTime = cursor.getString(cursor.getColumnIndex("currentTime"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                Review review = new Review();
                review.setStuId(stuId);
                review.setCurrentTime(currentTime);
                review.setContent(content);
                reviews.add(review);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return reviews;
    }

}

