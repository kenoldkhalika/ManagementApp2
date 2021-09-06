package com.example.managementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Databasee extends SQLiteOpenHelper {
    public static final String databaseName = "app.db";
    //affected
    public static final String TABLE_NAME = "mylist_data";
    public static final String COL1 = "ID";
    public static final String updates = "ITEM1";
    Context context;

    public Databasee(Context context) {
        super(context, databaseName, null, 1);
    }


    private void createItem(SQLiteDatabase db) {
        String qry = "create table tb1_contact (id integer primary key autoincrement, name text)";
        db.execSQL(qry);


    }
//public void onupGrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
//        String qry="DROP TABLE IF EXISTS tb1_contact";
//        sqLiteDatabase.execSQL(qry);
//        onCreate(sqLiteDatabase);
//}

    public Boolean addrecord(String item1) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", item1);
        long result = myDatabase.insert("tb1_contact", null, contentValues);
        if (result == -1) return false;
        else
            return true;

    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tb1_contact order by id desc";
        Cursor cursor = db.rawQuery(qry, null);
        return cursor;
    }


    private void createJob(SQLiteDatabase db) {

        String qry = "create table tb1_job (id integer primary key autoincrement, name text, job text)";
        db.execSQL(qry);

    }

    public void onupGrad(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = "DROP TABLE IF EXISTS tb1_job";
//        sqLiteDatabase.execSQL(qry);
//        onCreate(sqLiteDatabase);
    }

    public Boolean addjob(String job, String name) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("job", job);
        long result = myDatabase.insert("tb1_job", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor readalljob() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tb1_job order by id desc";
        return db.rawQuery(qry, null);
    }

    public Cursor getJobID(String names, String jobs) {
        SQLiteDatabase db = this.getReadableDatabase();
//       String qry="select id from tb1_job where name='"+names+"' job= '"+jobs+"'";
        String qry = "select id from tb1_job where name=? and job=?";
        // String qry = "select id from tb1_job where name = " +names+ " and job = " +jobs ;
        return db.rawQuery(qry, new String[]{names, jobs});
    }

    public void updateJob(String newName, String newJob, Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
//        Toast.makeText(context.getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
//        String qry=" update tb1_job set name ='"+newName+"' job ='"+newJob+"' where id ='"+ id +"' name ='"+oldName+"' and job='"+oldJob+"'";
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", newName);
        contentValues.put("job", newJob);
        db.update("tb1_job", contentValues, "id=?", new String[]{String.valueOf(id)});
    }

    public void deleteJob(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "delete from tb1_job where id =?";

//        String  qry="delete from tb1_job where id ='"+id+"' name=? and job=?";
        db.execSQL(qry, new Integer[]{id});
    }

    public List<String> searchEmp(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> searchResults = new ArrayList<>();

        String queryString = "select name, job from tb1_job where name like ?";

        Cursor cursor = db.rawQuery(queryString, new String[]{"%" + name + "%"});

        if (cursor.moveToFirst()) {
            do {
                String nameEmp = cursor.getString(0);
                String jobName = cursor.getString(1);

                String searchText = "NAME :" + nameEmp + "\nJOB :" + jobName;
                searchResults.add(searchText);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return searchResults;
    }
// add new employee

    private void createNewEmployee(SQLiteDatabase db) {

        String qry = "create table tb1_newEmployee (id integer primary key autoincrement, fname text, lname text, adress text, nextOfKin text)";
        db.execSQL(qry);

    }

    public Boolean addNewEmployee(String fname, String lname, String adress, String nextOfKin) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("fname", fname);
        contentValues.put("lname", lname);
        contentValues.put("adress", adress);
        contentValues.put("nextOfKin", nextOfKin);
//        contentValues.put("phoneNumber",phoneNumber);
//        contentValues.put("salary",salary);
        long result = myDatabase.insert("tb1_newEmployee", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor readallNewEmployee() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tb1_newEmployee order by id desc";
        return db.rawQuery(qry, null);
    }

    public Cursor getEmployeeID(String fnames, String lnames, String adress, String nextofkin) {
        SQLiteDatabase db = this.getReadableDatabase();
//       String qry="select id from tb1_job where name='"+names+"' job= '"+jobs+"'";
        String qry = "select id from tb1_newEmployee where fname=? and lname= ? and adress=? and  nextOfKin=?";
        // String qry = "select id from tb1_job where name = " +names+ " and job = " +jobs ;
        return db.rawQuery(qry, new String[]{fnames, lnames, adress, nextofkin});


    }

    public void deleteEmpDetails(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "delete from tb1_newEmployee where id =?";

//        String  qry="delete from tb1_job where id ='"+id+"' name=? and job=?";
        db.execSQL(qry, new Integer[]{id});
    }


    public void updateEmployee(String fname, String lname, String adress, String nextOfkin, Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
//        Toast.makeText(context.getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
//        String qry=" update tb1_job set name ='"+newName+"' job ='"+newJob+"' where id ='"+ id +"' name ='"+oldName+"' and job='"+oldJob+"'";
        ContentValues contentValues = new ContentValues();

        contentValues.put("fname", fname);
        contentValues.put("lname", lname);
        contentValues.put("adress", adress);
        contentValues.put("nextOfkin", nextOfkin);
        db.update("tb1_newEmployee", contentValues, "id=?", new String[]{String.valueOf(id)});
    }

    public List<String> searchEmpDetails(String fname) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> searchResults = new ArrayList<>();

        String queryString = "select fname, lname,adress,nextOfKin from tb1_newEmployee where fname like ?";

        Cursor cursor = db.rawQuery(queryString, new String[]{"%" + fname + "%"});

        if (cursor.moveToFirst()) {
            do {
                String finame = cursor.getString(0);
                String ltname = cursor.getString(1);
                String address = cursor.getString(2);
                String nextOfKinn = cursor.getString(3);

                String searchText = "NAME :" + finame + "\nJOB :" + ltname + "\nADDRESS :" + address + "\nNEXT OF KIN :" + nextOfKinn;
                searchResults.add(searchText);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return searchResults;
    }


    // end of adding employee


    private void createVacancy(SQLiteDatabase db) {

        String qry = "create table tb_Vacancy (id integer primary key autoincrement, vacancy text)";
        db.execSQL(qry);

    }

    public Boolean addVacancy(String vacancy) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("vacancy", vacancy);

        long result = myDatabase.insert("tb_Vacancy", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor readallVacancy() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tb_Vacancy order by id desc";
        return db.rawQuery(qry, null);
    }

    public Cursor getVacancyID(String vacancyy) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select id from tb_Vacancy  where vacancy ='" + vacancyy + "'";
        return db.rawQuery(qry, null);
    }

    public void updateVacancy(String newVacancy, int id, String oldVacancy, Context context1) {
        SQLiteDatabase db = this.getWritableDatabase();
        Toast.makeText(context1, "updated", Toast.LENGTH_LONG).show();
        String qry = " update tb_Vacancy set vacancy ='" + newVacancy + "' where id ='" + id + "' and vacancy ='" + oldVacancy + "'";
        db.execSQL(qry);
    }

    public void deleteVacancy(String vacancyy, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "delete from tb_Vacancy where id ='" + id + "' and vacancy ='" + vacancyy + "'";
        db.execSQL(qry);
    }


    ///// updates
    private void createUpdates(SQLiteDatabase db) {

        String qry = "create table tb_updates (id integer primary key autoincrement, updates text)";
        db.execSQL(qry);
    }

    public boolean addUpdates(String updates) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("updates", updates);

        float result = myDatabase.insert("tb_updates", null, contentValues);
        if (result == -1)
            return false;

        else {
            return true;
        }

    }

    public Cursor readallUpdates() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tb_updates order by id desc";
        return db.rawQuery(qry, null);
    }

    public Cursor getUpdatesID(String update) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select id from tb_updates  where updates ='" + update + "'";
        return db.rawQuery(qry, null);
    }

    public void updateUpdate(String newUpdate, int id, String oldUpdate, Context context1) {
        SQLiteDatabase db = this.getWritableDatabase();
        Toast.makeText(context1, "updated", Toast.LENGTH_LONG).show();
        String qry = " update tb_updates set updates ='" + newUpdate + "' where id ='" + id + "' and updates ='" + oldUpdate + "'";
        db.execSQL(qry);
    }

    public void deleteUpdate(String update, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "delete from tb_updates where id ='" + id + "' and updates ='" + update + "'";
        db.execSQL(qry);
    }


    /////updates


//    private void createEmployeeTable(SQLiteDatabase c) {
//        c.execSQL(
//                "CREATE TABLE IF NOT EXISTS employees (\n" +
//                        "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
//                        "    name varchar(200) NOT NULL,\n" +
//                        "    department varchar(200) NOT NULL,\n" +
//                        "    joiningdate datetime NOT NULL,\n" +
//                        "    salary double NOT NULL\n" +
//                        ");"
//        );
//    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(username TEXT primary key,password TEXT)");
        createEmployeeTable(myDatabase);
        createItem(myDatabase);
        createJob(myDatabase);
        //myDatabase.execSQL("create table tb_Vacancy (id integer primary key autoincrement, vacancy text)");
        createVacancy(myDatabase);
        createUpdates(myDatabase);
        createNewEmployee(myDatabase);


    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int oldVersion, int newVersion) {
        myDatabase.execSQL("drop Table if exists users ");
        myDatabase.execSQL("drop Table if exists tb_Vacancy ");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb1_contact");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb1_job");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb_updates");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb_employee");
        myDatabase.execSQL("DROP TABLE IF EXISTS tb1_newEmployee");
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDatabase.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;

    }

    private void createEmployeeTable(SQLiteDatabase db) {
        String qry = "create table employees (id integer primary key autoincrement, firstName text, lastName text, adress text, nextOfKin text, phone double, department text, salary interger )";
        db.execSQL(qry);
    }

    public Boolean insertEmpData(String firstName, String lastName, String adress, String nextOfKin, double phone, String department, double salary) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", firstName);
        contentValues.put("department", lastName);
        contentValues.put("adress", adress);
        contentValues.put("nextOfKin", nextOfKin);
        contentValues.put("phone", phone);
        contentValues.put("department", department);
        contentValues.put("salary", salary);

        long result = myDatabase.insert("employees", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean userr(String username) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from users where username=? ", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    public Boolean passwordmetod(String username, String password) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from users where username=?  and password=?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor getEmployee() {
        SQLiteDatabase myDatabase = this.getReadableDatabase();
        Cursor employees = myDatabase.rawQuery("SELECT * FROM employees", null);
        return employees;


    }


}
