/**
 * Класс команды Info
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;


public class Info implements CommandWithoutArg {
    RouteCollection collection = new RouteCollection();

    @Override
    public String execute(Object o) {
        return(collection.getInfo());
    }

    @Override
    public String getName() {
        return "info";
    }
}