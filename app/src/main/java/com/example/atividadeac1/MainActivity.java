package com.example.atividadeac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

            Button btnExercicio1 = findViewById(R.id.btnExercicio1);
            btnExercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, Exercicio1.class);
                    startActivity(intent);
                }
            });

            Button btnExercicio2 = findViewById(R.id.btnExercicio2);
            btnExercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Exercicio2.class);
                    startActivity(intent);
                }
            });

            Button btnExercicio3 = findViewById(R.id.btnExercicio3);
            btnExercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Exercicio3.class);
                    startActivity(intent);
                }
            });

            Button btnExercicio4 = findViewById(R.id.btnExercicio4);
            btnExercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Exercicio4.class);
                    startActivity(intent);
                }
            });

            Button btnExercicio5 = findViewById(R.id.btnExercicio5);
            btnExercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Exercicio5.class);
                    startActivity(intent);
                }
            });


    }
}