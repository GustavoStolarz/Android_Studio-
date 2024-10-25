package com.stolarz.project8;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edit_alcool, edit_gasolina;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edit_alcool = findViewById(R.id.alcool);
        edit_gasolina = findViewById(R.id.gasolina);
        text_resultado = findViewById(R.id.resultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularpreco(View view) {
        String precoalcool = edit_alcool.getText().toString();
        String precogasolina = edit_gasolina.getText().toString();

        boolean camposvalidados = validarcampo(precoalcool, precogasolina);

        if (camposvalidados){
            Double validaralcool = Double.parseDouble(precoalcool);
            Double validargasolina = Double.parseDouble(precogasolina);

            Double resultaddo = validaralcool/validargasolina;

            if (resultaddo >= 0.7) {
                text_resultado.setText("Gasolina é preferível!");
            } else {
                text_resultado.setText("Álcool é preferível!");
            }

        }else {
            text_resultado.setText("Preenchimento do campo é obrigatorio");
        }
    }

    public Boolean validarcampo(String palcool, String pgasolina) {
        boolean camposvalidados = true; //Campos são verdadeiros

        if (palcool == null || palcool.equals("")) {
            camposvalidados = false;
        } else if (pgasolina == null || pgasolina.equals("")) {
            camposvalidados = false;
        }

        return camposvalidados;
    }
}