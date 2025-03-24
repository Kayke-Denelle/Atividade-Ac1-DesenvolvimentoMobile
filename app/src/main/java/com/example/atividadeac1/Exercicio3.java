package com.example.atividadeac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Exercicio3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercicio3);

        // Configura o Spinner de UF
        Spinner spinnerUF = findViewById(R.id.spinnerUF);
        List<String> ufs = new ArrayList<>();
        ufs.add("AC"); ufs.add("AL"); ufs.add("AP"); ufs.add("AM"); ufs.add("BA");
        ufs.add("CE"); ufs.add("DF"); ufs.add("ES"); ufs.add("GO"); ufs.add("MA");
        ufs.add("MT"); ufs.add("MS"); ufs.add("MG"); ufs.add("PA"); ufs.add("PB");
        ufs.add("PR"); ufs.add("PE"); ufs.add("PI"); ufs.add("RJ"); ufs.add("RN");
        ufs.add("RS"); ufs.add("RO"); ufs.add("RR"); ufs.add("SC"); ufs.add("SP");
        ufs.add("SE"); ufs.add("TO");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ufs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUF.setAdapter(adapter);

        // Configura o botão de cadastro
        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        // Obtém os dados do formulário
        EditText editNome = findViewById(R.id.editNome);
        EditText editIdade = findViewById(R.id.editIdade);
        Spinner spinnerUF = findViewById(R.id.spinnerUF);
        EditText editCidade = findViewById(R.id.editCidade);
        EditText editTelefone = findViewById(R.id.editTelefone);
        EditText editEmail = findViewById(R.id.editEmail);
        RadioGroup radioGroupTamanho = findViewById(R.id.radioGroupTamanho);

        String nome = editNome.getText().toString();
        String idade = editIdade.getText().toString();
        String uf = spinnerUF.getSelectedItem().toString();
        String cidade = editCidade.getText().toString();
        String telefone = editTelefone.getText().toString();
        String email = editEmail.getText().toString();

        // Validação básica
        if (nome.isEmpty() || idade.isEmpty() || cidade.isEmpty() ||
                telefone.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtém o tamanho selecionado
        int selectedId = radioGroupTamanho.getCheckedRadioButtonId();
        RadioButton radioTamanho = findViewById(selectedId);
        String tamanho = radioTamanho != null ? radioTamanho.getText().toString() : "Não informado";

        // Obtém as cores selecionadas
        List<String> coresSelecionadas = new ArrayList<>();
        CheckBox checkPreto = findViewById(R.id.checkPreto);
        CheckBox checkBranco = findViewById(R.id.checkBranco);
        CheckBox checkVermelho = findViewById(R.id.checkVermelho);
        CheckBox checkAzul = findViewById(R.id.checkAzul);
        CheckBox checkVerde = findViewById(R.id.checkVerde);

        if (checkPreto.isChecked()) coresSelecionadas.add("Preto");
        if (checkBranco.isChecked()) coresSelecionadas.add("Branco");
        if (checkVermelho.isChecked()) coresSelecionadas.add("Vermelho");
        if (checkAzul.isChecked()) coresSelecionadas.add("Azul");
        if (checkVerde.isChecked()) coresSelecionadas.add("Verde");

        String cores = coresSelecionadas.isEmpty() ? "Nenhuma cor selecionada" :
                String.join(", ", coresSelecionadas);

        // Monta a mensagem de confirmação
        String mensagem = "Cadastro realizado com sucesso!\n\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "UF: " + uf + "\n" +
                "Cidade: " + cidade + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + email + "\n" +
                "Tamanho: " + tamanho + "\n" +
                "Cores preferidas: " + cores;

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}