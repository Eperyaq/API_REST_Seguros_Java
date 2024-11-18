package com.es.segurosinseguros.utils;

public class ValidarNif {

    public static boolean validarNIF(String nif) {

        nif = nif.trim().toUpperCase();

        //Compruebo que tenga el patron correspondiente
        if (!nif.matches("\\d{8}[A-Z]")) {
            return false;
        }

        // Separo en números y letra
        int numero = Integer.parseInt(nif.substring(0, 8));
        char letra = nif.charAt(8);

        // Array de letras según la regla del NIF
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        // Calcular la letra esperada
        char letraCalculada = letras[numero % 23];

        // Comparar la letra esperada con la letra del NIF
        return letra == letraCalculada;
    }

}
