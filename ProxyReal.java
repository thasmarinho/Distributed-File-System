import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.math.BigInteger;
import java.util.Scanner;
import java.security.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ProxyReal implements Proxy{

	static No stub1;
	static No stub2;
	static No stub3;
	static No stub4;
	static No stub5;
	static No stub6;
	
	public static String md5(String senha){
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
		String s =Integer.toString(t);
		return s;
	}
	public boolean createFile(String filename) throws RemoteException, FileNotFoundException, IOException {
		return false;
	}
	public String readFile(String filename) throws RemoteException, FileNotFoundException, IOException {
		boolean achou = false;
		String partition = md5(filename), result = null;
		List<String> nos = new ArrayList<String>(searchPartition(partition)); //botar a logica pra decidir qual no
		
		for(int i=0;i<nos.size();i++){
				switch (Integer.parseInt(nos.get(i))) {
				case 1:
					if((result = stub1.readFile(filename)) != null){
						achou =true;
					 };
					break;
				case 2:
					if((result = stub2.readFile(filename)) != null){
						achou =true;
					 };
					break;
				case 3:
					if((result = stub3.readFile(filename)) != null){
						achou =true;
					 };
					break;
				case 4:
					if((result = stub4.readFile(filename)) != null){
						achou =true;
					 };
					break;
				case 5:
					if((result = stub5.readFile(filename)) != null){
						achou =true;
					 };
					break;
				case 6:
					if((result = stub6.readFile(filename)) != null){
						achou =true;
					 };
					break;
				default:
					break;
				}
				if(achou)
					break;
		}
		return "";
	}	 
	public boolean status()  throws RemoteException, IOException {
		// a ideia é fazer tentar fazer uma simples conexão tcp
		/*try (Socket s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT)) {
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return false;
	}
	private List<String> searchPartition(String key) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("MAP.txt"));
        String linha = "";
        List<String> nos = new ArrayList<String>();
        while (true) {
            if (linha != null) {
                if(linha.contains(key+":")){
                    String str = linha.substring(linha.indexOf(":") + 1);
                    nos.addAll(Arrays.asList(str.split("\\s*;\\s*")));
                	return nos;
                }

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
        return nos;
    }

    public static void main(String[] args) throws NotBoundException, IOException {
	
		System.out.println(" Porta: ");
    	Scanner sc1 = new Scanner(System.in); 
    	int PRT = sc1.nextInt();
		
     	System.out.println(" Tentando arrancar PROXY \n");
        try {
            
           
            //Registry registry = LocateRegistry.getRegistry();
        	ProxyReal obj = new ProxyReal();
        	Proxy stub = (Proxy) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(PRT);
            //Registry registry = LocateRegistry.getRegistry(host, 1099); //host, porta //uma porta por processo
            registry.bind("Hello", stub); //trocar esses Hello pelos nomes dos serviços disponibilizados. Nomes diferentes pra cada um, pf!!!!
            System.out.println(" Porta:"+PRT);
            System.out.println(" Proxy Funcionando.");
            
        } catch (Exception e) {
            System.out.println(" PROBLEMAS NO ARRANQUE \n Server erro " + e.getMessage());
        }
     
		
        
       // ---------------------------------------------------------------------------------------
        
        
        int no1 = 4001,no2 = no1 +1,no3 = no1 +2,no4 = no1 +3,no5 = no1 +4,no6 = no1 +5;
        
        //ponto de falha
        
        
        Registry registry1 = LocateRegistry.getRegistry(no1);
        stub1 = (No) registry1.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+no1+"\n");
        
        
       /* Proxys proxy = new Proxys();
        if (proxy.createFile("teste3.txt"))
    	{
    		System.out.println(" criou show \n");
    	}
    	else
    	{System.out.println(" baboushow \n");}
        
        */
        
        //Proxys proxy = new Proxys();
        //System.out.println("Arquivo: " + proxy.readFile("teste.txt"));
        
       
        Registry registry2 = LocateRegistry.getRegistry(no2);
        stub2 = (No) registry2.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+no2+"\n");
        
        Registry registry3 = LocateRegistry.getRegistry(no3);
        stub3 = (No) registry3.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+no3+"\n");
        
        Registry registry4 = LocateRegistry.getRegistry(no4);
        stub4 = (No) registry4.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+no4+"\n");
        
        Registry registry5 = LocateRegistry.getRegistry(no5);
        stub5 = (No) registry5.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+no5+"\n");
        
        Registry registry6 = LocateRegistry.getRegistry(no6);
        stub6 = (No) registry6.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+no6+"\n");
        
        
        
      //---------------------------------------------------------------------------------------------------
        
   //+1 balanceador de carga^
        
        //Conexao com o Balanceador
        
        Registry registry7 = LocateRegistry.getRegistry(4000);
        Balanceador stub7 = (Balanceador) registry7.lookup("Hello");     
     //   System.out.println("response: " + response);
        System.out.println(" BEM VINDO -- CONEXAO ESTABELECIDA \n ");
        System.out.println(" Server:"+4000+"\n");
        
        stub7.connectBalancer(PRT);
        
        

	}

}
