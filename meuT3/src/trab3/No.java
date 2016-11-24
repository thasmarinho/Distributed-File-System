package trab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface No extends Remote   {
	
	 boolean createFile( String filename) throws RemoteException;
	 
	 String readFile (String filename)throws RemoteException, FileNotFoundException ;
	 
	 
	
	
	
	

}
