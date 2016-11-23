import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Balanceador extends Remote   {
    public void connectBalancer(int Porta) throws RemoteException;    
    public int getProxy() throws RemoteException, NotBoundException;
}
