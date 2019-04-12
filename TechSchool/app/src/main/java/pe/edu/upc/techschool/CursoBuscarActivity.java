package pe.edu.upc.techschool;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class CursoBuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_buscar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Buscar Curso");
    }

    public void buscar(View view) {
        EditText criterio = (EditText) findViewById(R.id.criterio);
        CursoDAO dao = new CursoDAO(getBaseContext());
        try {
            ArrayList<Curso> resultados = dao.buscar(criterio.getText().toString());

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


        } catch (DAOException e) {
            Log.i("CursoBuscarActivity", "====> " + e.getMessage());
        }
    }
}
