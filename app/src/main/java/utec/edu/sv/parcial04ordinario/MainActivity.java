package utec.edu.sv.parcial04ordinario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import utec.edu.sv.parcial04ordinario.datos.baseHelper;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drwLayout;
    Toolbar tlBarra;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra = findViewById(R.id.toolbar);
        drwLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navigator);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drwLayout,tlBarra,R.string.open,R.string.close);
        drwLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));

        baseHelper basehelper = new baseHelper(this);
        SQLiteDatabase db = basehelper.getWritableDatabase();
        if (db != null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error en crear base de datos", Toast.LENGTH_SHORT).show();
        }

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mensajes:
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new ClientestFragment());
                        break;
                    case R.id.encontrar:
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new VehiculosFragment());
                        break;
                    case R.id.comentario:
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new ComentariosFragment());
                        break;
                    case R.id.enviar:
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new VerClienetesFragment());
                        break;
                    case R.id.compartir:
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new CompartirFragment());
                }
                return true;
            }
        });

    }


    private void fragmentosR(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();
    }
}