package se.wibi.anteckningar;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper implements DatabaseStatics{

	public DatabaseHelper(Context context, String name, CursorFactory factory, 	int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	/*
	public final int DATABASE_VERSION = 0;
	public final String DATABASE_NAME = "notes";
	public final String TABLE_NAME = "textNote";
	public final String NOTEBOOK_TEXT = "text";
	public final String NOTEBOOK_IMAGE = "image";
	public final String NOTEBOOK_DATE = "date";
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		 String CREATE_TEXT_TABLE = "CREATE TABLE " + TABLE_NAME + "("
	                + _ID + " INTEGER PRIMARY KEY," + NOTEBOOK_TEXT + " TEXT,"	               
	               + NOTEBOOK_DATE + " TEXT" + ")";
	     db.execSQL(CREATE_TEXT_TABLE);
	     String CREATE_IMAGE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
	                + _ID + " INTEGER PRIMARY KEY," + NOTEBOOK_IMAGE + " TEXT," + NOTEBOOK_DATE + " TEXT" + ")";
	     db.execSQL(CREATE_IMAGE_TABLE);	     
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
		
	}
	public String getDateNow(){
		SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
		String format = s.format(new Date());
		return format;
	}
	public List<Notes> getAllTextNotes(){
		List<Notes> rowList = new ArrayList<Notes>();
		// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
               	Notes notes = new Notes();
                notes.setText(cursor.getString(1));
                notes.setImages(cursor.getString(2));
                notes.setDate(cursor.getString(3));
                    // Adding contact to list
                rowList.add(notes);
            } while (cursor.moveToNext());
        }
		
		return rowList;
	}
	public List<Notes> getAllNotes(){
        List<Notes> rowList = new ArrayList<Notes>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
               	Notes notes = new Notes();
                notes.setText(cursor.getString(1));
                notes.setImages(cursor.getString(2));
                notes.setDate(cursor.getString(3));
                    // Adding contact to list
                rowList.add(notes);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return rowList;
    }

}
