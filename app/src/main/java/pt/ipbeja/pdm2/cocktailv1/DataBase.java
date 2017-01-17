package pt.ipbeja.pdm2.cocktailv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.pdm2.cocktailv1.Model.Cocktail;

/**
 * Created by MLGDuck on 10/01/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final String DB_FILENAME = "Cocktails.db";
    private static int DB_VERSION = 28;
    private static final SQLiteDatabase.CursorFactory factory = null;

    private static final int T_COCKTAIL = 0;

    // array com todos os nomes das tabelas
    private static final String[] TableNames = {
            "cocktail"
    };


    // todas as colunas da tabela "cocktail"
    private static final String T_COCKTAIL_ID = "id";
    private static final String T_COCKTAIL_TITLE = "title";
    private static final String T_COCKTAIL_INGR = "ingredientes";
    private static final String T_COCKTAIL_PREP = "preparacao";

    // string sql para criar tabela "COCKTAIL"
    private static final String T_CREATE_COCKTAIL =
            "CREATE TABLE " + TableNames[0] +
                    "(" + T_COCKTAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", " + T_COCKTAIL_TITLE + " TEXT NOT NULL UNIQUE " +
                    ", " + T_COCKTAIL_INGR + " TEXT NOT NULL UNIQUE " +
                    ", " + T_COCKTAIL_PREP + " TEXT NOT NULL UNIQUE) "
            ;

    // todas os comandos sql de criação de tabelas
    private static final String[] T_CREATE = {
            T_CREATE_COCKTAIL
    };

    public DataBase(Context context) {
        super(context, DB_FILENAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int i = 0; i < T_CREATE.length; i++) {
            db.execSQL(T_CREATE[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        for (int i = 0; i < TableNames.length; i++) {
            db.execSQL("DROP TABLE IF EXISTS " + TableNames[i]);
        }
        DB_VERSION +=1;
        onCreate(db);

    }

   public List<String> getAllCocktailsTitles() {
        List<String> cocktails = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_COCKTAIL_TITLE  +" FROM " + TableNames[T_COCKTAIL];
        Cursor cursor = db.rawQuery(sql, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Toast.makeText(null, "", Toast.LENGTH_SHORT).show();
               cocktails.add(cursor.getString(cursor.getColumnIndex(T_COCKTAIL_TITLE)));

                // adding to contacts list
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cocktails;
    }
    public List<Cocktail> getAllCocktails() {
        List<Cocktail> cocktails = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + "*"  +" FROM " + TableNames[T_COCKTAIL];
        Cursor cursor = db.rawQuery(sql, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Toast.makeText(null, "", Toast.LENGTH_SHORT).show();
                //cocktails.add(cursor.getString(cursor.getColumnIndex(T_COCKTAIL_TITLE)));
                Cocktail c = new Cocktail(cursor.getInt(cursor.getColumnIndex(T_COCKTAIL_ID)),cursor.getString(cursor.getColumnIndex(T_COCKTAIL_TITLE)),cursor.getString(cursor.getColumnIndex(T_COCKTAIL_INGR)),cursor.getString(cursor.getColumnIndex(T_COCKTAIL_PREP)));
                cocktails.add(c);

                // adding to contacts list
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cocktails;
    }

    public long insertcocktails(Cocktail cocktail)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T_COCKTAIL_ID, cocktail.getCocktailId());
        contentValues.put(T_COCKTAIL_TITLE, cocktail.getCocktailTitle() );
        contentValues.put(T_COCKTAIL_INGR, cocktail.getCocktailIngre());
        contentValues.put(T_COCKTAIL_PREP, cocktail.getCocktailPrep());

        long cocktailid = db.insert(TableNames[T_COCKTAIL], null, contentValues);
        return cocktailid;
    }
    public Cocktail GetCocktail(int id)
    {Cocktail cocktail = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_COCKTAIL_TITLE +", " +T_COCKTAIL_INGR + ", "+ T_COCKTAIL_PREP  +" FROM " + TableNames[T_COCKTAIL] + " WHERE " + T_COCKTAIL_ID + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
              String title = cursor.getString(cursor.getColumnIndex(T_COCKTAIL_TITLE));
               String ingred = cursor.getString(cursor.getColumnIndex(T_COCKTAIL_INGR));
                String prep = cursor.getString(cursor.getColumnIndex(T_COCKTAIL_PREP));
                cocktail = new Cocktail(id, title, ingred, prep);


                // adding to contacts list
            } while (cursor.moveToNext());
        }
        cursor.close();
        return  cocktail;
    }
}
