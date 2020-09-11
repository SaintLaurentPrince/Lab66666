package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;
import RouteObject.Route;
import Utilities.FileReader;
import Utilities.FileWriter;

import java.io.IOException;
import java.util.Scanner;

public class Save implements CommandWithoutArg {

    @Override
    public String execute(Object o) throws IOException {
        Scanner in = new Scanner(System.in);
        String filename = FileReader.getFilename();
        while (filename.equals("")){
            System.out.print("Вы не указали имя файла изначально, укажите сейчас:\n$ ");
            filename = in.nextLine();
        }
        String csv = "";
        for (Route route : RouteCollection.getCollection())
            csv += route.getCSV() + "\n";
        FileWriter.write(filename, csv);
        System.out.println(("Коллекция успешно сохранена."));
        return null;
    }

    @Override
    public String getName() {
        return "save";
    }
}