package br.com.alura.aluraviagens.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
    public static final String DIA_E_MES = "dd/MM";

    public static String formataData(int diasViagem) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, diasViagem);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoData = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = formatoData.format(dataIda.getTime());
        String dataFormatadaVolta = formatoData.format(dataVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }
}
