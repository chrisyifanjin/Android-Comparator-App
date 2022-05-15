package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper {


    private static final int VERSION = 1;

    public static final String DATABASE = "JOBCOMPARE.db";          //database

    public static final String MY_JOB_TABLE = "my_table";           //my job
    public static final String JOB_LIST_TABLE = "list_table";       //job list
    public static final String WEIGHT_TABLE = "weight_table";       //weight

    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "COMPANY";
    public static final String COL_4 = "LOCATION";
    public static final String COL_5 = "COST";
    public static final String COL_6 = "SALARY";
    public static final String COL_7 = "BONUS";
    public static final String COL_8 = "BENEFITS";
    public static final String COL_9 = "STIPEND";
    public static final String COL_10 = "AWARD";
    public static final String COL_11 = "SCORE";

    public static final String COL_WEIGHT_0 = "ID";
    public static final String COL_WEIGHT_1 = "SALARY";
    public static final String COL_WEIGHT_2 = "BONUS";
    public static final String COL_WEIGHT_3 = "BENEFITS";
    public static final String COL_WEIGHT_4 = "STIPEND";
    public static final String COL_WEIGHT_5 = "AWARD";


    private static final String CREATE_MY_JOB_TABLE = "CREATE TABLE "
            + MY_JOB_TABLE
            + "("
            + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_2 + " TEXT,"
            + COL_3 + " TEXT,"
            + COL_4 + " TEXT,"
            + COL_5 + " INTEGER,"
            + COL_6 + " INTEGER,"
            + COL_7 + " INTEGER,"
            + COL_8 + " INTEGER,"
            + COL_9 + " INTEGER,"
            + COL_10 + " INTEGER,"
            + COL_11 + " INTEGER"
            + ")";

    private static final String CREATE_JOB_LIST_TABLE = "CREATE TABLE "
            + JOB_LIST_TABLE
            + "("
            + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_2 + " TEXT,"
            + COL_3 + " TEXT,"
            + COL_4 + " TEXT,"
            + COL_5 + " INTEGER,"
            + COL_6 + " INTEGER,"
            + COL_7 + " INTEGER,"
            + COL_8 + " INTEGER,"
            + COL_9 + " INTEGER,"
            + COL_10 + " INTEGER,"
            + COL_11 + " INTEGER"
            + ")";

    private static final String WEIGHT_TABLE_TABLE = "CREATE TABLE "
            + WEIGHT_TABLE
            + "("
            + COL_WEIGHT_0 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_WEIGHT_1 + " INTEGER,"
            + COL_WEIGHT_2 + " INTEGER,"
            + COL_WEIGHT_3 + " INTEGER,"
            + COL_WEIGHT_4 + " INTEGER,"
            + COL_WEIGHT_5 + " INTEGER"
            + ")";

    public DB(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MY_JOB_TABLE);
        db.execSQL(CREATE_JOB_LIST_TABLE);
        db.execSQL(WEIGHT_TABLE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists " + MY_JOB_TABLE);
        db.execSQL("DROP TABLE if exists " + JOB_LIST_TABLE);
        db.execSQL("DROP TABLE if exists " + WEIGHT_TABLE);
        onCreate(db);
    }

    //job - current job, job offer
    public boolean insertJobData(String title,
                                 String company,
                                 String location,
                                 String cost,
                                 String salary,
                                 String bonus,
                                 String benefits,
                                 String stipend,
                                 String award,
                                 String score,
                                 String table) {        //table can be CREATE_MY_JOB_TABLE or CREATE_JOB_LIST_TABLE
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, company);
        contentValues.put(COL_4, location);
        contentValues.put(COL_5, cost);
        contentValues.put(COL_6, salary);
        contentValues.put(COL_7, bonus);
        contentValues.put(COL_8, benefits);
        contentValues.put(COL_9, stipend);
        contentValues.put(COL_10, award);
        contentValues.put(COL_11, score);

        long result = db.insert(table, null, contentValues);

        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public void updateJobData(String id,
                              String title,
                              String company,
                              String location,
                              String cost,
                              String salary,
                              String bonus,
                              String benefits,
                              String stipend,
                              String award,
                              String score,
                              String table) { //table can be CREATE_MY_JOB_TABLE or CREATE_JOB_LIST_TABLE

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, company);
        contentValues.put(COL_4, location);
        contentValues.put(COL_5, cost);
        contentValues.put(COL_6, salary);
        contentValues.put(COL_7, bonus);
        contentValues.put(COL_8, benefits);
        contentValues.put(COL_9, stipend);
        contentValues.put(COL_10, award);
        contentValues.put(COL_11, score);
        db.update(table, contentValues, "ID = ?", new String[] { id} );
    }

    //weight
    public boolean insertWeightData(String salary,
                                 String bonus,
                                 String benefits,
                                 String stipend,
                                 String award) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_WEIGHT_1, salary);
        contentValues.put(COL_WEIGHT_2, bonus);
        contentValues.put(COL_WEIGHT_3, benefits);
        contentValues.put(COL_WEIGHT_4, stipend);
        contentValues.put(COL_WEIGHT_5, award);

        long result = db.insert(WEIGHT_TABLE, null, contentValues);

        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public void updateWeightData(String id,
                                 String salary,
                                 String bonus,
                                 String benefits,
                                 String stipend,
                                 String award) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_WEIGHT_0, id);
        contentValues.put(COL_WEIGHT_1, salary);
        contentValues.put(COL_WEIGHT_2, bonus);
        contentValues.put(COL_WEIGHT_3, benefits);
        contentValues.put(COL_WEIGHT_4, stipend);
        contentValues.put(COL_WEIGHT_5, award);
        db.update(WEIGHT_TABLE, contentValues, "ID = ?", new String[] { id} );
    }

    //get table list from db by name of table in db
    public Cursor getAllData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor list = db.rawQuery("select * from "+ name, null);
        return list;
    }

    //get table list from db by name of table in db
    public Cursor getFirstData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor list = db.rawQuery("select * from "+ name + " limit 1", null);
        return list;
    }

}
