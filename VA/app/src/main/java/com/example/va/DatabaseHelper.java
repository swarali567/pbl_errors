package com.example.va;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context,"Records",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(name text,address text,car_model text,vehicle_code text,email text,contact text primary key)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table users");
        onCreate(db);
    }
    public boolean insertData(String name,String address,String car_model,String vehicle_code,String email,String contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("car_model",car_model);
        cv.put("vehicle_code",vehicle_code);
        cv.put("email",email);
        cv.put("contact",contact);
        long res=db.insert("users",null,cv);
        if(res==-1)
            return false;
        else
            return true;
    }
    public Cursor displayData(String contact){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from users where contact=?",new String[]{contact});
        return cursor;
    }
    public boolean updateData(String name,String address,String car_model,String vehicle_code,String email,String contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("car_model",car_model);
        cv.put("vehicle_code",vehicle_code);
        cv.put("email",email);
        cv.put("contact",contact);

        Cursor cursor=db.rawQuery("select * from users where contact=?",new String[]{contact});
        if(cursor.getCount()>0) {
            long result = db.update("users", cv, "contact=?", new String[]{contact});
            if (result == -1)
                return false;
            else
                return true;
        }else
            return false;
    }
    public boolean deleteData(String contact){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where contact=?",new String[]{contact});
        if(cursor.getCount()>0)
        {
            long result=db.delete("users","contact=?",new String[]{contact});
            if(result==-1)
                return false;
            else
                return true;
            }else
                return true;
    }
    public Cursor viewData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from users",null);
        return res;
    }}


