package br.com.alura.aluraviagens.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.model.Pacote;

public class MoedaUtil {

    public static final String LANGUAGE = "pt";
    public static final String PAIS = "br";
    public static final String FORMATO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    public static String formataMoeda(BigDecimal preco) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE, PAIS));
        return formatoBrasileiro.format(preco).replace(FORMATO, FORMATO_COM_ESPACO);
    }
}
