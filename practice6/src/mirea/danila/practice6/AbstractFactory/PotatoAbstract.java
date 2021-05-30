package mirea.danila.practice6.AbstractFactory;

import mirea.danila.practice6.factory_method.Product;

public class PotatoAbstract implements ProductAbstract {

    public final String name;

    public PotatoAbstract() {
        name = "Potato";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void expired() {
        System.out.println("The potato has gone bad");
    }

    @Override
    public void getLost() {
        System.out.println("The potato is Lost");
    }
}
