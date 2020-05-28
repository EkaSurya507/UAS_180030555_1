package com.bh183.adisurya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 2;
    private final static String DATABASE_NAME = "db_negara";
    private final static String TABLE_NEGARA ="t_negara";
    private final static String KEY_ID_NEGARA = "ID_Negara";
    private final static String KEY_NEGARA = "Negara";
    private final static String KEY_PEMIMPIN = "Pemimpin";
    private final static String KEY_COVER = "Cover";
    private final static String KEY_BAHASA = "Bahasa";
    private final static String KEY_IBUKOTA = "Ibukota";
    private final static String KEY_LUAS = "Luas";
    private final static String KEY_LAGU = "Lagu";
    private final static String KEY_SEJARAH = "Sejarah";
    private Context context;


    public DatabaseHandler(Context ctx){
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_NEGARA = "CREATE TABLE " + TABLE_NEGARA
                + "(" + KEY_ID_NEGARA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NEGARA + " TEXT, " + KEY_PEMIMPIN + " TEXT, "
                + KEY_COVER + " TEXT, " + KEY_BAHASA + " TEXT, "
                + KEY_IBUKOTA + " TEXT, " + KEY_LUAS + " TEXT, " + KEY_LAGU + " TEXT," + KEY_SEJARAH + " TEXT);";

        db.execSQL(CREATE_TABLE_NEGARA);
        inisialisasiNegaraAwal(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NEGARA;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void tambahNegara(Negara dataNegara){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_NEGARA, dataNegara.getNegara());
        cv.put(KEY_PEMIMPIN, dataNegara.getPemimpin());
        cv.put(KEY_COVER, dataNegara.getCover());
        cv.put(KEY_BAHASA, dataNegara.getBahasa());
        cv.put(KEY_IBUKOTA, dataNegara.getIbukota());
        cv.put(KEY_LUAS, dataNegara.getLuas());
        cv.put(KEY_LAGU, dataNegara.getLagu());
        cv.put(KEY_SEJARAH, dataNegara.getSejarah());


        db.insert(TABLE_NEGARA, null, cv);
        db.close();
    }

    public void tambahNegara(Negara dataNegara, SQLiteDatabase db){
        ContentValues cv = new ContentValues();

        cv.put(KEY_NEGARA, dataNegara.getNegara());
        cv.put(KEY_PEMIMPIN, dataNegara.getPemimpin());
        cv.put(KEY_COVER, dataNegara.getCover());
        cv.put(KEY_BAHASA, dataNegara.getBahasa());
        cv.put(KEY_IBUKOTA, dataNegara.getIbukota());
        cv.put(KEY_LUAS, dataNegara.getLuas());
        cv.put(KEY_LAGU, dataNegara.getLagu());
        cv.put(KEY_SEJARAH, dataNegara.getSejarah());
        db.insert(TABLE_NEGARA, null, cv);
    }

    public void editNegara(Negara dataNegara){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_NEGARA, dataNegara.getNegara());
        cv.put(KEY_PEMIMPIN, dataNegara.getPemimpin());
        cv.put(KEY_COVER, dataNegara.getCover());
        cv.put(KEY_BAHASA, dataNegara.getBahasa());
        cv.put(KEY_IBUKOTA, dataNegara.getIbukota());
        cv.put(KEY_LUAS, dataNegara.getLuas());
        cv.put(KEY_LAGU, dataNegara.getLagu());
        cv.put(KEY_SEJARAH, dataNegara.getSejarah());

        db.update(TABLE_NEGARA, cv, KEY_ID_NEGARA + "=?", new String[]{String.valueOf(dataNegara.getIdNegara())});
        db.close();
    }

    public void hapusNegara (int idNegara){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NEGARA, KEY_ID_NEGARA + "=?", new String[]{String.valueOf(idNegara)});
        db.close();
    }

    public ArrayList<Negara> getAllNegara(){
        ArrayList<Negara> dataNegara = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NEGARA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor csr = db.rawQuery(query, null);
        if(csr.moveToFirst()){
            do {
                Negara tempNegara = new Negara(
                        csr.getInt(0),
                        csr.getString(1),
                        csr.getString(2),
                        csr.getString(3),
                        csr.getString(4),
                        csr.getString(5),
                        csr.getString(6),
                        csr.getString(7),
                        csr.getString(8)


                );

                dataNegara.add(tempNegara);
            } while (csr.moveToNext());
        }

        return dataNegara;
    }

    private String storeImageFile(int id) {
        String location;
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), id);
        location = InputActivity.saveImageToInternalStorage(image, context);
        return location;
    }

    private void inisialisasiNegaraAwal(SQLiteDatabase db){
        int idNegara = 0;

        // Menambahkan data negara ke 1
        Negara negara1 = new Negara(
                idNegara,
                "INDONESIA",
                "PRESIDEN (Ir. H. Joko Widodo)",
                storeImageFile(R.drawable.negara1),
                "Bahasa Indonesia",
                "Jakarta",
                "1,905 juta km²",
                "Indonesia Raya",
                "Indonesia disebut juga dengan Republik Indonesia (RI) atau Negara Kesatuan Republik Indonesia (NKRI), adalah negara di Asia Tenggara yang dilintasi garis khatulistiwa dan berada di antara daratan benua Asia dan Australia, serta antara Samudra Pasifik dan Samudra Hindia. Indonesia adalah negara kepulauan terbesar di dunia yang terdiri dari 17.504 pulau.[12] Nama alternatif yang biasa dipakai adalah Nusantara.[13] Dengan populasi Hampir 270.054.853 jiwa pada tahun 2018,[14] Indonesia adalah negara berpenduduk terbesar keempat di dunia dan negara yang berpenduduk Muslim terbesar di dunia, dengan lebih dari 230 juta jiwa."
        );

        tambahNegara(negara1, db);
        idNegara++;

        // Menambahkan data negara ke 2
        Negara negara2 = new Negara(
                idNegara,
                "SINGAPURA",
                "PRESIDEN (Halimah Yacob)",
                storeImageFile(R.drawable.negara2),
                "Bahasa Melayu",
                "Singapura",
                "721,5 km²",
                "Majulah Singapura",
                "Singapura (nama resmi: Republik Singapura) adalah sebuah negara pulau di lepas ujung selatan Semenanjung Malaya, 137 kilometer (85 mi) di utara khatulistiwa di Asia Tenggara. Negara ini terpisah dari Malaysia oleh Selat Johor di utara, dan dari Kepulauan Riau, Indonesia oleh Selat Singapura di selatan. Singapura adalah pusat keuangan terdepan ketiga di dunia dan sebuah kota dunia kosmopolitan yang memainkan peran penting dalam perdagangan dan keuangan internasional. Pelabuhan Singapura adalah satu dari lima pelabuhan tersibuk di dunia."
        );

        tambahNegara(negara2, db);
        idNegara++;

        // Menambahkan data negara ke 3
        Negara negara3 = new Negara(
                idNegara,
                "THAILAND",
                "RAJA (Vajiralongkorn)",
                storeImageFile(R.drawable.negara3),
                "Bahasa Thai",
                "Bangkok",
                "513.120 km²",
                "Phleng Chat Thai",
                "Kerajaan Thai nama resmi bahasa Thai: Ratcha Anachak Thai, Raja Adnyacakra Thai; atau Prathēt Thai, Pradesa Thai, yang lebih sering disebut Thailand dalam bahasa Inggris, atau dalam bahasa aslinya Mueang Thai dibaca: meng-thai, sama dengan versi Inggrisnya, berarti Negeri Thai, adalah sebuah negara di Asia Tenggara yang berbatasan dengan Laos dan Kamboja di timur, Malaysia dan Teluk Siam di selatan, dan Myanmar dan Laut Andaman di barat. Kerajaan Thai dahulu dikenal sebagai Siam sampai tanggal 11 Mei 1949. Kata Thai berarti kebebasan dalam bahasa Thai, tetapi juga dapat merujuk kepada suku Thai, sehingga menyebabkan nama Siam masih digunakan di kalangan warga negara Thai terutama kaum minoritas Tionghoa dan Amerika."
        );

        tambahNegara(negara3, db);
        idNegara++;

    }
}
