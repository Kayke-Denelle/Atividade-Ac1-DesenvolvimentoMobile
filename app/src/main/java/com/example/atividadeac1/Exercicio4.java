package com.example.atividadeac1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Exercicio4 extends AppCompatActivity {
    private EditText editTextNome;
    private Button btnGerarCheckboxes;
    private LinearLayout containerCheckboxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio4);

        editTextNome = findViewById(R.id.editTextNome);
        btnGerarCheckboxes = findViewById(R.id.btnGerarCheckboxes);
        containerCheckboxes = findViewById(R.id.containerCheckboxes);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        editTextNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gerarCheckboxes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnGerarCheckboxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                gerarCheckboxes(nome);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercicio4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void gerarCheckboxes(String nome) {

        containerCheckboxes.removeAllViews();


        nome = nome.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);

            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(String.valueOf(letra));
            checkBox.setTextSize(18);
            checkBox.setPadding(8, 8, 8, 8);

            containerCheckboxes.addView(checkBox);
        }

        if (nome.isEmpty()) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("Digite um nome para gerar as letras");
            checkBox.setEnabled(false);
            containerCheckboxes.addView(checkBox);
        }
    }
}