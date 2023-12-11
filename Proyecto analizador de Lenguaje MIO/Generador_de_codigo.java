package analizador.sintactico.semantico.mio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escritor {
    public void escribir(String fileName, List<String> content, boolean compilacionExitosa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }

            if (compilacionExitosa) {
                writer.write("Compilación exitosa");
            } else {
                writer.write("Error de sintaxis");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribir(String fileName, List<String> content) {
        escribir(fileName, content, true); // Asumes compilación exitosa por defecto
    }
}
