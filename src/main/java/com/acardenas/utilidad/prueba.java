package com.acardenas.utilidad;

import java.util.regex.Pattern;

public class prueba {

    private static final String PATRON_LETRAS_NUMEROS = "[\\s{2,}]";

    public static void main(String[] args) {
        System.out.println(dejarAlfaNumericosYCaracteresDeXML("<COD_ESTADO>2</COD_ESTADO>\\n\" +\n" +
                "                \"        <DES_VIA>CALLE</DES_VIA>\\n\" +\n" +
                "                \"        <DIRECCION>\tDublin    Prueba</DIRECCION>\\n\" +\n" +
                "                \"        <NUMERO>7</NUMERO>"));
    }

    public static String dejarAlfaNumericosYCaracteresDeXML(String cadena) {
        Pattern pattern = Pattern.compile(PATRON_LETRAS_NUMEROS);
        String cadenaComprobada;
        try {
            cadenaComprobada = RegExpUtil.quitarCoincidencias(cadena, pattern);
        } catch ( Exception e) {
            e.printStackTrace();
            return cadena;
        }
        return cadenaComprobada;
    }
}
