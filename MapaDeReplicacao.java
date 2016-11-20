import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

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
    public static String Search(String path, String Pesq) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                if(linha.contains(Pesq+":")){
                	//System.out.println(linha);
                	return linha;
                }

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
        return "";
    }
    
}
