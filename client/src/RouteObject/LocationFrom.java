/**
 * Класс координат места отправления
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package RouteObject;

import java.io.Serializable;

public class LocationFrom implements Serializable {
        private float x;
        private Long y; //Поле не может быть null
        private Integer z; //Поле не может быть null
        private String name; //Длина строки не должна быть больше 737, Поле может быть null

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

