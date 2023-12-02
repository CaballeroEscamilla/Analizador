
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lector{
    public List<String> read(){
        String filePath = "juan.txt";
        List<String> Linelist = new ArrayList<>();
        
        // Crear una instancia de la clase File
        File file = new File(filePath);

        try {
             // Crear una instancia de FileReader y BufferedReader para leer el archivo
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Leer cada línea del archivo
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Linelist.add(line);
            }

            // Cerrar el BufferedReader después de su uso
            bufferedReader.close();

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return Linelist;
    }
     
}
