package sv.edu.udb.dsm.pruebapractica1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity implements View.OnClickListener {
    TextView txtvUsuario;
    EditText txtCodigo,txtEmpleado,txtVentas;
    Spinner spMes;
    ImageView imgvCargar;
    Button btnGuardar;
    private static final int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        txtvUsuario = (TextView) findViewById(R.id.txtvUsuario);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtEmpleado = (EditText) findViewById(R.id.txtEmpleado);
        txtVentas = (EditText) findViewById(R.id.txtVentas);
        spMes = (Spinner) findViewById(R.id.spMes);
        String[] meses ={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        spMes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,meses));
        spMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                //Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                String mes = adapterView.getItemAtPosition(i).toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("month",mes);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imgvCargar = (ImageView) findViewById(R.id.imgvCargar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        //Llena el txtvUsuario con la informacion disponible
        cargarPreferencias();

        imgvCargar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

    }
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user=preferences.getString("user","No hay credenciales");
        txtvUsuario.setText(user);
    }
    private void guardarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String codigo=txtCodigo.getText().toString();
        String empleado=txtEmpleado.getText().toString();
        String ventas=txtVentas.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("id",codigo);
        editor.putString("employee",empleado);
        editor.putString("sales",ventas);

        editor.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgvCargar:
                Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galeria,RESULT_LOAD_IMAGE);
                break;
            case R.id.btnGuardar:
                guardarPreferencias();
                Intent resultados = new Intent(this,Ejercicio1_1.class);
                startActivity(resultados);
                break;
            case R.id.btnCancelar:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_LOAD_IMAGE&&resultCode==RESULT_OK&&data!=null){
            Uri imagen = data.getData();
            imgvCargar.setImageURI(imagen);
            SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            String img=imagen.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("img",img);
            editor.commit();
        }
    }
}