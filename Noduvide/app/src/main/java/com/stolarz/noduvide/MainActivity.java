package com.stolarz.noduvide;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buton), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
        public void butao (View view) {
            TextView texto = findViewById(R.id.frase);
            String[] nomes = {
                    "Se você acha que está mal, lembre-se: até o GPS precisa de recalcular a rota às vezes!",
                    "Não desista! O sucesso pode estar a uma pizza de distância... ou a uma fatia dela",
            };

            int indicealeatorio = new Random().nextInt(nomes.length);
            String nomealeatorio = nomes[indicealeatorio];

            texto.setText("Resultado "+ nomes[0]);
    }
}