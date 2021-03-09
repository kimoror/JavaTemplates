package mirea.danila.practice6.AbstractFactory;

import mirea.danila.practice6.factory_method.Apple;
import mirea.danila.practice6.factory_method.Product;

public class AppleFactory implements AbstractFactory {

    @Override
    public Product factoryMethod() {
        return new Apple();
    }
}
