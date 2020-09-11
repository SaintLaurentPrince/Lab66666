/**
 * Класс команды Update
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.Route;
import Utilities.ServerReceiver;
import Utilities.ServerSender;

public class Update implements Commandable {

    @Override
    public String execute(Object arg) {
        RouteCollection collection = new RouteCollection();
        try {
            if (collection.isIndexBusy(Integer.parseInt((String) arg))) {
                int id = Integer.parseInt((String) arg);
                Route route1 = null;
                String oldName = "";
                for (Route route : collection.getCollection()) {
                    if (route.getId() == id) {
                        route1 = route;
                    }
                }
                ServerSender.send(route1, 2);
                Route route = (Route) ServerReceiver.receive();
                if (route != null) {
                    collection.add(route);
                    int ok = Integer.parseInt((String) arg);
                    collection.update(ok);
                }
                return ("Трасса [id:" + arg + "] успешно обновлена.");
            } else return ("Элемента с таким id не существует.");
        } catch (Exception e) {

            return ("Элемента с таким id не существует.");
        }
    }

    @Override
    public String getName() {
        return "update";
    }
}

