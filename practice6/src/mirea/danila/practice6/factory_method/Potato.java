package mirea.danila.practice6.factory_method;

public class Potato implements Product{

    public final String name;

    public Potato(){
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
