package com.stolarz.project7;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

    public void selecionarpedra(View view) {
        verificarganhador("pedra");
    }

    public void selecionarpapel(View view) {
        verificarganhador("papel");
    }

    public void selecionartesoura(View view) {
        verificarganhador("tesoura");
    }

    private String gerarEscolhaAleatoriaAPP(){
        String[] opcoes = {"pedra","papel","tesoura"};
        int numeroaletorio = new Random().nextInt(3);

        ImageView imagemapp = findViewById(R.id.lol);
        String esccolhaapp = opcoes[numeroaletorio];

        switch (esccolhaapp){
            case "pedra":
                imagemapp.setImageResource(R.drawable.ped);
                break;
            case "papel":
                imagemapp.setImageResource(R.drawable.image_removebg_preview__1_);
                break;
            case "tesoura":
                imagemapp.setImageResource(R.drawable.image_removebg_preview__2_);
                break;
        }

        return esccolhaapp;
    }

    public void verificarganhador(String escolhadousuario) {
        System.out.println("Item clicado: " + escolhadousuario);

        String escolhaapp = gerarEscolhaAleatoriaAPP();

        TextView textoresultado = findViewById(R.id.resultado);
        if (
                (escolhaapp == "pedra" && escolhadousuario == "tesoura") ||
                        (escolhaapp == "papel" && escolhadousuario == "pedra")||
                        (escolhaapp == "tesoura" && escolhadousuario == "papel")
        ){
            textoresultado.setText("Você perdeu! ");
        }else if (
                (escolhaapp == "tesoura" && escolhadousuario == "pedra") ||
                        (escolhaapp == "pedra" && escolhadousuario == "papel")||
                        (escolhaapp == "papel" && escolhadousuario == "tesoura")
        ) {
            textoresultado.setText("Você ganhou! ");
        }else{
            textoresultado.setText("Você empatou!");
        }
    }
}