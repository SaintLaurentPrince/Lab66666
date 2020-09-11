/**
 * Класс Route, выполняющий функцию хранения имени, координат обеих локаций и дистанцию, даты инициализации Vector
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */


package RouteObject;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Route implements Comparable, Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private LocationFrom from; //Поле может быть null
    private LocationTo to; //Поле может быть null
    private Long distance; //Поле может быть null, Значение поля должно быть больше 1

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocationFrom getFrom() {
        return from;
    }

    public void setFrom(LocationFrom from) {
        this.from = from;
    }

    public LocationTo getTo() {
        return to;
    }

    public void setTo(LocationTo to) {
        this.to = to;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }


    public String getCSV(){
        return id + "," + name + "," + coordinates.getX()+ "," + coordinates.getY()+ "," +creationDate+ "," +from.getName() + "," +
                from.getX() + "," + from.getY() + "," +  from.getZ() + "," + to.getX() + "," + to.getY() + "," + to.getZ() + "," +
                distance;
    }
    public String getInfo() {
        return "Route (id:"+ id +"):\n\t" + "Name: " + name + "\n\tCoordinates:\n\t\t x: " + coordinates.getX() + "\n\t\t y: "
                + coordinates.getY() +"\n\tCreation date: " + creationDate + "\n\tМесто отправления:\n\t\tНазвание: " +
                from.getName() + "\n\t\tx: " + from.getX() +  "\n\t\ty: " + from.getY() + "\n\t\tz: " + from.getZ() +
                "\n\tМесто прибытия: "+ "\n\t\tx: " + to.getX() +  "\n\t\ty: " + to.getY() + "\n\t\tz: " + to.getZ() +
                "\n\tДистанция: " + distance;
    }

    @Override
    public int compareTo(Object o) {
        Route route = (Route) o;
        return this.getCSV().length() - route.getCSV().length();
    }
}