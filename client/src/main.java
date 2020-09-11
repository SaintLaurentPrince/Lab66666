/**
 * Класс main
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */


import Controller.*;
import Commands.*;
import Utilities.*;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        ClientSender clientSender =new ClientSender(3019);
        ClientReceiver receiver = new ClientReceiver(clientSender);
        Commands commands = new Commands();
        commands.regist(new Show(), new Exit(), new Help(), new Info(), new Clear(), new Remove_first(),
                new Execute_script(), new Add(), new Sort(), new Update(), new Remove_by_id(),
                new Filter_less_than_distance(), new Filter_contains_name(), new Add_if_min(), new Min_by_id());
        while (true) {

            System.out.println("Введите команду,для справки введите help.");
            String commandName = Console.read();
            if (!commandName.equals("")) {
                if (commands.getCommand(commandName.split(" ")[0])!=null) {
                    try {
                        Map<Commandable,String> map= commands.executeCommand(commandName);
                        if (map!=null) {
                            ClientSender.connect();
                            clientSender.send(map);
                            if (Commands.timeTostop){
                                System.out.println("Завершаю работу по вашей просьбе."); System.exit(0);}
                            System.out.println(receiver.receive());
                            ClientSender.socketChannel.close();
                        }
                        if (Commands.timeTostop){
                            System.out.println("Завершаю работу по вашей просьбе."); System.exit(0);}

                    }
                    catch (SocketTimeoutException e){

                        System.out.println("Возможно сервер занят другим пользователем,подождите пожалуйста и попробуйте снова.");
                    }
                }
            }
        }
    }
}
