package com.stolarz.projetc4;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

import kotlin.collections.UCollectionsKt;

public class MainActivity extends AppCompatActivity {

    private static final int NUMERO_MAXIMO = 60;
    private static final int QUANT_MAX = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void sorte(View view){
        ArrayList<Integer> numeros = new ArrayList<>();

        for(int  i = 1; i <= NUMERO_MAXIMO; i++){
            numeros.add(i);
        }

        Collections.shuffle(numeros);

        StringBuilder resultado = new StringBuilder("Números Sorteados: \n");


        for(int i = 0; i < QUANT_MAX; i++){
            resultado.append(numeros.get(i)).append("");
        }
        TextView resultadosTextView = findViewById(R.id.resultado);
        resultadosTextView.setText(resultado.toString());
    }
}