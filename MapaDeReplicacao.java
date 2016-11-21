import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapaDeReplicacao {
	
	public static void read(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
 
    public static void write(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }
    public static List<String> Search(String path, String Pesq) throws IOException {
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
