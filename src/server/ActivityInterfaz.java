package server;

import middleware.IMethodsShared;
import middleware.Persons;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ActivityInterfaz extends UnicastRemoteObject implements IMethodsShared {

    public ActivityInterfaz() throws RemoteException {
    }

    @Override
    public void diHelloServer() {
        System.out.println("Hello server");
    }

    @Override
    public String dimeHello() {
        return "HELLO WORLD";
    }

    @Override
    public List<Persons> addPerson(Persons persons) throws RemoteException {
        Provicional.personsList.add(persons);
        return Provicional.personsList;
    }

    @Override
    public List<Persons> getPersons() throws RemoteException {
        return null;
    }

    @Override
    public int Factorial(int factorial) {
        int count = 1;

        if (factorial > 1){
            for (int i = 1; i <= factorial; i++) {
                count *= i;
            }
        }
        return count;
    }

    @Override
    public char[] invertedChain(String chain) throws RemoteException {
        char[] chainNormal = chain.toCharArray();
        char[] chainInvert = new char[chain.length()];
        int j = chainNormal.length - 1;

        for (char ci: chainNormal){
            chainInvert[j--] = ci;
        }

        return chainInvert;
    }

    @Override
    public String chainUpperCase(String chain) throws RemoteException {
        return chain.toUpperCase();
    }

}
