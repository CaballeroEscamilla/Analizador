package analizador.sintactico.semantico.mio;

import java.util.ArrayList;
import java.util.List;


public class Analizador_Lexico {

    public List<String> AnalizarLex(List<String> list) {
        List<String> tokensList = new ArrayList<>();

        for (String line : list) {
            tokensList.addAll(Comparar(line));
        }

        // Obtener el nombre del archivo
        String NombreArchivo = "factorial.lex";
        // Guardar la secuencia de tokens en un archivo
        Escritor escritor = new Escritor();
        escritor.escribir(NombreArchivo, tokensList);

        // Notificar la generación del archivo
        System.out.println("Se generó el archivo " + NombreArchivo + " en el dispositivo.");

        return tokensList;
    }

    public List<String> Comparar(String line) {
        Tabla_de_simbolos tabla = new Tabla_de_simbolos();
        String[] palabras = line.split("\\s+");
        List<String> result = new ArrayList<>();

        for (String palabra : palabras) {
            String add = tabla.verificarExistencia(palabra);
            if (add != null) {
                result.add(add);
            } else {
                add = tabla.verificarIdentificador(palabra);
                if (add != null) {
                    result.add(add);
                } else {
                    add = tabla.verificarLiteralesNum(palabra);
                    if (add != null) {
                        result.add(add);
                    } else {
                        add = tabla.verificarLiteralesTxt(palabra);
                        if (add != null) {
                            result.add(add);
                        } else {
                            result.add("Error: No hay coincidencia");
                        }
                    }
                }
            }
        }
        return result;
    }
}
