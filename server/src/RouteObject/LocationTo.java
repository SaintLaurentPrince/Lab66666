/**
 * Класс координат места прибытия
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package RouteObject;

import java.io.Serializable;

public class LocationTo implements Serializable {
    private int x;
    private Float y; //Поле не может быть null
    private Long z; //Поле не может быть null

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Long getZ() {
        return z;
    }

    public void setZ(Long z) {
        this.z = z;
    }
}
