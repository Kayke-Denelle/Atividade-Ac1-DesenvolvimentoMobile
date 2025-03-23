package com.example.atividadeac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Exercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio2); // Define o layout da activity

        // Referências aos componentes da interface
        EditText editTextValor1 = findViewById(R.id.editTextValor1);
        EditText editTextValor2 = findViewById(R.id.editTextValor2);
        Button btnSomar = findViewById(R.id.btnSomar);
        Button btnSubtrair = findViewById(R.id.btnSubtrair);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        Button btnDividir = findViewById(R.id.btnDividir);
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        // Configura o listener do botão de adição
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacao('+', editTextValor1, editTextValor2, textViewResultado);
            }
        });

        // Configura o listener do botão de subtração
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacao('-', editTextValor1, editTextValor2, textViewResultado);
            }
        });

        // Configura o listener do botão de multiplicação
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacao('×', editTextValor1, editTextValor2, textViewResultado);
            }
        });

        // Configura o listener do botão de divisão
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacao('÷', editTextValor1, editTextValor2, textViewResultado);
            }
        });

        // Botão para voltar à MainActivity
        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercicio2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para realizar a operação e exibir o resultado
    private void calcularOperacao(char operacao, EditText editTextValor1, EditText editTextValor2, TextView textViewResultado) {
        // Captura os valores inseridos pelo usuário
        String valor1Texto = editTextValor1.getText().toString();
        String valor2Texto = editTextValor2.getText().toString();

        // Verifica se os campos estão preenchidos
        if (valor1Texto.isEmpty() || valor2Texto.isEmpty()) {
            textViewResultado.setText("Por favor, preencha todos os campos.");
            return;
        }

        // Converte os valores para double
        double valor1 = Double.parseDouble(valor1Texto);
        double valor2 = Double.parseDouble(valor2Texto);
        double resultado = 0;

        // Realiza a operação selecionada
        switch (operacao) {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case '×':
                resultado = valor1 * valor2;
                break;
            case '÷':
                if (valor2 != 0) {
                    resultado = valor1 / valor2;
                } else {
                    textViewResultado.setText("Divisão por zero não é permitida.");
                    return;
                }
                break;
        }

        // Exibe o resultado
        textViewResultado.setText("Resultado: " + resultado);
    }
}