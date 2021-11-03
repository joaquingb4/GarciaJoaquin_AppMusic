package DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

import com.example.garciajoaquin_appmusic.Song;

public class SongsDBHelper extends SQLiteOpenHelper {
    //Attributes
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "songs.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            SongsContract.SongsEntry.TABLE_NAME + "(" + SongsContract.SongsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SongsContract.SongsEntry.COLUMN_NAME_NAME + " TEXT," +
            SongsContract.SongsEntry.COLUMN_NAME_AUTOR + " TEXT," +
            SongsContract.SongsEntry.COLUMN_NAME_DURATION + " TEXT)"
            ;

    public void insertContact(SQLiteDatabase db, Song song){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(SongsContract.SongsEntry.COLUMN_NAME_NAME, song.getName());
            values.put(SongsContract.SongsEntry.COLUMN_NAME_AUTOR,song.getAutor());
            values.put(SongsContract.SongsEntry.COLUMN_NAME_DURATION, song.getDuration());

            db.insert(SongsContract.SongsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }


    public SongsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //Methods
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
