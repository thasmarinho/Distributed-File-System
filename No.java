import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface No extends Remote {
	
	public boolean createFile( String filename) throws RemoteException;
	public String readFile (String filename)throws RemoteException, FileNotFoundException ;

}
