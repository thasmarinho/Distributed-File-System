package trab3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws NotBoundException, FileNotFoundException, IOException {

		Registry registry = LocateRegistry.getRegistry(1010);
		Balanceador stub = (Balanceador) registry.lookup("Hello");     
        System.out.println(" Conection Balancer \n ");
        System.out.println(" Server:"+1010+"\n");
        
        
		int PortOfProxy = stub.getProxy();
		
		
		Registry registry2 = LocateRegistry.getRegistry(PortOfProxy);
		Proxy stub2 = (Proxy) registry2.lookup("Hello");     
        System.out.println(" conection Proxy\n ");
        System.out.println(" Server:"+PortOfProxy+"\n");
        
        
while(true){
			System.out.println("Qual operacao deseja executar: criar [c] , ler [l]");
		Scanner sc1 = new Scanner(System.in); 
    	String ans = sc1.next();
    	
    	
    	if(ans.equals("l")){
    		System.out.println("name of the file:");
    		String filename = sc1.next();
    		System.out.println("\nArquivo:" + stub2.readFile(filename));
    	}
    	else if(ans.equals("c")){
    		System.out.println("name of the file:");
    		String filename = sc1.next();
    		 if( stub2.createFile(filename)){
 		        System.out.println("created");
 		     }
    		 else{
 		        System.out.println("already exist");
 		    }
    	}
    	else{
    		
    	}
}
	}

}
