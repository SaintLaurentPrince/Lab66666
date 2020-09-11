/**
 * Класс команды Sort
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;
import RouteObject.Route;


public class Sort implements CommandWithoutArg {

    @Override
    public String execute(Object o) {
        RouteCollection collection = new RouteCollection();
        if (collection.getSize() != 0) {
            collection.toSortArray();
            long i=0;
            long amount= RouteCollection.getFreeId();
            for (Route route: collection.getCollection()){
                if (route.getId() < amount){
                    i++;
                    route.setId(i);
                }
            }
            return ("Коллекция успешно отсортировна.");
        } else return ("Коллекция пустая.");
    }

    @Override
    public String getName() {
        return "sort";
    }
}