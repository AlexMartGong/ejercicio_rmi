package middleware;

import java.rmi.*;
import java.util.List;

public interface IMethodsShared extends Remote {

    void diHelloServer() throws RemoteException;

    String dimeHello() throws RemoteException;

    List<Persons> addPerson(Persons persons) throws RemoteException;

    List<Persons> getPersons() throws RemoteException;



    int Factorial(int factorial) throws RemoteException;

    char[] invertedChain(String chain)throws RemoteException;

    String chainUpperCase(String chain)throws RemoteException;
}