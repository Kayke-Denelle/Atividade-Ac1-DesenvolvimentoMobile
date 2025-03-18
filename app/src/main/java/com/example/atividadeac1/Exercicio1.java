package com.example.atividadeac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercicio1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio1); // Define o layout da activity


        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercicio1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextIdade = findViewById(R.id.editTextIdade);
        Button btnVerificar = findViewById(R.id.btnVerificar);
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String idadeTexto = editTextIdade.getText().toString();

                if (nome.isEmpty() || idadeTexto.isEmpty()) {
                    textViewResultado.setText("Por favor, preencha todos os campos.");
                    return;
                }

                int idade = Integer.parseInt(idadeTexto);

                if (idade >= 18) {
                    textViewResultado.setText(nome + ", você é maior de idade.");
                } else {
                    textViewResultado.setText(nome + ", você é menor de idade.");
                }
            }

        });
    }
}
