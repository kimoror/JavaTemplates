package mirea.danila.practice6;

import mirea.danila.practice6.AbstractFactory.AbstractFactory;
import mirea.danila.practice6.AbstractFactory.AppleFactory;
import mirea.danila.practice6.AbstractFactory.PotatoFactory;
import mirea.danila.practice6.builder.Builder;
import mirea.danila.practice6.builder.ConcreteBuilder;
import mirea.danila.practice6.builder.Director;
import mirea.danila.practice6.factory_method.AppleTree;
import mirea.danila.practice6.factory_method.PotatoCreator;
import mirea.danila.practice6.factory_method.Product;
import mirea.danila.practice6.prototype.ConcretePrototype1;
import mirea.danila.practice6.prototype.Prototype;

public class Main {
    public static void main(String[] args) {

        System.out.println("Pattern factory method:");
        PotatoCreator creator = new PotatoCreator();
        AppleTree appleTree = new AppleTree();
        Product potato = creator.factoryMethod();
        Product apple = appleTree.factoryMethod();
        System.out.println(potato.getName());
        System.out.println(apple.getName());

        System.out.println("\nPattern Abstract factory:");
        AbstractFactory factory = new AppleFactory();
        Product productAbstractFactory = factory.factoryMethod();
        System.out.println(productAbstractFactory.getName());
        factory = new PotatoFactory();
        productAbstractFactory = factory.factoryMethod();
        System.out.println(productAbstractFactory.getName());

        System.out.println("\nPattern Builder:");
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.Construct();
        director.Construct();
        System.out.println("Size of city: " + director.getWorkResult());

        System.out.println("\nPattern Prototype:");
        Prototype prototype1 = new ConcretePrototype1(1, "ConcreteProt1");
        Prototype prototype2 = prototype1.clone();
        System.out.println("Prototype1. id: " + prototype1.getId() + ", name: " + prototype1.getName());
        System.out.println("Prototype2. id: " + prototype2.getId() + ", name: " + prototype2.getName());
    }
}
