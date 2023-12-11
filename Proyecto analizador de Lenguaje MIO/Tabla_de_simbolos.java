package analizador.sintactico.semantico.mio;

public class Tabla_de_simbolos{
    String Identificadores[][];
    String LiteralesTxt[][];
    String LiteralesNum[][];
    String PalabrasReservadas[] = {"PROGRAMA", "FINPROG", "SI", "ENTONCES", "SINO", "FINSI", "REPITE", "VECES", "FINREP", "IMPRIME", "LEE"};
    String Operadores[] = {"+", "-", "*", "/", "<", ">", "#", "=", "=="};

    public String verificarExistencia(char cadena[]){
        String Cadena = cadena.toString();
       for(int i = 0; i < 11 ; i++){
           if(Cadena == PalabrasReservadas[i]){
               return Cadena;
           }else if(Cadena == Operadores[i]){
               return Cadena;
           }else if(Cadena == Identificadores[i][2]){
               return Cadena;
           }else if(Cadena == LiteralesTxt[i][2]){
               return Cadena;
           }else if(Cadena == LiteralesNum[i][2]){
               return Cadena;
           }
       }
       return Cadena = null;
    }

    public String verificarIdentificador(char Caden[]){
        String Cadena = Caden.toString();
        if (Caden[0] != (0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | '"')) {
            if (Cadena.length() <= 16 ) {
                int i = 0;
                while(Cadena != null){
                    if(Identificadores[i][1] == null){
                        Identificadores[i][1] = "ID"+ i;
                        Identificadores[i][2] = Cadena;
                        return Identificadores[i][1];
                    }
                    i++;
                }
            }else{

            }   
        }
        return Cadena = null;
    }

    public String verificarLiteralesTxt(char Caden[]){
        String Cadena = Caden.toString();
        if (Caden[0] == '"') {
            if (Caden[Cadena.length()-1] == '"') {
                int i = 0;
                while(Cadena != null){
                    if(LiteralesTxt[i][1] == null){
                        LiteralesTxt[i][1] = "TX"+ i;
                        LiteralesTxt[i][2] = Cadena;
                        return LiteralesTxt[i][1];
                    }
                    i++;
                }
            }else{
                    
            }   
        }
        return Cadena = null;

    }
    
    public String verificarLiteralesNum(char Caden[]){
        String Cadena = Caden.toString();
        if (Caden[0] == '0' && Caden[1] == ('X' | 'x') ) {   
            int i = 0;
            while(Cadena != null){
                if(Caden[i] == ('0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' | 'A' | 'B' | 'C'| 'D' | 'E' | 'F')){
                    if(LiteralesTxt[i][1] == null){
                        LiteralesTxt[i][1] = Cadena;
                        // Eliminar el "0X" al principio antes de analizar la cadena como un número hexadecimal
                        if (Cadena.startsWith("0X") || Cadena.startsWith("0x")) {
                            Cadena = Cadena.substring(2);
                        }
                        // Analizar la cadena como un número hexadecimal
                        int valor = Integer.parseInt(Cadena, 16);
                        String cad = String.valueOf(valor);
                        LiteralesTxt[i][2] = cad;
                        return LiteralesTxt[i][2];
                    }
                }
                i++;
            } 

       }
       return Cadena = null;
    }
}
