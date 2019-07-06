package pakiet.konrad.biblia52.BazaDanych;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Slownik_fts3 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Slownik.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Tabela_slownik";
    public static final String NUMER_KSIEGI = "numer_ksiegi";
    public static final String NUMER_ROZDZIALU = "numer_rozdzialu";
    public static final String NUMER_WERSETU = "numer_wersetu";
    public static final String TRESC_WERSETU  = "tresc_wersetu";
    private static final String FTS_VIRTUAL_TABLE = "FTS";
    private Slownik_fts3 slownikFts3;
    private Context mContext;
    private SQLiteDatabase mDatabase;



    private static final String FTS_TABLE_CREATE =
            "CREATE VIRTUAL TABLE IF NOT EXISTS  " + TABLE_NAME +
                    " USING fts3 (" +
                    NUMER_KSIEGI + ", " +
                    NUMER_ROZDZIALU + ", " +
                    NUMER_WERSETU + ","+
                    TRESC_WERSETU+")";
    public Slownik_fts3(Context context) {
        super(context,TABLE_NAME,null,DATABASE_VERSION);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mDatabase = db;
        mDatabase.execSQL(FTS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
        onCreate(db);
    }
    public boolean open() throws SQLException {
        try{
            this.slownikFts3 = new Slownik_fts3(mContext);
            this.mDatabase = this.slownikFts3.getWritableDatabase();
            return this.mDatabase.isOpen();
        }catch (SQLException e) {
            throw e;
        }
    }
    public boolean isOpen(){

        return this.slownikFts3.isOpen();
    }
    public boolean zamknij()
    {  this.mDatabase.close();
        return !this.slownikFts3.isOpen();
    }
    public void insertRow(String numer_ksiegi1, String numer_Rozdzialu1, String numer_wersetu1, String tresc_wersetu1) {


        ContentValues values = new ContentValues();
        values.put(NUMER_KSIEGI, numer_ksiegi1);
        values.put(NUMER_ROZDZIALU, numer_Rozdzialu1);
        values.put(NUMER_WERSETU, numer_wersetu1);
        values.put(TRESC_WERSETU, tresc_wersetu1);


        this.mDatabase.insert(TABLE_NAME, null, values);

    }


    public List<String> pokaz_slownik() {
        List<String> ListaWersetow = new ArrayList<>();
        open();
        Cursor k = mDatabase.rawQuery("select tresc_wersetu from Tabela_slownik",null);
        k.moveToFirst();
        while (!k.isAfterLast()) {

            String trescwersu_cur = k.getString(0);

            ListaWersetow.add(trescwersu_cur);

            k.moveToNext();

        }
        k.close();
        return ListaWersetow;
    }
    public  Cursor PokaszWyszukaneSlowa(String SzukaneSlowo)
    {
        open();
        String[] ksiegi = {SzukaneSlowo};
        String MySQL = "select numer_ksiegi,numer_rozdzialu,numer_wersetu,tresc_wersetu from Tabela_slownik Where tresc_wersetu MATCH ? ;";

        return mDatabase.rawQuery(MySQL, ksiegi);
    }




}
