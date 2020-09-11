/**
 * Класс команды Add
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.Route;
import RouteObject.RouteBuilder;
import Utilities.ServerReceiver;
import Utilities.ServerSender;

public class Add implements Commandable {
    RouteCollection collection = new RouteCollection();

    /**
     * @param o название трассы
     * @return
     */

    @Override
    public String execute(Object o) {
        ServerSender.send(o,1);
       Route r= (Route) ServerReceiver.receive();
        if (r!=null) {
            r.setId(RouteCollection.getFreeId());
            collection.add(r);
        return ("Трасса успешно добавлена.");}
        return "";
    }

    @Override
    public String getName() {
        return "add";
    }
}