import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class NoDeArmazenamento implements No {
	static List<File> paths = new ArrayList();
	static String Path;
	static File Dir;

	public static List<File> listFile (String path) {

		try {
			File f = new File(path);
			paths.addAll(Arrays.asList(f.listFiles()));

	//	for(File p:paths)
      //   {
        //    System.out.println(p);
         //}
			return paths;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return paths;
	}

	public boolean createFile( String filename) throws RemoteException {
		File f = new File(Dir,filename);
		//ponto de falha, IEException , boolean return false
		try{
		    if(f.createNewFile()){
		        System.out.println("Arquivo criado!");
		        return true;
		    } 
		    else {
		        System.out.println("O arquivo nao foi criado, talvez ele ja exista");
		        return false;
		    }
		}catch(Exception e){
		    e.printStackTrace();
		}
		return false;
	}

	public String readFile (String filename)throws RemoteException, FileNotFoundException {
		File f = new File(Dir,filename);

		if (f.exists() == false){
			return("Arquivo não encontrado!");
		}
		else{
			FileInputStream fStream = new FileInputStream(filename);
	        BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
	        String texto = "";
	        try {
		        while (br.ready()) {
		       		for (String str = br.readLine(); str != null; str = br.readLine()) {
				    	texto = texto + "\n" + str;
			    	}
	            	System.out.println(br.readLine());
		        }
	            br.close();
	        }catch (Exception e) {
            	e.printStackTrace();
        	}
        	return texto;
        } 
	}

	public static void main(String[] args) throws IOException {

	}
}

