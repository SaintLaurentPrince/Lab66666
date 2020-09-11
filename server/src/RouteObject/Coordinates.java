/**
 * Класс координат для хранения и обработки координат объектов
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package RouteObject;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private long x; //Максимальное значение поля: 33
    private Integer y; //Поле не может быть null

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
