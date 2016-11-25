package trab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class NoArmazenamento implements No {

	static String Path;
	static File Folder;
	
	public static void main(String[] args) throws IOException {

	

	    	System.out.println("Port of Storage Node: ");
	    	Scanner sc1 = new Scanner(System.in); 
	    	int PortOfStorage = sc1.nextInt();
	    	Path ="no"+(PortOfStorage-2000);
	    	
	    	Folder = new File(Path);

	    	
	    	
	    	System.out.println("turning on Storage Node : "+Path);
	        try {
	        	NoArmazenamento obj = new NoArmazenamento();
	        	No stub = (No) UnicastRemoteObject.exportObject(obj, 0);
	            Registry registry = LocateRegistry.createRegistry(PortOfStorage);
	            registry.bind("Hello", stub);
	            System.out.println("Port:"+PortOfStorage);
	            System.out.println("Working");
	            
	        } catch (Exception e) {
	            System.out.println("Server error: " + e.getMessage());
	        }
	     
	     
	     
	     
	}
	
	
	public boolean createFile (String filename) throws RemoteException {
		File F = new File(Folder,filename);
		try{
		    if( F.createNewFile() ){
		        System.out.println("File "+filename+" Sucessfuly Created");
		        return true;
		    }else{
		        System.out.println("Error: Chosen Name already in use");
		        return false;
		    }
		}catch(IOException ex){
		    ex.printStackTrace();
		}
		return false;
		
	}
	
	public String readFile (String filename)throws RemoteException, FileNotFoundException
	{
		 File F = new File(Folder,filename);
		 if( ! F.exists() ){
			    return("The File "+filename+" does not exist");
		 }
		 
		 else{
			 InputStream is = new FileInputStream(Path + "/" + filename);
		     InputStreamReader isr = new InputStreamReader(is);
		     BufferedReader br = new BufferedReader(isr);
		 
		     String strg = null, strg2 = "" ;
			 try {
				strg = br.readLine();
				 while (strg != null) {
				      strg2 = strg2 +"\n" +strg;
				       strg = br.readLine();
				     }
			 } catch (IOException e) {

				e.printStackTrace();
			 }
		     
		     try {
				br.close();
			 } catch (IOException e) {

				e.printStackTrace();
			 }

			 return strg2;
		 }
		 	
	}
	
	

}
