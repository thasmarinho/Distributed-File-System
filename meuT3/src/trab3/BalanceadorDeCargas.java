package trab3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class BalanceadorDeCargas implements Balanceador{
	
	static ArrayList <Integer> ListOfProxys;
	
	public static void main(String[] args){
		
		ListOfProxys = new ArrayList<Integer>();
		ListOfProxys.add(1001);
		ListOfProxys.add(1002);
		ListOfProxys.add(1003);
		System.out.println("Balanacer Starting");
    	int PortOfBalancer = 1010;
    	
    	System.out.println(" executing Balancer \n");
        try {
            
           
        	BalanceadorDeCargas obj = new BalanceadorDeCargas();
        	Balanceador stub = (Balanceador) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(PortOfBalancer);
            registry.bind("Hello", stub);
            System.out.println(" Port:"+PortOfBalancer);
            System.out.println(" Balancer Working");
            
        } catch (Exception e) {
            System.out.println("Server error " + e.getMessage());
        }
		
	}



	@Override
	public int getProxy() throws RemoteException, NotBoundException {
		
		int max = ListOfProxys.size();
		boolean check=false;
		
		for(int i=0;i<=max;i++){
			try{Registry registry = LocateRegistry.getRegistry(ListOfProxys.get(i));
	        Proxy stub2 = (Proxy) registry.lookup("Hello");     
	        System.out.println("Conection Sucesfull with Proxy Server");
	        System.out.println(" Server:"+ListOfProxys.get(i)+"\n");
	        check = stub2.status();
			if(check){
				return ListOfProxys.get(i);
			}
			}
			catch (Exception e) {
            System.out.println("Server error " + e.getMessage());
			}
			
		}
		return 0;
	}
	
	
	
}
