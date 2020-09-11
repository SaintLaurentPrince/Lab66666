/**
 * Класс команды Add
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.RouteBuilder;

public class Add implements Commandable {
    RouteCollection collection = new RouteCollection();

    /**
     * @param o название трассы
     */

    @Override
    public String execute(Object o) {
        collection.add((new RouteBuilder()).create((String) o,"free"));
        return ("Трасса успешно добавлена.");
    }

    @Override
    public String getName() {
        return "add";
    }
}