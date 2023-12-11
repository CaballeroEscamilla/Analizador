package analizador.sintactico.semantico.mio;

import java.util.List;
import java.util.ArrayList;

public class Analizador_Lexico {

    public List<String> AnalizarLex(List<String> List) {
        List<String> Elementoslex = new ArrayList<>();

        for (String Elemento : List) {
            Elementoslex.addAll(Comparar(Elemento));
        }

        return Elementoslex;
    }

    public List<String> Comparar(String elemento) {
        Tabla_de_simbolos Tabla = new Tabla_de_simbolos();
        String[] palabras = elemento.split("\\s+");
        List<String> result = new ArrayList<>();

        for (String palabra : palabras) {
            String add = Tabla.verificarExistencia(palabra);
            if (add != null) {
                result.add(add);
            } else {
                add = Tabla.verificarIdentificador(palabra); 
                if (add != null) {
                    result.add(add);
                } else {
                    add = Tabla.verificarLiteralesNum(palabra);
                    if (add != null) {
                        result.add(add);
                    } else {
                        add = Tabla.verificarLiteralesTxt(palabra); 
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


