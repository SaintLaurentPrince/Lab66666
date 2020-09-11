/**
 * Класс команды Add_if_min
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

import java.util.Collections;
import java.util.Vector;

public class Add_if_min implements Commandable {

    /**
     * @param o название трассы
     * @return
     */

    @Override
    public String execute(Object o) {
        if ((new RouteCollection().getSize() != 0)) {
            Vector<Route> collection = RouteCollection.getCollection();
            Collections.sort(collection);
            ServerSender.send(o,1);
            Route sample = ((Route) ServerReceiver.receive());
            if (sample.compareTo(collection.get(0)) < 0) {
                if (sample!=null) {
                    sample.setId(RouteCollection.getFreeId());
                    collection.add(sample);
                }
                return ("Трасса успешно добавлена.");
            } else return ("Элемента меньше не оказалось");
        } else return ("Коллекция пустая, даже сравнить не с чем(");
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
