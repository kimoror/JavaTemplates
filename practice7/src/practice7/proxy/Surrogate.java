package practice7.proxy;

public class Surrogate implements IHuman {
    IHuman human;

    public Surrogate(IHuman human) {
        this.human = human;
    }

    @Override
    public void Request() {
        human.Request();
    }
}
