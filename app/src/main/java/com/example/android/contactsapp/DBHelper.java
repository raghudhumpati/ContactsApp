package com.example.android.contactsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ANDROID on 6/10/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME="mycontactlist";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "PhoneNo";


    public DBHelper(Context context) {
        super(context, "mycontactslist.db", null, 1);
        SQLiteDatabase mydb=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table"+TABLE_NAME+"("+COL_1+" text,"+COL_2+" text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);

    }

    public void insertdata(String name,String phoneno)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();

        ContentValues cvalues=new ContentValues();

        cvalues.put(COL_1,name);
        cvalues.put(COL_2,phoneno);

        mydb.insert(TABLE_NAME,null,cvalues);


    }
}
