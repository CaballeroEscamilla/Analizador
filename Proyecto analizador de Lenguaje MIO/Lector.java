
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
     public void read(){
        String filePath = "juan.txt";

     // Crear una instancia de la clase File
     File file = new File(filePath);

     try {
         // Crear una instancia de FileReader y BufferedReader para leer el archivo
         FileReader fileReader = new FileReader(file);
         BufferedReader bufferedReader = new BufferedReader(fileReader);

         // Leer cada línea del archivo
         String line;
         while ((line = bufferedReader.readLine()) != null) {
             System.out.println(line);
         }

         // Cerrar el BufferedReader después de su uso
         bufferedReader.close();

     } 
     catch (IOException e) {
         e.printStackTrace();
     }
     }
     
}
