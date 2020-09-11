/**
 * Класс main
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */


import Controller.*;
import Commands.*;
import Utilities.Decoder;
import Utilities.FileReader;
import Utilities.ServerReceiver;
import Utilities.ServerSender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        /**
         * Автоматичское заполнение коллекции из файла, имя которого передано как аргумент командной строки
         */
        String filename = "";
        if (args.length != 0) filename = args[0];
        FileReader.setFilename(filename);

        checkForSaveCommand();
        ServerSender serverSender = new ServerSender();
        ServerReceiver serverReceiver = new ServerReceiver("localhost",3019);
        RouteCollection routeCollection = new RouteCollection();
        Decoder.fillCollection(FileReader.read(filename));//FileReader.setFilename("rofl.csv");
        Commands commands = new Commands();
        commands.regist(new Show(), new Exit(), new Help(), new Info(), new Clear(), new Remove_first(),
                new Execute_script(), new Add(), new Sort(), new Update(), new Remove_by_id(),
                new Filter_less_than_distance(), new Filter_contains_name(), new Add_if_min(), new Min_by_id());
        Scanner in = new Scanner(System.in);
        /**
         * Цикл работы ввода команд
         */
        while (true) {
            try {
            Map<Commandable, String> commandableStringMap = (Map<Commandable, String>) ServerReceiver.receive();
                ServerReceiver.isBusy = true;
                System.out.println("Принял команду "+commandableStringMap.entrySet().iterator().next().getKey().getName()+" от клиента.");
                String answer = commandableStringMap.entrySet().iterator().next().getKey().execute(commandableStringMap.entrySet().iterator().next().getValue());
                serverSender.send(answer, 0);
                ServerReceiver.isBusy = false;
            } catch (Exception e) {
                ServerSender.currentClientSocket.close();
                System.out.println("Клиент не cтал заполнять поля и отключился :(");
                ServerReceiver.isBusy = false;
            }
        }
    }

    private  static  Thread backgroundReaderThread = null;
    public static void checkForSaveCommand() throws IOException {
        backgroundReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!Thread.interrupted()) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.equalsIgnoreCase("save")){
                            Save s = new Save();
                            s.execute(null);
                        }
                        if (line.equalsIgnoreCase("exit")){
                            Save s = new Save();
                            s.execute(null);
                            System.out.println("Завершаю работу.");
                            System.exit(0);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundReaderThread.start();
    }
}
