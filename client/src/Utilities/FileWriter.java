/**
 * Класс FileWriter, предназначенный для записи коллекции в файл
 * @author SaintLaurentPrince and Mariec
 * @version 2.0
 */


package Utilities;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public static void write(String filename, String data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte bytes[] = data.getBytes();
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
        fileOutputStream.close();
    }
}
