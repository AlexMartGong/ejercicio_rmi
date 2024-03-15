package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {

        System.out.println("Start");

        try {
            var objectActivity = new ActivityInterfaz();
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("objServer", objectActivity);
            System.out.println("object publicado");

        } catch (Exception e) {
            System.out.println("Error server ");
            e.printStackTrace();
        }

    }
}