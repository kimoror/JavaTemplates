package mirea.danila.practice6.factory_method;

public class AppleTree extends PotatoCreator {
    @Override
    public Product factoryMethod() {
        return new Apple();
    }
}
