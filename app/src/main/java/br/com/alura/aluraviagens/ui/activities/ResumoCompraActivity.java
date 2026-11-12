package br.com.alura.aluraviagens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.utils.DataUtil;
import br.com.alura.aluraviagens.utils.MoedaUtil;
import br.com.alura.aluraviagens.utils.ResourceUtil;

import static br.com.alura.aluraviagens.ui.activities.PacoteActivityConstants.NOME_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(NOME_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(NOME_PACOTE);

            carregaCampos(pacote);
        }
    }

    private void carregaCampos(Pacote pacote) {
        mostraLocal(pacote.getLocal());
        mostraImagem(pacote.getImagem());
        mostraData(pacote.getDias());
        mostraPreco(pacote.getPreco());
    }

    private void mostraPreco(BigDecimal precoPacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String precoFormatado = MoedaUtil.formataMoeda(precoPacote);
        preco.setText(precoFormatado);
    }

    private void mostraData(int diasPacote) {
        TextView data = findViewById(R.id.resumo_compra_data_pacote);
        String dataFormatada = DataUtil.formataData(diasPacote);
        data.setText(dataFormatada);
    }

    private void mostraImagem(String imagemPacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable imagemDrawable = ResourceUtil.getResource(imagemPacote, this);
        imagem.setImageDrawable(imagemDrawable);
    }

    private void mostraLocal(String localPacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(localPacote);
    }
}