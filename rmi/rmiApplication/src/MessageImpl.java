/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements Message {

    public MessageImpl() throws RemoteException {
    }

    @Override
    public void sayHello(String name) throws RemoteException {
        System.out.println("hello " + name);
    }

}
