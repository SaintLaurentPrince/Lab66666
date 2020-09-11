/**
 * Класс FileReader, предназначенный для чтения из файла с помощью Scanner
 * @author SaintLaurentPrince and Mariec
 * @version 2.0
 */

package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private static String filename = "";

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        FileReader.filename = filename;
    }


    public static String read(String filename) {
        try {
            File file = new File(filename);
            Scanner in = new Scanner(file);
            String data = "";
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();
                data += line;
                data+="\n";
            }
            return data;
        } catch (FileNotFoundException e) {
            if (filename.equals("")) System.out.println("Вы не указали имя файла.");
            else System.out.println("Указанный файл не найден.");
            return null;
        }
    }
}
