package practice7.adapter;

public class AdapterClient {
    public void run() {
        Target target = new Adapter();
        target.Request();
    }
}
