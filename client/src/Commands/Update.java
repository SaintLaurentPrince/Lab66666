/**
 * Класс команды Update
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.Coordinates;
import RouteObject.Route;
import RouteObject.RouteBuilder;

import java.time.ZonedDateTime;

public class Update implements Commandable {

    @Override
    public String execute(Object arg) {
        RouteCollection collection = new RouteCollection();
        try {
            if (collection.isIndexBusy(Integer.parseInt((String) arg))) {
                int id=Integer.parseInt((String) arg);
                String oldName = "";
                for (Route route : collection.getCollection()){
                    if (route.getId()==id){
                        oldName=route.getName();
                    }
                }
                collection.add((new RouteBuilder()).create(oldName, (String) arg));
                int ok= Integer.parseInt((String) arg);
                collection.update(ok);
                return ("Трасса [id:" + arg + "] успешно обновлена.");
            } else return ("Элемента с таким id не существует.");
        } catch (Exception e) {
            e.printStackTrace();
            return ("Элемента с таким id не существует.");
        }
    }

    @Override
    public String getName() {
        return "update";
    }
}

