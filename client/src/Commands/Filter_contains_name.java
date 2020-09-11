/**
 * Класс команды Filter_contains_name
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.Route;

public class Filter_contains_name implements Commandable {
    @Override
    public String execute(Object o) {
        String subSt = (String) o;
        boolean was = false;
        RouteCollection collection = new RouteCollection();
        String result = "";
        if (collection.getSize() == 0) return ("Коллекция пустая.");

        else for (Route route : collection.getCollection()) {
            if (route.getName().indexOf(subSt) != -1) {
                was = true;
                result += (route.getInfo());
            }
        }
        if (!was) return ("Нет таких элементов в коллекции");
        else return result;
    }


    @Override
    public String getName() {
        return "filter_contains_name";
    }
}
