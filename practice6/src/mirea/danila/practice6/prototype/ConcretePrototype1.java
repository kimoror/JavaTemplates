package mirea.danila.practice6.prototype;

public class ConcretePrototype1 implements Prototype {
    public int id;
    public String name;

    public ConcretePrototype1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
