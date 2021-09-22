package com.acardenas.utilidad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtil {

    private static final Class<RegExpUtil> MY_CLASS = RegExpUtil.class;
    public static final String EMAIL_REGEX = "^(.+)@(.+)$";

    private RegExpUtil() {
        // constructor vacio
    }

    public static String encontrarCoincidencia(final String texto, final Pattern pattern) throws Exception{
        final Matcher matcher = pattern.matcher(texto);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            System.out.println(" no encontrado en el mensaje.");
            throw new Exception("Valor '" + pattern.toString().split("=")[0] + "' no encontrado en el mensaje.");
        }
    }

    public static String quitarCoincidencias(final String texto, final Pattern pattern) throws Exception{
        final Matcher matcher = pattern.matcher(texto);
        if (matcher.find()) {
            return matcher.replaceAll("");
        } else {
            return texto;
        }
    }
}
