package br.com.alura.aluraviagens.ui.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.utils.DataUtil;
import br.com.alura.aluraviagens.utils.FormatUtil;
import br.com.alura.aluraviagens.utils.MoedaUtil;
import br.com.alura.aluraviagens.utils.ResourceUtil;

import static br.com.alura.aluraviagens.ui.activities.PacoteActivityConstants.NOME_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        configuraPacoteRecebido();
    }

    private void configuraPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(NOME_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(NOME_PACOTE);

            carregaCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
        botaoPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(NOME_PACOTE, pacote);
        startActivity(intent);
    }

    private void carregaCampos(Pacote pacote) {
        mostraLocal(pacote.getLocal());
        mostraImagem(pacote.getImagem());
        mostraDias(pacote.getDias());
        mostraPreco(pacote.getPreco());
        mostraData(pacote.getDias());
    }

    private void mostraData(int diasViagem) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataPacoteViagem = DataUtil.formataData(diasViagem);
        data.setText(dataPacoteViagem);
    }



    private void mostraPreco(BigDecimal precoPacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatado = MoedaUtil.formataMoeda(precoPacote);
        preco.setText(precoFormatado);
    }

    private void mostraDias(int diasViagem) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasTexto = FormatUtil.formataEmTexto(diasViagem);
        dias.setText(diasTexto);
    }

    private void mostraImagem(String imagemPacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawablePacote = ResourceUtil.getResource(imagemPacote, this);
        imagem.setImageDrawable(drawablePacote);
    }

    private void mostraLocal(String localPacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(localPacote);
    }
}