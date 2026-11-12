package br.com.alura.aluraviagens.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.alura.aluraviagens.model.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getResource(String imagemId, Context context) {
        Resources resources = context.getResources();
        //params: nome da imagem do pacote, tipo do resource que será buscado, pacote base para buscar o recurso
        int idDrawable = resources.getIdentifier(imagemId, DRAWABLE, context.getPackageName());//devolve um id(int) que representa o id do recurso encontrado
        return resources.getDrawable(idDrawable);
    }
}
