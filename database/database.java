package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public static final String database_name="student.db";
    public static final String table_name="student_table";
    public static final String col_1="ID";
    public static final String col_2="NAME";
    public static final String col_3="SURNAME";
    public static final String col_4="MARKS";

    public database(@Nullable Context context) {
        super(context, database_name, null, 1);
            SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_name);
            onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String name,String surname,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(col_2,name);
        contentValues.put(col_3,surname);
        contentValues.put(col_4,marks);
        long result=db.insert(table_name,null ,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public Cursor getAlldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+ table_name,null);
        return res;

    }
    public boolean updatedata(String id,String name,String surname,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,name);
        contentValues.put(col_3,surname);
        contentValues.put(col_4,marks);
        db.update(table_name,contentValues,"ID = ?",new String[] {id });
        return true;
    }
    public Integer deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(table_name,"ID = ?",new String[] {id });

    }
}
