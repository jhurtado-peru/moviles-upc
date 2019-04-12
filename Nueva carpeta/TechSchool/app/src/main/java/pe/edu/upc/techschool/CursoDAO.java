package pe.edu.upc.techschool;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

public class CursoDAO {

    private DbHelper _dbHelper;

    public CursoDAO(Context c) {
        _dbHelper = new DbHelper(c);
    }

    public void insertar(String nombreCurso, String nivel) throws DAOException {
        Log.i("CursoDAO", "insertar()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();
        try {
            String[] args = new String[]{nombreCurso, nivel};
            db.execSQL("INSERT INTO curso(nombreCurso, nivel) VALUES(?,?)", args);
            Log.i("CursoDAO", "Se insertó");
        } catch (Exception e) {
            throw new DAOException("CursoDAO: Error al insertar: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public ArrayList<Curso> buscar(String criterio) throws DAOException {
        Log.i("CursoDAO", "buscar()");
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Cursor c = db.rawQuery("select id, nombreCurso, nivel from curso where nombreCurso like '%"+criterio+"%' or nivel like '%"+criterio+"%'", null);

            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String nombreCurso = c.getString(c.getColumnIndex("nombreCurso"));
                    String nivel = c.getString(c.getColumnIndex("nivel"));

                    Curso modelo = new Curso();
                    modelo.setId(id);
                    modelo.setNombreCurso(nombreCurso);
                    modelo.setNivel(nivel);

                    lista.add(modelo);
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw new DAOException("CursoDAO: Error al obtener: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return lista;
    }


    public void eliminar(int id) throws DAOException {
        Log.i("CursoDAO", "eliminar()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();

        try {
            String[] args = new String[]{String.valueOf(id)};
            db.execSQL("DELETE FROM curso WHERE id=?", args);
        } catch (Exception e) {
            throw new DAOException("CursoDAO: Error al eliminar: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }
}
