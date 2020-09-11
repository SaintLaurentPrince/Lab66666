/**
 * Класс команды Execute_script
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Execute_script implements Commandable {

    static ArrayList<String> exScrHistory = new ArrayList<>();
    /**
     * @param arg название файла
     */

    @Override
    public String execute(Object arg) throws IOException {
        try {
            File file = new File((String) arg);
            Scanner in = new Scanner(file);
            Commands commands = new Commands();
            String result = "";
            String exFileName= "";
            while (in.hasNextLine()) {
                String command=in.nextLine();
                String[] exArg = command.split(" ");
                if(exArg.length == 2) {
                    exFileName = exArg[1];
                }
                if (!(command.equals(""))) {
                    if (!(command.equals("execute_script " + exFileName))) {
                        result+=("Команда \"" + command + "\":");
                        commands.executeCommand(command);
                        result+="\n";
                    }
                    else {
                        if (exScrHistory.contains("execute_script " + exFileName)) {
                            result+=("Команда \"" + command + "\": невыполнима во избежание бесконечной рекурсии .");
                        }
                        else {
                            exScrHistory.add("execute_script " + exFileName);
                            result+=("Команда \"" + command + "\":");
                            commands.executeCommand(command);
                            result+="\n";
                        }
                    }
                }
            }
            exScrHistory.clear();
            return result;
        } catch (NullPointerException | FileNotFoundException e) {
            return ("Указанный файл не найден.");
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
