package sv.edu.udb.dsm.pruebapractica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio2 extends AppCompatActivity {
    TextView txtvX1,txtvX2;
    EditText txtA,txtB,txtC;
    int a,b,c;
    double x1,x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
         txtvX1 = (TextView) findViewById(R.id.txtvX1);
         txtvX2 = (TextView) findViewById(R.id.txtvX2);
         txtA = (EditText) findViewById(R.id.txtA);
         txtB = (EditText) findViewById(R.id.txtB);
         txtC = (EditText) findViewById(R.id.txtC);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalcular:
                calcularCuadratica();
                break;
            case R.id.btnRegresar:
                finish();
                break;
        }
    }

    private void calcularCuadratica() {
        a=Integer.parseInt(txtA.getText().toString());
        b=Integer.parseInt(txtB.getText().toString());
        c=Integer.parseInt(txtC.getText().toString());
        x1=(-b + Math.sqrt((b*b) + (4*a*c)))/2*a;
        x2=(-b - Math.sqrt((b*b) + (4*a*c)))/2*a;

        txtvX1.setText("X1= "+ Double.toString(x1));
        txtvX2.setText("X2= "+ Double.toString(x2));

    }
}