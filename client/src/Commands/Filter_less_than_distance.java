/**
 * Класс команды Filter_less_than_distance
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.Route;

import java.util.Vector;

public class Filter_less_than_distance implements Commandable {
    @Override
    public String execute(Object o) {
        try{
            String result = "";
            long sampleDistance = Long.parseLong((String) o);
            Vector<Route> collection = RouteCollection.getCollection();
            boolean tumb = false;
            for(Route route: collection)
                if (route.getDistance() < sampleDistance) {
                    tumb = true;
                    result+= (route.getInfo());
                }
            if (!tumb) return ("Таких элементов в коллекции нет");
            else return result;
        }
        catch (Exception e){
            return ("Аргумент команды должен быть типа long");
        }

    }

    @Override
    public String getName() {
        return "filter_less_than_distance";
    }
}
