package mirea.danila.practice6.builder;

import java.util.ArrayList;

public class City {

    protected ArrayList<Object> city = new ArrayList<>();

    public void add(Object house) {
        city.add(house);
    }

    public int getSizeOfCity() {
        return city.size();
    }
}
