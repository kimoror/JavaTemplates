package mirea.danila.practice6.AbstractFactory;

import mirea.danila.practice6.factory_method.Potato;
import mirea.danila.practice6.factory_method.Product;

public class PotatoFactory implements AbstractFactory {
    @Override
    public Product factoryMethod() {
        return new Potato();
    }
}
