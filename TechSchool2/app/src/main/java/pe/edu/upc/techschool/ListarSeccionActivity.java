package pe.edu.upc.techschool;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListarSeccionActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(ListarSeccionActivity.this, MenuActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(ListarSeccionActivity.this, MenuActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(ListarSeccionActivity.this, MenuActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_seccion);
        this.simpleAdapterListView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Listado de Secciones");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void simpleAdapterListView() {
        setTitle("Tech School");

        String[] titleArr = { "S2SIAL - Algoritmos I", "S3SIAL - Algoritmos I", "S4SIAL - Algoritmos I", "S1SIEU - Experiencia de usuario","S1SISW - Desarrollo web I"};
        String[] descArr = { "Presencial - Lunes 9:00 / 11:00 hrs", "Presencial - Lunes 15:00 / 17:00 hrs", "Presencial - Viernes 19:00 / 21:00 hrs", "Online - Libre", "Presencial - Jueves 19:00 / 21:00 hrs" };

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

        ListView listView = (ListView)findViewById(R.id.listSecciones);
        listView.setAdapter(simpleAdapter);
    }

}
