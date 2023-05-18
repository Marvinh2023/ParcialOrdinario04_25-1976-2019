package utec.edu.sv.parcial04ordinario.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baseHelper extends SQLiteOpenHelper {

    private static final int version_basedatos=1;
    private static final String NOMBRE_BASE="BDPARCIAL04.db";
    public static final String NOMBRE_TABLA_CLIENTES="t_clientes";
    private static final String NOMBRE_TABLA_VEHICULOS="t_vehiculos";

    public baseHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, version_basedatos);
    }
    public SQLiteDatabase getWritableDatabaseWithJournal() {
        SQLiteDatabase db = getWritableDatabase();
        disableWriteAheadLogging(db); // Deshabilitar el modo WAL para la instancia de la base de datos
        return db;
    }

    private void disableWriteAheadLogging(SQLiteDatabase db) {
        db.disableWriteAheadLogging(); // Deshabilitar el modo WAL para la instancia de la base de datos
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +NOMBRE_TABLA_CLIENTES + "("+
                "IDCLIENTE INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NOMBRECLIENTE TEXT NOT NULL, "+
                "APELLIDOCLIENTE TEXT NOT NULL, "+
                "DIRECCIONCLIENTE  TEXT NOT NULL,"+
                "CIUDADCLIENTE  TEXT NOT NULL"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " +NOMBRE_TABLA_CLIENTES);
        onCreate(db);
    }
}
