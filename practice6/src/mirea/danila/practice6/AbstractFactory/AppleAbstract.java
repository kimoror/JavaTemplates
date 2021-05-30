package mirea.danila.practice6.AbstractFactory;

import mirea.danila.practice6.factory_method.Product;

public class AppleAbstract implements ProductAbstract {
    private final String name;

    public AppleAbstract() {
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
