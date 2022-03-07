package sv.edu.udb.dsm.pruebapractica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Ejercicio1_1 extends AppCompatActivity {
    TextView txtvUsuario,txtvCodigo,txtvEmpleado,txtvVentas,txtvMes,txtvPorcentaje,txtvComision;
    ImageView imgvFoto;
    Button btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_1);
        txtvUsuario = (TextView) findViewById(R.id.txtvUsuario);
        txtvCodigo = (TextView) findViewById(R.id.txtvCodigo);
        txtvEmpleado = (TextView) findViewById(R.id.txtvEmpleado);
        txtvVentas = (TextView) findViewById(R.id.txtvVentas);
        txtvMes = (TextView) findViewById(R.id.txtvMes);
        txtvPorcentaje = (TextView) findViewById(R.id.txtvPorcentaje);
        txtvComision = (TextView) findViewById(R.id.txtvComision);
        imgvFoto = (ImageView) findViewById(R.id.imgvFoto);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        cargarPreferencias();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user=preferences.getString("user","No hay credenciales");
        String codigo=preferences.getString("id","No hay credenciales");
        String empleado=preferences.getString("employee","No hay credenciales");
        String ventas=preferences.getString("sales","No hay credenciales");
        String mes=preferences.getString("month","No hay credenciales");
        String urimg=preferences.getString("img","No hay credenciales");

        txtvUsuario.setText(user);
        txtvCodigo.setText(codigo);
        txtvEmpleado.setText(empleado);
        txtvVentas.setText(ventas);
        txtvMes.setText(mes);

        if (!urimg.equals("No hay credenciales")){
            Uri urifoto = Uri.parse(urimg);
            imgvFoto.setImageURI(urifoto);
        }

        if (!ventas.equals("No hay credenciales")){
            Double ventadecimal = Double.parseDouble(ventas);
            Double comisiondecimal =0.0;
            int porcentaje =0;
            if (ventadecimal<500.0){
                comisiondecimal = 0.0;
                porcentaje = 0;
            }else if (ventadecimal>=500.0 && ventadecimal<1000.0){
                comisiondecimal = ventadecimal*0.05;
                porcentaje = 5;
            }else if (ventadecimal>=1000.0 && ventadecimal<2000.0){
                comisiondecimal = ventadecimal*0.1;
                porcentaje = 10;
            }else if (ventadecimal>=2000.0 && ventadecimal<3000.0){
                comisiondecimal = ventadecimal*0.15;
                porcentaje = 15;
            }else if (ventadecimal>=3000.0 && ventadecimal<4000.0){
                comisiondecimal = ventadecimal*0.2;
                porcentaje = 20;
            }else if (ventadecimal>=4000.0){
                comisiondecimal = ventadecimal*0.3;
                porcentaje = 30;
            }
            txtvComision.setText(comisiondecimal.toString());
            txtvPorcentaje.setText(porcentaje);
        }
    }
}