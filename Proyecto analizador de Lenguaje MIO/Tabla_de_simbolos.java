public class Tabla_de_simbolos {
    String Identificadores[][] = new String[2000][2];
    String LiteralesTxt[][] = new String[2000][2];
    String LiteralesNum[][] = new String[2000][2];
    String PalabrasReservadas[] = {"PROGRAMA", "FINPROG", "SI", "ENTONCES", "SINO", "FINSI", "REPITE", "VECES", "FINREP", "IMPRIME", "LEE"};
    String Operadores[] = {"+", "-", "*", "/", "<", ">", "#", "=", "=="};

    public String verificarExistencia(String cadena) {
    for (int i = 0; i < 11; i++) {
        if ((i < PalabrasReservadas.length && cadena.equals(PalabrasReservadas[i])) ||
            (i < Operadores.length && cadena.equals(Operadores[i])) ||
            (i < Identificadores.length && Identificadores[i] != null && Identificadores[i].length > 2 && cadena.equals(Identificadores[i][2])) ||
            (i < LiteralesTxt.length && LiteralesTxt[i] != null && LiteralesTxt[i].length > 2 && cadena.equals(LiteralesTxt[i][2])) ||
            (i < LiteralesNum.length && LiteralesNum[i] != null && LiteralesNum[i].length > 2 && cadena.equals(LiteralesNum[i][2]))) {
            return cadena;
        }
    }
    return null;
}

    public String verificarIdentificador(String cadena) {
        if (cadena.length() > 0 && cadena.charAt(0) != '0' && cadena.charAt(0) != '1' && cadena.charAt(0) != '2' &&
                cadena.charAt(0) != '3' && cadena.charAt(0) != '4' && cadena.charAt(0) != '5' &&
                cadena.charAt(0) != '6' && cadena.charAt(0) != '7' && cadena.charAt(0) != '8' &&
                cadena.charAt(0) != '9' && cadena.charAt(0) != '"') {
            if (cadena.length() <= 16) {
                int i = 0;
                if (i < 2000 && (Identificadores[i][0] != null)) {
                    i++;
                }else if (Identificadores[i][1] == null) {
                    Identificadores[i][0] = "ID" + i;
                    Identificadores[i][1] = cadena;
                    return Identificadores[i][0];
                }
            } else {
                System.out.println("datos demasiado grandes");
        }
    }
        return null;
    }


    public String verificarLiteralesTxt(String cadena) {
        if (cadena.length() > 0 && cadena.charAt(0) == '"') {
            if (cadena.length() >= 2 && cadena.charAt(cadena.length() - 1) == '"') {
                int i = 0;
                if (i < 2000 && (LiteralesTxt[i][1] != null)) {
                    i++;
                }else if (LiteralesTxt[i][1] == null) {
                    LiteralesTxt[i][0] = "TX" + i;
                    LiteralesTxt[i][1] = cadena;
                    return LiteralesTxt[i][0];
                }
                else {
                // ¿Qué debería suceder si la cadena de texto no cierra con comillas?
                System.out.println("Error: La cadena de texto no cierra con comillas");
                }
            }
        }
        return null;
    }
    public String verificarLiteralesNum(String cadena) {
        if (cadena.startsWith("0X") || cadena.startsWith("0x")) {
            int i = 0;
            if (i < 2000 && LiteralesNum[i][1] != null) {
                i++;
            }else if (LiteralesNum[i][1] == null) {
                LiteralesNum[i][1] = cadena;
                cadena = cadena.substring(2);
                int valor = Integer.parseInt(cadena, 16);
                String cad = String.valueOf(valor);
                LiteralesNum[i][2] = cad;
                return LiteralesNum[i][2];
            }
        }
        return null;
    }
}