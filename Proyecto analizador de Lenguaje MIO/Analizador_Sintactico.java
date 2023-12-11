import java.util.*;

public class Analizador_Lexico {

    public List<String> AnalizarLex(List<String> List) {
        char[] LineCode;
        char[] AnalizandoP;
        List<String> Elementoslex = new ArrayList<>();

        for (String Elemento : List) {
            LineCode = Elemento.toCharArray();
            AnalizandoP = new char[Elemento.length()]; // Inicializar AnalizandoP

            for (int j = 0; j < Elemento.length(); j++) {
                if (LineCode[j] != '#' && LineCode[j] != ' ') {
                    AnalizandoP[j] = LineCode[j];
                } else if (LineCode[j] == ' ') {
                    Elementoslex.add(Comparar(AnalizandoP));
                }
            }
        }
        return Elementoslex;
    }

    public String Comparar(char[] cadena) {
        Tabla_de_simbolos Tabla = new Tabla_de_simbolos();
        String add;

        if ((add = Tabla.verificarExistencia(cadena)) != null) {
            return add;
        } else if ((add = Tabla.verificarIdentificador(cadena)) != null) {
            return add;
        } else if ((add = Tabla.verificarLiteralesNum(cadena)) != null) {
            return add;
        } else if ((add = Tabla.verificarLiteralesTxt(cadena)) != null) {
            return add;
        }
        return "Error: No hay coincidencia";
    }
}
