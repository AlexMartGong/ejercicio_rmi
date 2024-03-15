package costomer;

import middleware.IMethodsShared;
import middleware.Persons;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        System.out.println("Start client");
        try {

            Scanner sc = new Scanner(System.in);
            Persons persons = new Persons();

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            IMethodsShared objServer = (IMethodsShared) registry.lookup("objServer");
            objServer.diHelloServer();

            System.out.println("------------------------------------------------------------");
            var msgRecibido = objServer.dimeHello();
            System.out.println("The server me dijo: " + msgRecibido);

            System.out.println("------------------------------------------------------------");
            //Envía una cadena para convertirlo en mayúsculas y regresa el valor
            System.out.println("Text: " + objServer.chainUpperCase(sc.nextLine()));

            System.out.println("------------------------------------------------------------");
            //Enviamos la cadena para que lo invierta
            System.out.print("Chain Invert: ");
            var cadena = objServer.invertedChain(sc.nextLine());
            //Imprime la cadena
            for (char s : cadena) {
                System.out.print(s);
            }

            System.out.println("\n------------------------------------------------------------");
            //Salto de linea
            System.out.println();
            //Envía un número para sacar el factorial de este y lo retorna para mostrarlo
            System.out.println("number factorial: " + objServer.Factorial(sc.nextInt()));
            sc.nextLine();
            System.out.println("\n------------------------------------------------------------");

            System.out.println("Name: ");
            persons.setName(sc.nextLine());
            System.out.println("Address: ");
            persons.setAddress(sc.nextLine());
            System.out.println("phone number: ");
            persons.setPhoneNumber(sc.nextLine());

            List<Persons> personsList = objServer.addPerson(persons);
            System.out.println(personsList.size());
            for (Persons p : personsList) {
                System.out.println(p.getName() + ", " + p.getAddress() + ", " + p.getPhoneNumber());
            }

        } catch (Exception e) {
            System.out.println("Error Client");
            e.printStackTrace();
        }
    }

}