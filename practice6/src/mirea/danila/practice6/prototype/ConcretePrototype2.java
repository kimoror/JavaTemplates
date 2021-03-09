package mirea.danila.practice6.prototype;

public class ConcretePrototype2 implements Prototype{
    public int id;
    public String name;

    public ConcretePrototype2(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
