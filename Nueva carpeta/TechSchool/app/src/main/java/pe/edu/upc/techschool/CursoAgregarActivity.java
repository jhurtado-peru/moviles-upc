package pe.edu.upc.techschool;

import android.content.pm.ActivityInfo;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CursoAgregarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_curso_agregar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Registrar Curso");
    }

    public void grabar(View view) {

        EditText nombreCurso = (EditText) findViewById(R.id.nombreCurso);
        EditText nivel = (EditText) findViewById(R.id.nivel);

        CursoDAO dao = new CursoDAO(getBaseContext());
        try {
            dao.insertar(nombreCurso.getText().toString(), nivel.getText().toString());

            Toast toast= Toast.makeText(getApplicationContext(), "Se insertó correctamente", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            nombreCurso.setText("");
            nivel.setText("");
        } catch (DAOException e) {
            Log.i("AgregarCursoActivity", "====> " + e.getMessage());
        }
    }
}
