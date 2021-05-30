package practice7.adapter;

public class Adapter extends Target {
    Adaptee adaptee;

    public Adapter() {
        adaptee = new Adaptee();
    }

    @Override
    public void Request() {
        adaptee.SpecifyReuest();
    }
}
