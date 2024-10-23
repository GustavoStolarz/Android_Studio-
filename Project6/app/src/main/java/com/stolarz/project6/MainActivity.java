package com.stolarz.project6;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
        String[] frases = {
                "Só há amor quando não existe nenhuma autoridade.",
                "O sonho acabou, mas a vida continua.",
                "Aprendi o segredo, o segredo, o segredo da vida,vendo as pedras que choram sozinhas no mesmo lugar",
                "Ninguém tem o direito de me julgar a não ser eu mesmo. Eu me pertenço e de mim faço o que bem entender.",
                "A desobediência é uma virtude necessária à criatividade.",
                "Meu egoísmo é tão egoísta que o auge do meu egoísmo é querer ajudar.",
        };

    public void gerarFrase (View view) {
        TextView texto = findViewById(R.id.text_result);
        int numeroAleatorio = new Random().nextInt(5);

        String frase = frases[numeroAleatorio];

        texto.setText(frase);
    }
    public void exibirtodas (View view) {
        TextView texto = findViewById(R.id.text_result);

        String textoresultado = " ";

        for (String frase : frases) {
            textoresultado = textoresultado + frase + " \n " + " \n ";
        }
            texto.setText(textoresultado);
        }

    }