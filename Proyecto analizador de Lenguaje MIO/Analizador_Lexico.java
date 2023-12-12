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
        List<String> result = new ArrayList<>();
        StringBuilder literal = new StringBuilder();  // Para almacenar literales entre comillas
        boolean insideQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '\"') {
                insideQuotes = !insideQuotes; // Cambiar el estado dentro/fuera de las comillas
                if (!insideQuotes) {
                    // Si estamos fuera de las comillas, agregar el literal al resultado
                    result.add("[txt]");
                    result.add(literal.toString());
                    literal.setLength(0);  // Limpiar el StringBuilder para el próximo literal
                }
            } else if (insideQuotes) {
                // Si estamos dentro de las comillas, agregar el carácter al literal actual
                literal.append(c);
            } else if (Character.isWhitespace(c)) {
                // Si encontramos un espacio fuera de las comillas, verificar la palabra
                String palabra = literal.toString();
                if (!palabra.isEmpty()) {
                    String add = tabla.verificarExistencia(palabra);
                    if (add != null) {
                        result.add(add);
                    } else if (palabra.equals("LEE") || palabra.equals("REPITE")) {
                        // Tratar "LEE" y "REPITE" como palabras clave
                        result.add("[" + palabra + "]");
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
                                    // Si no coincide con nada, tratar como identificador por defecto
                                    result.add("[id]");
                                    result.add(palabra);
                                }
                            }
                        }
                    }
                    literal.setLength(0);  // Limpiar el StringBuilder para la próxima palabra
                }
            } else {
                // Si no es un espacio ni una comilla, agregar el carácter al literal actual
                literal.append(c);
            }
        }

        // Agregar el último literal si hay alguno
        if (literal.length() > 0) {
            String palabra = literal.toString();
            String add = tabla.verificarExistencia(palabra);
            if (add != null) {
                result.add(add);
            } else if (palabra.equals("LEE") || palabra.equals("REPITE")) {
                // Tratar "LEE" y "REPITE" como palabras clave
                result.add("[" + palabra + "]");
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
                            // Si no coincide con nada, tratar como identificador por defecto
                            result.add("[id]");
                            result.add(palabra);
                        }
                    }
                }
            }
        }
        return result;
    }   
}
    
