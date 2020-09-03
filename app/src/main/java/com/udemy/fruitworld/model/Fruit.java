package com.udemy.fruitworld.model;

import com.udemy.fruitworld.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fruit implements Serializable {

    private String name;
    private String origin;
    private int icon;
    private String message;

    public Fruit(String name, String origin, int icon, String message) {
        this.name = name;
        this.origin = origin;
        this.icon = icon;
        this.message = message;
    }

    public static List<Fruit> buildFruitList() {
        return new ArrayList<Fruit>() {{
            add(new Fruit("Banana", "Gran Canaria", R.drawable.ic_banana, "The best fruit from Gran Canaria is Banana"));
            add(new Fruit("Strawberry", "Huelva", R.drawable.ic_strawberry, "The best fruit from Huelva is Strawberry"));
            add(new Fruit("Orange", "Sevilla", R.drawable.ic_orange, "The best fruit from Sevilla is Orange"));
            add(new Fruit("Apple", "Madrid", R.drawable.ic_apple, "The best fruit from Madrid is Apple"));
            add(new Fruit("Cherry", "Galicia", R.drawable.ic_cherries, "The best fruit from Galicia is Cherry"));
            add(new Fruit("Pear", "Zaragoza", R.drawable.ic_pear, "The best fruit from Zaragoza is Pear"));
            add(new Fruit("Raspberry", "Barcelona", R.drawable.ic_raspberry, "The best fruit from Barcelona is Raspberry"));
        }};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
