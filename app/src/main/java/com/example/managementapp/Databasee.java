package com.example.managementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Databasee extends SQLiteOpenHelper {
    public  static final String databaseName="app.db";
    //affected
    public static final String TABLE_NAME="mylist_data";
    public static final String COL1="ID";
    public static final String updates="ITEM1";

    public Databasee(Context context) {
        super(context, databaseName, null, 1);
    }




    private void createItem(SQLiteDatabase db){
String qry="create table tb1_contact (id integer primary key autoincrement, name text)";
db.execSQL(qry);


    }
//public void onupGrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
//        String qry="DROP TABLE IF EXISTS tb1_contact";
//        sqLiteDatabase.execSQL(qry);
//        onCreate(sqLiteDatabase);
//}

public Boolean addrecord(String item1){
    SQLiteDatabase myDatabase=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
      contentValues.put("name", item1);
    long result =myDatabase.insert("tb1_contact", null,contentValues);
    if (result==-1) return false;
    else
        return true;

}

public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select * from tb1_contact order by id desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;
}



    private void createJob(SQLiteDatabase db){

        String qry="create table tb1_job (id integer primary key autoincrement, name text, job text)";
        db.execSQL(qry);

    }

    public void onupGrad(SQLiteDatabase sqLiteDatabase, int i, int i1){
        String qry="DROP TABLE IF EXISTS tb1_job";
//        sqLiteDatabase.execSQL(qry);
//        onCreate(sqLiteDatabase);
    }
    public Boolean addjob(String job, String name){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("name",name);
        contentValues.put("job",job);
        long result =myDatabase.insert("tb1_job", null,contentValues);
        if (result==-1){ return false;}
        else
        { return true;}

    }

    public Cursor readalljob(){
        SQLiteDatabase db = this.getWritableDatabase();
       String qry="select * from tb1_job order by id desc";
        return db.rawQuery(qry,null);
    }



    private void createVacancy(SQLiteDatabase db){

        String qry="create table tb_Vacancy (id integer primary key autoincrement, vacancy text)";
        db.execSQL(qry);

    }

    public Boolean addVacancy(String vacancy){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("vacancy", vacancy);

        long result =myDatabase.insert("tb_Vacancy", null,contentValues);
        if (result==-1){ return false;}
        else
        { return true;}

    }

    public Cursor readallVacancy(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select * from tb_Vacancy order by id desc";
        return db.rawQuery(qry,null);
    }

    public Cursor getVacancyID(String vacancyy){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select id from tb_Vacancy  where vacancy ='"+vacancyy+"'";
        return db.rawQuery(qry,null);
    }

    public void updateVacancy(String newVacancy, int id, String oldVacancy){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry=" update tb_Vacancy set vacancy ='"+newVacancy+"' where id ='"+ id +"' and vacancy ='"+oldVacancy+"'";
        db.execSQL(qry);
    }
    public void deleteVacancy(String vacancyy, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String  qry="delete from tb_Vacancy where id ='"+id+"' and vacancy ='"+vacancyy+"'";
        db.execSQL(qry);
    }












///// updates
private void createUpdates(SQLiteDatabase db){

    String qry="create table tb_updates (id integer primary key autoincrement, updates text)";
    db.execSQL(qry);
    }
    public boolean addUpdates(String updates){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("updates", updates);

      float result =myDatabase.insert("tb_updates", null,contentValues);
        if (result==-1)
            return false;

        else
        { return true;}

    }

    public Cursor readallUpdates(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select * from tb_updates order by id desc";
        return db.rawQuery(qry,null);
    }
    public Cursor getUpdatesID(String update){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry="select id from tb_updates  where updates ='"+update+"'";
        return db.rawQuery(qry,null);
    }
     public void updateUpdate(String newUpdate, int id, String oldUpdate){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry=" update tb_updates set updates ='"+newUpdate+"' where id ='"+ id +"' and updates ='"+oldUpdate+"'";
        db.execSQL(qry);
     }
    public void deleteUpdate(String update, int id){
        SQLiteDatabase db = this.getWritableDatabase();
       String  qry="delete from tb_updates where id ='"+id+"' and updates ='"+update+"'";
        db.execSQL(qry);
    }





























    /////updates




















    private void createEmployeeTable(SQLiteDatabase c) {
        c.execSQL(
                "CREATE TABLE IF NOT EXISTS employees (\n" +
                        "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "    name varchar(200) NOT NULL,\n" +
                        "    department varchar(200) NOT NULL,\n" +
                        "    joiningdate datetime NOT NULL,\n" +
                        "    salary double NOT NULL\n" +
                        ");"
        );
    }
    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(username TEXT primary key,password TEXT)");
        createEmployeeTable(myDatabase);
        createItem(myDatabase);
        createJob(myDatabase);
       //myDatabase.execSQL("create table tb_Vacancy (id integer primary key autoincrement, vacancy text)");
        createVacancy(myDatabase);
        createUpdates(myDatabase);


    }
    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int oldVersion, int newVersion) {
     myDatabase.execSQL("drop Table if exists users ");
        myDatabase.execSQL("drop Table if exists tb_Vacancy ");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb1_contact");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb1_job");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb_updates");
    }
    public Boolean insertData (String  username, String password){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result =myDatabase.insert("users", null,contentValues);
        if (result==-1) return false;
        else
            return true;

    }

    public Boolean insertEmpData (String  name, String department, double salary){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("department", department);
        contentValues.put("joiningdate", String.valueOf(new Date()));
        contentValues.put("salary", salary);
        long result =myDatabase.insert("employees", null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }
    public Boolean userr (String username ){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        Cursor  cursor=myDatabase.rawQuery("select * from users where username=? ", new String[] {username} );
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public Boolean passwordmetod(String username, String password){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        Cursor  cursor=myDatabase.rawQuery("select * from users where username=?  and password=?", new String[] {username,password} );
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getEmployee(){
        SQLiteDatabase myDatabase=this.getReadableDatabase();
        Cursor employees = myDatabase.rawQuery("SELECT * FROM employees", null);
        return employees;




        

    }


    }
