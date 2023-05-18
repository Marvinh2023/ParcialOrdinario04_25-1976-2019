package utec.edu.sv.parcial04ordinario.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import utec.edu.sv.parcial04ordinario.entidades.EntClientes;

public class Clientes extends baseHelper{
    Context context;
    public Clientes(@Nullable Context context) {
        super(context);
        this.context = context;
    }
/*
*
* "IDCLIENTE INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NOMBRECLIENTE TEXT NOT NULL, "+
                "APELLIDOCLIENTE TEXT NOT NULL, "+
                "DIRECCIONCLIENTE  TEXT NOT NULL,"+
                "CIUDADCLIENTE  TEXT NOT NULL"*/
    public long insertCliente(String NOMBRECLIENTE,String APELLIDOCLIENTE, String DIRECCIONCLIENTE, String CIUDADCLIENTE){

        long codigo=0;
        try {

            baseHelper baseHelp = new baseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresClientes = new ContentValues();
            valoresClientes.put("NOMBRECLIENTE", NOMBRECLIENTE);
            valoresClientes.put("APELLIDOCLIENTE", APELLIDOCLIENTE);
            valoresClientes.put("DIRECCIONCLIENTE", DIRECCIONCLIENTE);
            valoresClientes.put("CIUDADCLIENTE", CIUDADCLIENTE);

            codigo= bd.insert(NOMBRE_TABLA_CLIENTES, null, valoresClientes);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }

    }

    public ArrayList<EntClientes> mostrarClientes(){
        baseHelper baseHelp = new baseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<EntClientes>listaProvedores=new ArrayList<>();
        EntClientes entClientes=null;
        Cursor cursorPrverdor;

        cursorPrverdor=bd.rawQuery("SELECT IDCLIENTE,NOMBRECLIENTE,APELLIDOCLIENTE,DIRECCIONCLIENTE,CIUDADCLIENTE from "+NOMBRE_TABLA_CLIENTES,null);
        if(cursorPrverdor.moveToFirst())
        {
            do{
                entClientes = new EntClientes();
                entClientes.setCODCLIENTE(cursorPrverdor.getInt(0));
                entClientes.setNOMBRE(cursorPrverdor.getString(1));
                entClientes.setAPELLIDO(cursorPrverdor.getString(2));
                entClientes.setDIRECCION(cursorPrverdor.getString(3));
                entClientes.setCIUDAD(cursorPrverdor.getString(4));
                listaProvedores.add(entClientes);
            }
            while(cursorPrverdor.moveToNext());
        }
        cursorPrverdor.close();
        return listaProvedores;
    }
}
