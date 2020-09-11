/**
 * Класс Decoder, прдназначенный для заполнения коллекции данными, прочитанными FileReader
 * @author SaintLaurentPrince and Mariec
 * @version 2.0
 */

package Utilities;

import Controller.RouteCollection;
import RouteObject.Coordinates;
import RouteObject.LocationFrom;
import RouteObject.LocationTo;
import RouteObject.Route;

import java.time.ZonedDateTime;
import java.util.Vector;

public class Decoder {

    public static Vector<Route> fillCollection(String data) {
        try {
            Vector<Route> collection = new Vector<Route>();
            String[] lines = data.split("\n|\r\n");
            for (String line : lines) {
                String[] params = line.split(",");
                Route route = new Route();
                route.setId(Long.parseLong(params[0]));
                route.setName(params[1]);
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Long.parseLong(params[2]));
                coordinates.setY(Integer.parseInt(params[3]));
                route.setCoordinates(coordinates);
                route.setCreationDate(ZonedDateTime.parse(params[4]));
                LocationFrom locationFrom = new LocationFrom();
                locationFrom.setName(params[5]);
                locationFrom.setX(Float.parseFloat(params[6]));
                locationFrom.setY(Long.parseLong(params[7]));
                locationFrom.setZ(Integer.parseInt(params[8]));
                route.setFrom(locationFrom);
                LocationTo locationTo = new LocationTo();
                locationTo.setX(Integer.parseInt(params[9]));
                locationTo.setY(Float.parseFloat(params[10]));
                locationTo.setZ(Long.parseLong(params[11]));
                route.setTo(locationTo);
                route.setDistance(Long.parseLong(params[12]));
                collection.add(route);
            }
            RouteCollection.setCollection(collection);
            System.out.println("Коллекция успешно заполнена.");
            return collection;
        } catch (Exception e) {
            System.out.println("Коллекция пустая.");
            return new Vector<Route>();
        }
    }
}