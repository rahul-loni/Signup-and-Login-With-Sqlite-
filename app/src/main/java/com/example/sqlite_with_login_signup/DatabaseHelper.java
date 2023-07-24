package com.example.sqlite_with_login_signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DatabaseName="Logsign.db";
    public DatabaseHelper( Context context) {
        super(context, "Logsign.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDb) {
        MyDb.execSQL("create Table users(email TEXT primary key , password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDb, int oldVersion, int newVersion) {
       MyDb.execSQL("drop Table if exists users ");
    }
   public boolean insertUsers(String email,String password ){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
       ContentValues contentValues=new ContentValues();
       contentValues.put("email",email);
       contentValues.put("password",password);
       Long result=sqLiteDatabase.insert("Users",null,contentValues);

       if (result==-1){
           return false;
       }else {
           return true;
       }
   }
   public boolean checkEmailPassword(String email,String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
       Cursor cursor=sqLiteDatabase.rawQuery("Select * from users where email=? and password=?"
       ,new String[]{email,password});

       if (cursor.getCount()>0){
           return true;
       }else {
           return false;
       }
   }
    public boolean checkEmail(String email){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from users where email=? "
                ,new String[]{email });

        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

}
