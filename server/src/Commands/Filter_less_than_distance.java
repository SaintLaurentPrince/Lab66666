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
            long sampleDistance = Long.parseLong((String) o);
            Vector<Route> collection = RouteCollection.getCollection();
            StringBuilder builder = new StringBuilder("");
            collection.stream().filter(x -> x.getDistance()<sampleDistance).forEach(x -> builder.append(x.getInfo() + "\n"));
            if (builder.toString().equals("")) return ("Таких элементов в коллекции нет");
            else return builder.toString();
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
