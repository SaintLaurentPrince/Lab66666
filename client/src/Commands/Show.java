/**
 * Класс команды Show
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;


import Controller.CommandWithoutArg;
import Controller.RouteCollection;
import RouteObject.Route;

public class Show implements CommandWithoutArg {


    @Override
    public String execute(Object o) {
        RouteCollection collection = new RouteCollection();
        String result = "";
        if (collection.getSize() == 0) return ("Коллекция пустая.");
        else for (Route route : collection.getCollection())
            result+=(route.getInfo());
        return result;
    }

    @Override
    public String getName() {
        return "show";
    }
}
