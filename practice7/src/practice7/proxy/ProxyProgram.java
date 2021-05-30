package practice7.proxy;

public class ProxyProgram {
    IHuman BruceWillis = new BruceWillis();
    IHuman Surrogate = new Surrogate(BruceWillis);

    public void run() {
        Surrogate.Request();
    }
}
