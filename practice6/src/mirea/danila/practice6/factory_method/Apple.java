package mirea.danila.practice6.factory_method;

public class Apple implements Product {
    private final String name;

    public Apple() {
        name = "Apple";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void expired() {
        System.out.println("The apple has gone bad");
    }

    @Override
    public void getLost() {
        System.out.println("The potato is Lost");
    }
}
