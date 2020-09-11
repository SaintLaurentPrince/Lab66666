package Utilities;

import RouteObject.Route;
import RouteObject.RouteBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Client receiver.
 */
public class ClientReceiver {
    ClientSender clientSender;
    public ClientReceiver(ClientSender clientSender){
        this.clientSender = clientSender;
    }
    /**
     * The constant client.
     */
    public static Socket socket;
    private static ByteBuffer buffer = ByteBuffer.allocate(10000);
    public Object receive() throws IOException, ClassNotFoundException, SocketTimeoutException {
        socket.setSoTimeout(2500);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object obj = objectInputStream.readObject();
        RouteBuilder routeBuilder = new RouteBuilder();
        Map<Object,Integer> answerMap = (Map<Object, Integer>) obj;
        obj = answerMap.entrySet().iterator().next().getKey();
        int a = answerMap.entrySet().iterator().next().getValue();
        if (a == 0) {
            return obj;
        }
        // новый маршрут
        else if (a == 1){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            clientSender.send(routeBuilder.create((String)obj,"free"));
            obj =this.receive();
        }
        // апдейт маршрута с номером
        else if (a == 2){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            Route route = (Route)obj;
            RouteBuilder.routeToUpd = route;
            clientSender.send(routeBuilder.create(route.getName(),String.valueOf(route.getId())));
            RouteBuilder.routeToUpd = null;
            obj =this.receive();
        }

        return obj;
    }
}