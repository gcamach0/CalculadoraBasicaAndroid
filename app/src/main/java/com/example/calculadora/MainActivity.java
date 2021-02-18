package com.example.calculadora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private Button unoBoton;
    private Button dosBoton;
    private Button tresBoton;
    private Button cuatroBoton;
    private Button cincoBoton;
    private Button seisBoton;
    private Button sieteBoton;
    private Button ochoBoton;
    private Button nueveBoton;
    private Button ceroBoton;
    private Button borrarBoton;
    private Button sumaBoton;
    private Button restaBoton;
    private Button divisionBoton;
    private Button multiBoton;
    private Button puntoBoton;
    private Button igualBoton;

    String operator = "";
    String firstValue = "";
    String secondValue = "";

    String currentDigits;
    String newDigits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.resultView);
        unoBoton = findViewById(R.id.unoBoton);
        dosBoton = findViewById(R.id.dosBoton);
        tresBoton = findViewById(R.id.tresBoton);
        cuatroBoton = findViewById(R.id.cuatroBoton);
        cincoBoton = findViewById(R.id.cincoBoton);
        seisBoton = findViewById(R.id.seisBoton);
        sieteBoton = findViewById(R.id.sieteBoton);
        ochoBoton = findViewById(R.id.ochoBoton);
        nueveBoton = findViewById(R.id.nueveBoton);
        ceroBoton = findViewById(R.id.ceroBoton);
        borrarBoton = findViewById(R.id.borrarBoton);
        sumaBoton = findViewById(R.id.sumaBoton);
        restaBoton = findViewById(R.id.restaBoton);
        divisionBoton = findViewById(R.id.divisionBoton);
        multiBoton = findViewById(R.id.multiBoton);
        puntoBoton = findViewById(R.id.puntoBoton);
        igualBoton = findViewById(R.id.igualBoton);

        unoBoton.setOnClickListener(presionarDigito);
        dosBoton.setOnClickListener(presionarDigito);
        tresBoton.setOnClickListener(presionarDigito);
        cuatroBoton.setOnClickListener(presionarDigito);
        cincoBoton.setOnClickListener(presionarDigito);
        seisBoton.setOnClickListener(presionarDigito);
        sieteBoton.setOnClickListener(presionarDigito);
        ochoBoton.setOnClickListener(presionarDigito);
        nueveBoton.setOnClickListener(presionarDigito);
        ceroBoton.setOnClickListener(presionarDigito);
        puntoBoton.setOnClickListener(presionarDigito);

        borrarBoton.setOnClickListener(presionarBorrar);
        igualBoton.setOnClickListener(presionarIgual);

        sumaBoton.setOnClickListener(presionarOperador);
        restaBoton.setOnClickListener(presionarOperador);
        divisionBoton.setOnClickListener(presionarOperador);
        multiBoton.setOnClickListener(presionarOperador);


    }

    private View.OnClickListener presionarDigito = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            String buttonText = b.getText().toString();
            if (operator.equals("")){
                currentDigits = resultView.getText().toString().equals("0") ? "" : resultView.getText().toString();
                newDigits =  currentDigits + buttonText;
                resultView.setText(newDigits);
            } else{
                try {
                    Double.parseDouble(resultView.getText().toString());
                    currentDigits = resultView.getText().toString().equals("0") ? "" : resultView.getText().toString();
                    newDigits =  currentDigits + buttonText;
                    resultView.setText(newDigits);
                } catch(Exception e){
                    resultView.setText(buttonText);
                }
            }
        }
    };

    private View.OnClickListener presionarBorrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!operator.equals("")){
                operator = "";
                resultView.setText(firstValue);
            }
            else {
                resultView.setText("0");
            }
        }
    };

    private View.OnClickListener presionarIgual = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            secondValue = (resultView.getText().toString());
            double r;
            switch (operator)
            {
                case "+":
                    try {
                        r = Double.valueOf(firstValue) + Double.valueOf(secondValue);
                    } catch (Exception e){
                        r = 0;
                    };
                    resultView.setText(String.valueOf(r));
                    break;
                case "-":
                    try {
                        r = Double.valueOf(firstValue) - Double.valueOf(secondValue);
                    } catch (Exception e){
                        r = 0;
                    };
                    resultView.setText(String.valueOf(r));
                    break;
                case "*":
                    try {
                        r = Double.valueOf(firstValue) * Double.valueOf(secondValue);
                    } catch (Exception e){
                        r = 0;
                    };
                    resultView.setText(String.valueOf(r));
                    break;
                case "/":
                    try {
                        r = Double.valueOf(firstValue) / Double.valueOf(secondValue);
                    } catch (Exception e){
                        r = 0;
                    };
                    resultView.setText(String.valueOf(r));
                    break;
            }
            firstValue = "";
            secondValue = "";
            operator = "";
        }
    };

    private View.OnClickListener presionarOperador = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (operator.equals("")){
                firstValue = resultView.getText().toString();
                switch (v.getId())
                {
                    case R.id.sumaBoton :
                        operator = "+";
                        resultView.setText("+");
                        break;

                    case R.id.restaBoton :
                        operator = "-";
                        resultView.setText("-");
                        break;

                    case R.id.multiBoton :
                        operator = "*";
                        resultView.setText("*");
                        break;

                    case R.id.divisionBoton :
                        operator = "/";
                        resultView.setText("/");
                        break;
                }
            }
        }
    };
}