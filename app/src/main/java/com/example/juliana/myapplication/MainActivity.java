package com.example.juliana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    String display ="";
    String OperadorActual ="";
    String Resultado="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.Datos);
        screen.setText(display);


    }

    public void updateScreen(){

        screen.setText(display);
    }

    public void Boton(View view) {
        if(Resultado!=""){
            display = Resultado;
            Resultado ="";
        }
        Button b = (Button) view;
        display += b.getText().toString();
        updateScreen();

    }


    public void ActualOperator(View view) {
        if(Resultado!=""){
            display = Resultado;
            Resultado ="";
        }
        Button b = (Button) view;
        display += b.getText().toString();
        OperadorActual = b.getText().toString();
        updateScreen();

    }

    public double Operador(String a, String b, String operador) {
        switch (operador) {
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "/":
                return Double.valueOf(a) / Double.valueOf(b);
            case "*":
                return Double.valueOf(a) * Double.valueOf(b);
            default:
                return -1;
        }
    }


    public void Result(View view) {
        String[ ]  operacion = display.split(Pattern.quote(OperadorActual));
        if(operacion.length<2){
            return;
        }

        Resultado = String.valueOf(Operador(operacion[0],operacion[1],OperadorActual));
        screen.setText(display + "\n"+ String.valueOf(Resultado));


    }

    public void Delete(View view) {
        display = "";
        OperadorActual = "";
        Resultado ="";

        updateScreen();
    }
}

