package moviles20233.fullpaper.data;

import android.content.ContentValues;
import android.database.Cursor;
import java.sql.Date;
import moviles20233.fullpaper.data.TansaccionesContract.TransaccionesEntry;
import moviles20233.fullpaper.data.UtensilioContract.UtensilioEntry;
import moviles20233.fullpaper.data.UsuarioContract.UsuarioEntry;

public class Transacciones {
    private int id_us;
    private int id_ut;
    private Date fecha_entrada;
    private Date fecha_salida;
    private int cantidadTra;

    public Transacciones(int id_us, int id_ut, Date fecha_entrada, Date fecha_salida, int cantidadTra){
        this.id_us = id_us;
        this.id_ut = id_ut;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.cantidadTra = cantidadTra;
    }
    public Transacciones(Cursor cursor){
        id_us = cursor.getInt( cursor.getColumnIndex(UsuarioEntry.ID ) );
        id_ut = cursor.getInt (cursor.getColumnIndex(UtensilioEntry.ID ) );
        fecha_entrada  = Date.valueOf(cursor.getString (cursor.getColumnIndex(TransaccionesEntry.FECHA_ENTRADA ) ));
        fecha_salida  = Date.valueOf(cursor.getString (cursor.getColumnIndex(TransaccionesEntry.FECHA_SALIDA ) ));
        cantidadTra = cursor.getInt(cursor.getColumnIndex(TransaccionesEntry.CANTIDAD_TRA ) );
    }
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TransaccionesEntry.ID_US, id_us);
        values.put(TransaccionesEntry.ID_UT, id_ut);
        values.put(TransaccionesEntry.FECHA_ENTRADA, String.valueOf(fecha_entrada));
        values.put(TransaccionesEntry.FECHA_SALIDA, String.valueOf(fecha_salida));
        values.put(TransaccionesEntry.CANTIDAD_TRA, cantidadTra);
        return values;
    }

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public int getId_ut() {
        return id_ut;
    }

    public void setId_ut(int id_ut) {
        this.id_ut = id_ut;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getCantidadTra() {
        return cantidadTra;
    }

    public void setCantidadTra(int cantidadTra) {
        this.cantidadTra = cantidadTra;
    }
}
