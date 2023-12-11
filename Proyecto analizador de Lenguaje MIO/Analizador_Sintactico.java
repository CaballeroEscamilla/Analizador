package analizador.sintactico.semantico.mio;

import java.util.List;

public class AnalizadorSintactico {

    private List<String> tokens;
    private int index;

    public AnalizadorSintactico(List<String> tokens) {
        this.tokens = tokens;
        this.index = 0;
    }

    public boolean analizar() {
        return programa() && match("FINPROG");
    }

    private boolean programa() {
        return match("PROGRAMA") && match("[id]") && sents();
    }

    private boolean sents() {
        return sent() && sents();
    }

    private boolean sent() {
        if (match("[id]")) {
            if (match("=")) {
                return elem() && match("[op_ar]") && elem();
            }
            return true;
        } else if (match("SI")) {
            if (compara() && match("ENTONCES") && sents()) {
                if (match("SINO")) {
                    return sents() && match("FINSI");
                }
                return match("FINSI");
            }
            return false;
        } else if (match("REPITE")) {
            if (elem() && match("VECES") && sents()) {
                return match("FINREP");
            }
            return false;
        } else if (match("IMPRIME")) {
            return elem();
        } else if (match("LEE")) {
            return match("[id]");
        } else if (match("#")) {
            //para revisar comentarios
            return true;
        }
        return false;
    }

    private boolean elem() {
        return match("[id]") || match("[val]");
    }

    private boolean compara() {
        return match("[id]") && match("[op_rel]") && elem();
    }

    private boolean match(String expected) {
        if (index < tokens.size() && tokens.get(index).equals(expected)) {
            index++;
            return true;
        }
        return false;
    }
}


