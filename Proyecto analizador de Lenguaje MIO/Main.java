import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        List<String> List = new ArrayList<>();
        Lector reader = new Lector();
        List = reader.read();
        for (String elemento : List) {
            System.out.println(elemento);
        }
    }
}
