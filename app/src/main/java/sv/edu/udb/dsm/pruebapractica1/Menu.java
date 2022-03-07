package sv.edu.udb.dsm.pruebapractica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    TextView txtvUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txtvUsuario = (TextView) findViewById(R.id.txtvUsuario);
        cargarPreferencias();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user=preferences.getString("user","No hay credenciales");
        txtvUsuario.setText(user);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnEjercicio1:
                Intent llamar = new Intent(this,Ejercicio1.class);
                startActivity(llamar);
                break;
            case R.id.btnEjercicio2:
                Intent llamar2 = new Intent(this,Ejercicio2.class);
                startActivity(llamar2);
                break;
            case R.id.btnSalir:
                reiniciarPreferencias();
                finish();
                break;
        }
    }

    private void reiniciarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

    }
}