package trab3;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Balanceador extends Remote   {

		
	int getProxy() throws RemoteException, NotBoundException;
}
