package com.example.atividadeac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exercicio5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio5); // Define o layout da activity

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercicio5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        CheckBox checkNotificacoes = findViewById(R.id.checkNotificacoes);
        CheckBox checkModoEscuro = findViewById(R.id.checkModoEscuro);
        CheckBox checkLembrarLogin = findViewById(R.id.checkLembrarLogin);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder preferencias = new StringBuilder();

                if (checkNotificacoes.isChecked()) {
                    preferencias.append("• Receber notificações\n");
                }
                if (checkModoEscuro.isChecked()) {
                    preferencias.append("• Modo escuro\n");
                }
                if (checkLembrarLogin.isChecked()) {
                    preferencias.append("• Lembrar login\n");
                }

                if (preferencias.length() > 0) {
                    Toast.makeText(Exercicio5.this,
                            "Preferências selecionadas:\n" + preferencias.toString(),
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Exercicio5.this,
                            "Nenhuma preferência foi escolhida",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
