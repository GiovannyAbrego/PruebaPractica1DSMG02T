package sv.edu.udb.dsm.pruebapractica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText campoUsuario,campoPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoUsuario = (EditText) findViewById(R.id.txtUsuario);
        campoPass = (EditText) findViewById(R.id.txtPassword);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnIngresar:
                guardarPreferencias();
                Intent llamar = new Intent(this,Menu.class);
                startActivity(llamar);
                break;
        }
    }
    private void guardarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String usuario=campoUsuario.getText().toString();
        String pass=campoPass.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",usuario);
        editor.putString("pass",pass);

        editor.commit();
    }
    private void limpiarCampos(){
        campoUsuario.getText().clear();
        campoPass.getText().clear();
    }

}