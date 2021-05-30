package practice7;

import practice7.adapter.AdapterClient;
import practice7.proxy.ProxyProgram;

//Вариант 7
public class Main {
    public static void main(String[] args) {

        System.out.println("Adapter pattern:");
        AdapterClient adapterClient = new AdapterClient();
        adapterClient.run();

        System.out.println("\nProxy pattern:");
        ProxyProgram proxyProgram = new ProxyProgram();
        proxyProgram.run();
    }
}
