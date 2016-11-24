package trab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProxyImplement extends Remote   {
	
	 boolean createFile( String filename) throws RemoteException, FileNotFoundException, IOException;
	 
	 String readFile (String filename)throws RemoteException, FileNotFoundException, IOException ;
	 
	 boolean status()  throws RemoteException;


}
