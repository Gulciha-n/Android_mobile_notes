package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null); //create database
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR , age INTEGER)"); //add table , execute SQL

            //add data
            //database.execSQL("INSERT INTO musicians(name,age) VALUES ('Tom',25)");  //save data - * = everything
            //database.execSQL("INSERT INTO musicians(name,age) VALUES ('Maria',30)");
            //database.execSQL("INSERT INTO musicians(name,age) VALUES ('James',45)");

            //update data
            //database.execSQL("UPDATE musicians SET age=28 WHERE name='Tom'");
            //database.execSQL("UPDATE musicians SET name='Tom Eric' WHERE id = 1");

            //delete data
            database.execSQL("DELETE FROM musicians WHERE id = 3");

            Cursor cursor = database.rawQuery("SELECT * FROM musicians ", null);   //read data - null= unfiltered
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name='Maria'", null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE  name LIKE '%a'",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE  name LIKE 'T%'",null);
            
            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name : " + cursor.getString(nameIx));
                System.out.println("Age : " + cursor.getString(ageIx));
                System.out.println("Id : "+ cursor.getString(idIx));
            }
            cursor.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}