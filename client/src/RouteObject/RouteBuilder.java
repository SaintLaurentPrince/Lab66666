/**
 * Класс RouteBuilder, предназначен для создания трасс
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */


package RouteObject;

import Controller.Commands;
import Controller.RouteCollection;
import RouteObject.Coordinates;
import RouteObject.LocationFrom;
import RouteObject.LocationTo;
import RouteObject.Route;

import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RouteBuilder {
    public static Route routeToUpd = null;
    private static boolean isInExecuteScript = false;
    private final Scanner scanner = new Scanner(System.in);

    public Route create(String name, String id) {
        Route route = new Route();
        if (!isInExecuteScript) {
            if(id.equals("free")) {
                route.setId(RouteCollection.getFreeId());
            }
            else{
                route.setId(Integer.parseInt((String) id));
            }
            route.setName(name);
            Coordinates coordinates = new Coordinates();
            this.setCoordinateXForCoordinates(coordinates);
            this.setCoordinateYForCoordinates(coordinates);
            route.setCoordinates(coordinates);
            LocationFrom locationFrom = new LocationFrom();
            this.setName(locationFrom);
            this.setXForLocationFrom(locationFrom);
            this.setYForLocationFrom(locationFrom);
            this.setZForLocationFrom(locationFrom);
            route.setFrom(locationFrom);
            LocationTo locationTo = new LocationTo();
            this.setXForLocationTo(locationTo);
            this.setYForLocationTo(locationTo);
            this.setZForLocationTo(locationTo);
            route.setTo(locationTo);
            this.setDistance(route);
        }
        route.setCreationDate(ZonedDateTime.now());
        return route;

    }


    public void setName(Route route) {

        System.out.println("Введите имя трассы.");

            System.out.print("$ ");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            this.setName(route);
        } else route.setName(name);
    }

    public void setCoordinateXForCoordinates(Coordinates coords) {
        try {
            System.out.println("Введите координату x");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getCoordinates().getX());
            System.out.print("$ ");
            String x = scanner.nextLine();
            long xn = Long.parseLong(x);
            if (x.equals("") || x.equals(null)) {
                if (xn < 33) {
                    coords.setX(0);
                } else {
                    System.out.println("Значение должно быть меньше 33");
                    this.setCoordinateYForCoordinates(coords);
                }
            } else coords.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"int\". Введите значение заново");

            this.setCoordinateXForCoordinates(coords);
        }
    }

    public void setCoordinateYForCoordinates(Coordinates coords) {
        try {
            System.out.println("Введите координату y");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getCoordinates().getY());
            System.out.print("$ ");
            String y = scanner.nextLine();
            Integer yn = Integer.parseInt(y);
            if (y.equals("") || y.equals(null)) {
                System.out.println("Координата должна быть меньше 483");
                this.setCoordinateYForCoordinates(coords);
            } else {
                coords.setY(yn);
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"int\". Введите значение заново.");
            this.setCoordinateYForCoordinates(coords);
        }
    }
    public void setZForLocationFrom(LocationFrom locationFrom) {
        try {
            System.out.println("Введите z для места отправления.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getFrom().getZ());
            System.out.print("$ ");
            String x = scanner.nextLine();
            int xn = Integer.parseInt(x);
            if (x.equals("") || x.equals(null)) {
                this.setZForLocationFrom(locationFrom);
            } else locationFrom.setZ(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            setZForLocationFrom(locationFrom);
        }
    }
    public void setName(LocationFrom locationFrom) {
        System.out.println("Введите название места отправления.");
        if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getFrom().getName());
        System.out.print("$ ");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            this.setName(locationFrom);
        } else locationFrom.setName(name);
    }
    public void setYForLocationFrom(LocationFrom locationFrom) {
        try {
            System.out.println("Введите y для места отправления.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getFrom().getY());
            System.out.print("$ ");
            String x = scanner.nextLine();
            long xn = Long.parseLong(x);
            if (x.equals("") || x.equals(null)) {
                this.setYForLocationFrom(locationFrom);
            } else locationFrom.setY(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            setYForLocationFrom(locationFrom);
        }
    }

    public void setXForLocationFrom(LocationFrom locationFrom) {
        try {
            System.out.println("Введите x для места отправления.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getFrom().getX());
            System.out.print("$ ");
            String x = scanner.nextLine();
            float xn = Float.parseFloat(x);
            if (x.equals("") || x.equals(null)) {
                this.setXForLocationFrom(locationFrom);
            } else locationFrom.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"float\". Введите значение заново");
            setYForLocationFrom(locationFrom);
        }
    }
    public void setXForLocationTo(LocationTo locationTo) {
        try {
            System.out.println("Введите x для места прибытия.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getTo().getX());
            System.out.print("$ ");
            String x = scanner.nextLine();
            int xn = Integer.parseInt(x);
            if (x.equals("") || x.equals(null)) {
                this.setXForLocationTo(locationTo);
            } else locationTo.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"int\". Введите значение заново");
            setXForLocationTo(locationTo);
        }
    }


    public void setYForLocationTo(LocationTo locationTo) {
        try {
            System.out.println("Введите y для места прибытия.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getTo().getY());
            System.out.print("$ ");
            String x = scanner.nextLine();
            float xn = Float.parseFloat(x);
            if (x.equals("") || x.equals(null)) {
                this.setYForLocationTo(locationTo);
            } else locationTo.setY(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"float\". Введите значение заново");
            setYForLocationTo(locationTo);
        }
    }

    public void setZForLocationTo(LocationTo locationTo) {
        try {
            System.out.println("Введите z для места прибытия.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getTo().getZ());
            System.out.print("$ ");
            String x = scanner.nextLine();
            long xn = Long.parseLong(x);
            if (x.equals("") || x.equals(null)) {
                this.setZForLocationTo(locationTo);
            } else locationTo.setZ(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            setZForLocationTo(locationTo);
        }
    }

    public void setDistance(Route route) {
        try {
            System.out.println("Введите протяженность трассы.");
            if (routeToUpd!=null) System.out.println("Текущее значение: "+routeToUpd.getDistance());
            System.out.print("$ ");
            String x = scanner.nextLine();
            long xn = Long.parseLong(x);
            if (x.equals("") || x.equals(null)) {
                this.setDistance(route);
            } else route.setDistance(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            this.setDistance(route);
        }
    }
}