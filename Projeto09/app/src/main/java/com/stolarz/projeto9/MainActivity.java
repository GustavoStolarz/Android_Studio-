package com.stolarz.projeto9;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editvalor;
    private TextView textporcentagem, textgorjeta, texttotal;
    private SeekBar seekbargorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editvalor = findViewById(R.id.digite);
        textporcentagem = findViewById(R.id.texto_porcentagem);
        textgorjeta = findViewById(R.id.text_gorjeta);
        texttotal = findViewById(R.id.valor_total);
        seekbargorjeta = findViewById(R.id.seekbar_gorjeta);

        seekbargorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textporcentagem.setText(Math.round(porcentagem) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcular();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(){
        String valorrecuperado = editvalor.getText().toString();

        if (valorrecuperado == null || valorrecuperado.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_SHORT
            ).show();
        }else{
            double valordigitado = Double.parseDouble(valorrecuperado);

            double gorjeta = valordigitado * (porcentagem / 100);
            double total = gorjeta + valordigitado;

            textgorjeta.setText( "R$" + Math.round(gorjeta));
            texttotal.setText("R$" + String.format("%.2f", total));
        }
    }
}