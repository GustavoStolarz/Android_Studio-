package com.stolarz.projeto3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    public void linkd (View view) {
        Uri link = Uri.parse("https://www.linkedin.com/in/gustavo-stolarz-martins-1298a62b0/");
        Intent intent = new Intent(Intent.ACTION_VIEW,link);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
    public void gitu (View view) {
        Uri link = Uri.parse("https://github.com/GustavoStolarz");
        Intent intent = new Intent(Intent.ACTION_VIEW,link);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
