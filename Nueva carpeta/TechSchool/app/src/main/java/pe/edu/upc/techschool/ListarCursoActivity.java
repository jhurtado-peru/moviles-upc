package pe.edu.upc.techschool;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListarCursoActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(ListarCursoActivity.this, MenuActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(ListarCursoActivity.this, MenuActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(ListarCursoActivity.this, MenuActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_curso);
        this.simpleAdapterListView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Listado de Cursos");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        redirectButtons();
    }

    private void redirectButtons() {
        ImageView imgAdicionar = (ImageView)findViewById(R.id.adicionar);
        imgAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListarCursoActivity.this, CursoAgregarActivity.class));
            }
        });

        ImageView imgBuscar = (ImageView)findViewById(R.id.buscar);
        imgBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListarCursoActivity.this, CursoBuscarActivity.class));
            }
        });

        ImageView imgEliminar = (ImageView)findViewById(R.id.eliminar);
        imgEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListarCursoActivity.this, CursoEliminarActivity.class));
            }
        });
    }

    private void simpleAdapterListView() {
        setTitle("Tech School");

        String[] titleArr = { "Algoritmos I", "Desarrollo web I", "Maquetado Móvil I", "Base de datos","Experiencia de usuario","Desarrollo web II"};
        String[] descArr = { "ALSI1", "DWSI1", "MMSI1", "BDSI1", "EUSI1", "DWSI2" };

        ArrayList<Map<String,Object>> itemDataList = new ArrayList<Map<String,Object>>();;

        int titleLen = titleArr.length;
        for(int i =0; i < titleLen; i++) {
            Map<String,Object> listItemMap = new HashMap<String,Object>();
            listItemMap.put("title", titleArr[i]);
            listItemMap.put("description", descArr[i]);
            itemDataList.add(listItemMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,itemDataList,android.R.layout.simple_list_item_2,
                new String[]{"title","description"},new int[]{android.R.id.text1,android.R.id.text2});

        ListView listView = (ListView)findViewById(R.id.listViewCursos);
        listView.setAdapter(simpleAdapter);
    }



}
