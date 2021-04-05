package mirea.danila.practice6.builder;

public class Director {
    Builder builder;
    City city = new City();

    public Director(Builder builder) {
        this.builder = builder;
        builder.setCity(city);
    }

    public void Construct() {
        builder.buildHouse();
    }

    public int getWorkResult() {
        return builder.getResult().getSizeOfCity();
    }
}
