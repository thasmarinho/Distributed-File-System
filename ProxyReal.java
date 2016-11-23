import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.BigInteger;
import java.util.Scanner;
import java.security.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ProxyReal extends MapaDeReplicacao implements Proxy{
	
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
		int partition = md5(filename);
		//searchPartition(filename, partition); //botar a logica pra decidir qual no
	}	 
	public boolean status()  throws RemoteException {
		return false;
	}
	private List<String> searchPartition(String path, String Pesq) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        List<String> nos = new ArrayList<String>();
        while (true) {
            if (linha != null) {
                if(linha.contains(Pesq+":")){
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
