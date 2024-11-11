package com.ms.notificaciones.domain.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CorreoUtil {

    public String reemplazarTexto(String body, LinkedHashMap<String, Object> parametros) {
        // Patrón para encontrar los marcadores de posición en el texto
        Pattern patron = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = patron.matcher(body);
        StringBuffer resultado = new StringBuffer();

        while (matcher.find()) {
            String clave = matcher.group(1);
            Object valor = parametros.get(clave);  // Obtenemos el valor del LinkedHashMap

            if (valor != null) {
                matcher.appendReplacement(resultado, valor.toString());
            } else {
                matcher.appendReplacement(resultado, "#####");  // Si no encuentra la clave, usamos un placeholder
            }
        }

        matcher.appendTail(resultado);
        return resultado.toString();
    }

    private static String capitalizar(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }

}
