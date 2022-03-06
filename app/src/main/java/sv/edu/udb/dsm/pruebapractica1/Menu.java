package sv.edu.udb.dsm.pruebapractica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
        String user=preferences.getString("user","No hay credenciales prueba del commit");
        txtvUsuario.setText(user);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnEjercicio1:
                break;
            case R.id.btnEjercicio2:
                break;
            case R.id.btnSalir:
                reiniciarPreferencias();
                finish();
        }
    }

    private void reiniciarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

    }
}