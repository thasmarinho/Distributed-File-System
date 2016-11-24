package trab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.security.*;
import java.math.BigInteger;

public class ProxysReal implements Proxy {

	 static No stubNo1;
	 static No stubNo2;
	 static No stubNo3;
	 static No stubNo4;
	 static No stubNo5;
	 static No stubNo6;
	 
	public static void main(String[] args) throws NotBoundException, IOException {
	
		System.out.println("Proxy Port: ");
    	Scanner sc1 = new Scanner(System.in); 
    	int PortOfProxy = sc1.nextInt();
		
     	System.out.println(" Connecting Proxy: ");
        try {
            
           
            
        	Proxys obj = new Proxys();
        	Proxy stubProxy = (Proxy) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(PortOfProxy);
            registry.bind("Hello", stubProxy);
            System.out.println(" Port:"+PortOfProxy);
            System.out.println(" Proxy OK.");
            
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
     
		

        
        
        int no1 = 2001,no2 = no1 +1,no3 = no1 +2,no4 = no1 +3,no5 = no1 +4,no6 = no1 +5;
        
        
        
        Registry registry1 = LocateRegistry.getRegistry(no1);
        stubNo1 = (No) registry1.lookup("Hello");     
        System.out.println(" Connected with node 1");
        System.out.println(" At Port: "+no1);

        Registry registry2 = LocateRegistry.getRegistry(no2);
        stubNo2 = (No) registry2.lookup("Hello");     
        System.out.println(" Connected with node 2");
        System.out.println(" At Port: "+no2);
        
        Registry registry3 = LocateRegistry.getRegistry(no3);
        stubNo3 = (No) registry3.lookup("Hello");     
        System.out.println(" Connected with node 3");
        System.out.println(" At Port: "+no3);
        
        Registry registry4 = LocateRegistry.getRegistry(no4);
        stubNo4 = (No) registry4.lookup("Hello");     
        System.out.println(" Connected with node 4");
        System.out.println(" At Port: "+no4);
        
        Registry registry5 = LocateRegistry.getRegistry(no5);
        stubNo5 = (No) registry5.lookup("Hello");     
        System.out.println(" Connected with node 5");
        System.out.println(" At Port: "+no5);
        
        Registry registry6 = LocateRegistry.getRegistry(no6);
        stubNo6 = (No) registry6.lookup("Hello");     
        System.out.println(" Connected with node 6");
        System.out.println(" At Port: "+no6);
        


        

        
        Registry registry7 = LocateRegistry.getRegistry(1010);
        Balanceador stubBalancer = (Balanceador) registry7.lookup("Hello");     
        System.out.println("Connected with Balancer");
        System.out.println(" At Port:"+1010);

        
        

	}

	@Override
	public boolean createFile(String filename) throws IOException {
		 int partition = hashing(filename);
		 String s=null, aux[];
		 boolean result = false;
		 InputStream is = new FileInputStream("MAP.txt");
	     InputStreamReader isr = new InputStreamReader(is);
	     BufferedReader br = new BufferedReader(isr);
		 for(int i=0; i<= partition ; i++ ){
			 s = br.readLine();
		 }
		 aux = s.split(";");
		 for(int i=0;i<aux.length;i++){
			switch (Integer.parseInt(aux[i])) {
			case 1:
				result = stubNo1.createFile(filename);
				break;
			case 2:
				result = stubNo2.createFile(filename);
				break;
			case 3:
				result = stubNo3.createFile(filename);
				break;
			case 4:
				result = stubNo4.createFile(filename);
				break;
			case 5:
				result = stubNo5.createFile(filename);
				break;
			case 6:
				result = stubNo6.createFile(filename);
				break;
			default:
				break;
			}
		 }
		return result;
	}

	@Override
	public String readFile(String filename) throws IOException {
		int partition = hashing(filename);
		 String s=null, aux[], result = null;
		 boolean FlagFind = false;
		 InputStream is = new FileInputStream("MAP.txt");
	     InputStreamReader isr = new InputStreamReader(is);
	     BufferedReader br = new BufferedReader(isr);
		 for(int i=0; i<= partition ; i++ ){
			 s = br.readLine();
		 }
		 aux = s.split(";");
		 for(int i=0;i<aux.length;i++){
			 try{				switch (Integer.parseInt(aux[i])) {
				case 1:
					if((result = stubNo1.readFile(filename)) != null){
						FlagFind =true;
					 };
					break;
				case 2:
					if((result = stubNo2.readFile(filename)) != null){
						FlagFind =true;
					 };
					break;
				case 3:
					if((result = stubNo3.readFile(filename)) != null){
						FlagFind =true;
					 };
					break;
				case 4:
					if((result = stubNo4.readFile(filename)) != null){
						FlagFind =true;
					 };
					break;
				case 5:
					if((result = stubNo5.readFile(filename)) != null){
						FlagFind =true;
					 };
					break;
				case 6:
					if((result = stubNo6.readFile(filename)) != null){
						FlagFind =true;
					 };
					break;
				default:
					break;
				}
				if(FlagFind)
					break;}
			 catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }

		}
		return result;
	}

	
	public int hashing(String senha){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		float se = hash.floatValue();
		float sr=se%3;
		int t=(int)sr;
		return t;
	}

	@Override
	public boolean status() throws RemoteException {

		return true;
	}
	
	
	
	
	
	
	
}
