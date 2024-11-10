package com.ms.notificaciones.domain.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CorreoUtil {

    public String reemplazarTexto(String body, Object objeto) {
        // Patrón para encontrar los marcadores de posición en el texto
        Pattern patron = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = patron.matcher(body);
        StringBuffer resultado = new StringBuffer();
        while (matcher.find()) {
            String clave = matcher.group(1);
            try {
                Method metodo = objeto.getClass().getMethod("get" + capitalizar(clave));
                Object valor = metodo.invoke(objeto);
                matcher.appendReplacement(resultado, valor.toString());
            } catch (Exception e) {
                matcher.appendReplacement(resultado, "#####");
            }
        }
        matcher.appendTail(resultado);
        return resultado.toString();
    }

    private static String capitalizar(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }

}
