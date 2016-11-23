import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
 
public class ProxyReal extends MapaDeReplicacao implements Proxy{

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

}
