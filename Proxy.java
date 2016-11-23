import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Proxy extends Remote {
	
	public boolean createFile( String filename) throws RemoteException, FileNotFoundException, IOException;
	public String readFile (String filename) throws RemoteException, FileNotFoundException, IOException;
	public String searchPartition (String path, String key) throws RemoteException, FileNotFoundException, IOException;	 
	public boolean status() throws RemoteException;


}