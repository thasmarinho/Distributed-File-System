import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Proxy extends Remote {
	public String operation(String key) throws RemoteException;
}