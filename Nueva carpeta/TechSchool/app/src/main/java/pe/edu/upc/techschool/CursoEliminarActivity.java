package pe.edu.upc.techschool;

import android.content.pm.ActivityInfo;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CursoEliminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_curso_eliminar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Eliminar Cursos");
    }


    public void eliminar(View view) {
        EditText criterio = (EditText) findViewById(R.id.criterio);
        String criteroString = criterio.getText().toString();
        int criterioEntero = new Integer(criteroString).intValue();
        CursoDAO dao = new CursoDAO(getBaseContext());
        try {

            dao.eliminar(criterioEntero);
            Toast toast= Toast.makeText(getApplicationContext(), "Se elimino correctamente", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            ArrayList<Curso> resultados = dao.buscar("");

            String[] encontrados = new String[resultados.size()];
            int i = 0;
            for (Curso curso : resultados){
                encontrados[i++] = curso.getId() + ": [Curso: " + curso.getNombreCurso() + " - Nivel: " + curso.getNivel()+"]";
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this.getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    encontrados);

            ListView listaResultados = (ListView)findViewById(R.id.listaResultados);
            listaResultados.setAdapter(adaptador);
            criterio.setText("");

        } catch (DAOException e) {
            Log.i("CursoBuscarActivity", "====> " + e.getMessage());
        }
    }
}
