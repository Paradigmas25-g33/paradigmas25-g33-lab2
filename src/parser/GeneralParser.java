package parser;

import java.io.FileReader;
import java.io.IOException;

/*Esta clase modela los atributos y metodos comunes a todos los distintos tipos de parser existentes en la aplicacion*/
public abstract class GeneralParser {

    // Método común para leer un archivo
    protected String readFile(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        StringBuilder content = new StringBuilder();
        int i;
        while ((i = reader.read()) != -1) {
            content.append((char) i);
        }
        reader.close();
        return content.toString();
    }

    // Método abstracto que cada parser debe implementar
    public abstract Object parse(String filePath);
}
