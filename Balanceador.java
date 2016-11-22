import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;


        
public class Balanceador implements RecursoComp {


    public Server() {}

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
            Server obj = new Server();
            RecursoComp stub = (RecursoComp) UnicastRemoteObject.exportObject(obj, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RecursoComp", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
