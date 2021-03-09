package mirea.danila.practice6.builder;

public class ConcreteBuilder implements Builder {
    City city;

    public ConcreteBuilder(){
        city = new City();
    }

    public void setCity(City city){
        this.city = city;
    }

    public ConcreteBuilder(City city){
        this.city = city;
    }

    @Override
    public void buildHouse() {
        city.add(new House());
    }

    public City getResult(){
        return city;
    }
}
