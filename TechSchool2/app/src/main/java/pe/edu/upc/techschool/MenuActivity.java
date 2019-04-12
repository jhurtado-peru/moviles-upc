package pe.edu.upc.techschool;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        redirigirBotones();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void redirigirBotones() {
        ImageView imgprofesor = (ImageView)findViewById(R.id.imgprofesor);
        imgprofesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ListarProfesorActivity.class));
            }
        });

        ImageView imgalumno = (ImageView)findViewById(R.id.imgalumno);
        imgalumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ListarAlumnoActivity.class));
            }
        });

        ImageView imgcurso = (ImageView)findViewById(R.id.imgcurso);
        imgcurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ListarCursoActivity.class));
            }
        });

        ImageView imgseccion = (ImageView)findViewById(R.id.imgseccion);
        imgseccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ListarSeccionActivity.class));
            }
        });

        ImageView imgsede = (ImageView)findViewById(R.id.imgsede);
        imgsede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, BuscarSedeActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profesores) {
            startActivity(new Intent(MenuActivity.this, ListarProfesorActivity.class));
            return true;
        }else if (id == R.id.action_alumnos) {
            startActivity(new Intent(MenuActivity.this, ListarAlumnoActivity.class));
            return true;
        }else if (id == R.id.action_curso) {
            startActivity(new Intent(MenuActivity.this, ListarCursoActivity.class));
            return true;
        }else if (id == R.id.action_seccion) {
            startActivity(new Intent(MenuActivity.this, ListarSeccionActivity.class));
            return true;
        }else if (id == R.id.action_sede) {
            startActivity(new Intent(MenuActivity.this, BuscarSedeActivity.class));
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profesores) {
            Intent show = new Intent(this, ListarProfesorActivity.class);
            startActivity(show);

        } else if (id == R.id.nav_alumnos) {
            Intent show = new Intent(this, ListarAlumnoActivity.class);
            startActivity(show);

        } else if (id == R.id.nav_cursos) {
            Intent show = new Intent(this, ListarCursoActivity.class);
            startActivity(show);

        } else if (id == R.id.nav_secciones) {
            Intent show = new Intent(this, ListarSeccionActivity.class);
            startActivity(show);

        } else if (id == R.id.nav_sedes) {
            Intent show = new Intent(this, BuscarSedeActivity.class);
            startActivity(show);

        } else if (id == R.id.nav_notificaciones) {

        } else if (id == R.id.nav_configuraciones) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
