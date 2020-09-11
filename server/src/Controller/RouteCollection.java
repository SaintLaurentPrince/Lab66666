/**
 * Класс RouteCollection
 * Коллекция Vector содержит трассы
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Controller;


import RouteObject.Route;
import RouteObject.RouteBuilder;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class RouteCollection implements Serializable {
    private static Vector<Route> collection = new Vector<Route>();
    private static LocalDate creationDate;
    public RouteCollection() {
        creationDate = LocalDate.now();
    }

    public static Vector<Route> getCollection() {
        return collection;
    }

    public static void setCollection(Vector<Route> collection) {
        RouteCollection.collection = collection;
    }

    public static LocalDate getCreationDate() {
        return creationDate;
    }

    public static void setCreationDate(LocalDate creationDate) {
        RouteCollection.creationDate = creationDate;
    }

    public void clear(){ collection.clear(); }

    public static long getFreeId(){
        long size = collection.size();
        Hashtable<Long, String > busyIds= new Hashtable<Long, String>();
        for (Route route: collection){
            busyIds.put(route.getId(), "id");
        }
        long id = 1;
        while (true){
            if (busyIds.get(id) == null)
                return id;
            else id ++;
        }
    }
    public int getSize(){
        return collection.size();
    }


    public String getInfo() {
        return "Тип коллекции: Vector\nРазмер коллекции: " + this.getSize() + "\nВремя создания: " + creationDate;
    }
    public boolean isIndexBusy(int id){
        for (Route route: collection)
            if (route.getId() == id) return true;
        return false;
    }
    public void toSortArray() {
        Collections.sort(collection);
    }
    public void add(Route route) {
        collection.add(route);
    }
    public void set(int id, Route route) {
        collection.set(id,route);
    }

    public void update(int id){
        id=id-1;
        collection.set(id,collection.remove(collection.indexOf(collection.lastElement())));
    }

    public void removeFirst() {
        collection.remove(0);
    }

    public Route getMinById() {
        long minId = Long.MAX_VALUE;
        Route minRoute = null;
        for (Route route: collection){
            if (route.getId() < minId){
                minId = route.getId();
                minRoute = route;
            }
        }
        return minRoute;
    }
}




