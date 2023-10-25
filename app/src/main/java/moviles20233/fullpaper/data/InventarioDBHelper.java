package moviles20233.fullpaper.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import moviles20233.fullpaper.data.UsuarioContract.UsuarioEntry;
import moviles20233.fullpaper.data.UtensilioContract.UtensilioEntry;
import moviles20233.fullpaper.data.TansaccionesContract.TransaccionesEntry;

public class InventarioDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventario.db";

    public InventarioDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UsuarioEntry.TABLE_NAME + " ("+
                UsuarioEntry.ID+ " INTEGER PRIMARY KEY," +
                UsuarioEntry.NAME+ " TEXT NOT NULL," +
                UsuarioEntry.PASSWORD+ "INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Cursor getAllUsuarios() {
            return getReadableDatabase()
                    .query(
                            UsuarioEntry.TABLE_NAME,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null);
    }
    public long saveUser(Usuario usuario){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }

    public Cursor getUsuarioById(String usuarioId){
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId},
                null,
                null,
                null);
        return c;
    }

    public Cursor getUsuarioByIdPassword(String usuarioId, String usurioPassword){
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.ID + " LIKE ? AND "+UsuarioEntry.PASSWORD + "LIKE ?",
                new String[]{usuarioId,usurioPassword},
                null,
                null,
                null);
        return c;
    }
    public int deleteUsuario(String usuarioId) {
        return getWritableDatabase().delete(
                UsuarioEntry.TABLE_NAME,
                UsuarioEntry.ID+ " LIKE ?",
                new String[]{usuarioId});
    }

    public int updateUsuario(Usuario usuarioModificar, String usuarioId) {
        return getWritableDatabase().update(
                UsuarioEntry.TABLE_NAME,
                usuarioModificar.toContentValues(),
                UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId}
        );
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UtensilioEntry.TABLE_NAME + " (" +
                UtensilioEntry.ID + " INTEGER PRIMARY KEY," +
                UtensilioEntry.NAME + " TEXT NOT NULL," +
                UtensilioEntry.TIPO + " TEXT NOT NULL," +
                UtensilioEntry.CANTIDAD + " INTERGER NOT NULL," +
                UtensilioEntry.PRECIO + "FLOAT NOT NULL)");
    }
    public Cursor getAllUtensilios() {
        return getReadableDatabase()
                .query(
                        UtensilioEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    public long guardarUtensilio(Utensilio utensilio){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                UtensilioEntry.TABLE_NAME,
                null,
                utensilio.toContentValues());
    }
    public int ActuaUtensilio(Utensilio utensilioModificar, String utensilioId) {
        return getWritableDatabase().update(
                UtensilioEntry.TABLE_NAME,
                utensilioModificar.toContentValues(),
                UtensilioEntry.ID + " LIKE ?",
                new String[]{utensilioId}
        );
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TransaccionesEntry.TABLE_NAME + " (" +
                TransaccionesEntry.ID_US + " INTEGER PRIMARY KEY," +
                TransaccionesEntry.ID_UT +  "INTERGER PRIMARY KEY," +
                TransaccionesEntry.FECHA_ENTRADA + "DATE NOT NULL,"+
                TransaccionesEntry.FECHA_SALIDA + "DATE NOT NULL," +
                TransaccionesEntry.CANTIDAD_TRA + "INTERGER NOT NULL) ");
    }
    public Cursor getAllTransacciones() {
        return getReadableDatabase()
                .query(
                        TransaccionesEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    public int ActuaCantidad(Transacciones TransaccionesModificar, String transaccionesCant) {
        return getWritableDatabase().update(
                TransaccionesEntry.TABLE_NAME,
                TransaccionesModificar.toContentValues(),
                TransaccionesEntry.CANTIDAD_TRA + " LIKE ?",
                new String[]{transaccionesCant}
        );
}