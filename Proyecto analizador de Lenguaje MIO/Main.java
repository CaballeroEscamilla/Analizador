import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> List = new ArrayList<>();
        List<String> ListLex = new ArrayList<>();
        Lector reader = new Lector();
        Analizador_Lexico AnalizarLexi = new Analizador_Lexico();

        List = reader.read();
        for (String elemento : List) {
            System.out.println(elemento);
        }

        ListLex = AnalizarLexi.AnalizarLex(List);

        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(ListLex);
        boolean compilacionExitosa = analizadorSintactico.analizar();

        Escritor escritor = new Escritor();
        escritor.escribir("factorial.sint", ListLex, compilacionExitosa);
    }
}