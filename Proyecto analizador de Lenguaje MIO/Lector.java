package analizador.sintactico.semantico.mio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lector{
    public List<String> read(){
        
        String filePath = null;
        List<String> Linelist = new ArrayList<>();
        
        // Crear un nuevo objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        
        // Agregar filtro para archivos JSON
        FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("TXT  Files", "txt");
        fileChooser.setFileFilter(jsonFilter);
        
        // Permitir la selección de un solo archivo
        fileChooser.setMultiSelectionEnabled(false);
        
        // Mostrar el cuadro de diálogo y obtener la respuesta del usuario
        int result = fileChooser.showOpenDialog(null);
        
        // Si el usuario seleccionó un archivo
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta del archivo seleccionado
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            
            // Hacer algo con la ruta del archivo, como imprimir en la consola
            System.out.println("Selected File: " + selectedFilePath);
            filePath = selectedFilePath;
        }
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
