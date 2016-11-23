import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;


        
public class BalanceadorDeCargas implements Balanceador {


    public BalanceadorDeCargas() {}

    public void connectBalancer(int Porta) throws RemoteException {
    }    
    public int getProxy() throws RemoteException, NotBoundException {
        return 0;
    }
	public String operation(String key, String id) throws RemoteException {
		
		String response = "";
		if (key.equals("1")) {
			try {
	       		//chama funcao de criar arquivo do stub do proxy
            //altera response com resultado possitivo ou negativo da criacao
	    	} catch (Exception e) {
	    		System.err.println("Server exception: " + e.toString());
            	e.printStackTrace();
	    	}
		}
		if (key.equals("2")){ 
			//chama funcao de ler arquivo do stub do proxy
      //altera response com resultado possitivo ou negativo da leitura
      } 
		
		return response;
	}
	     
    public static void main(String args[]) {
        
        try {
            BalanceadorDeCargas obj = new BalanceadorDeCargas();
            Balanceador stub = (Balanceador) UnicastRemoteObject.exportObject(obj, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Balanceador", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
