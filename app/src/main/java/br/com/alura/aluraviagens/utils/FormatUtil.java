package br.com.alura.aluraviagens.utils;

import br.com.alura.aluraviagens.model.Pacote;

public class FormatUtil {
    public static String formataEmTexto(int dias) {
        if(dias > 1) {
            return dias + " dias";
        }

        return dias + " dia";
    }
}
