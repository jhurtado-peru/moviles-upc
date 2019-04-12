package pe.edu.upc.techschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BuscarSedeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(BuscarSedeActivity.this, MenuActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(BuscarSedeActivity.this, MenuActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(BuscarSedeActivity.this, MenuActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_sede);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Buscar Sede");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
