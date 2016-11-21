import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Principal {
 
    public static void main(String args[]) throws IOException {
      //  String path = "C:\\Users\\Bruno Augusto\\Desktop\\testeTXT\\mapa.txt";
        String path = "C:\\Users\\Thais\\Documents\\GitHub\\Distributed-File-System\\mapa.txt";
        String MD5Result;
        List<String> Partition = new ArrayList<String>();
        MD5Result=Proxy.md5("foto.png");
        Proxy.read(path);
        System.out.println(MD5Result);
        Partition.addAll(Proxy.Search(path,MD5Result));
        No.listFile("C:\\Users\\Thais\\Documents\\GitHub\\Distributed-File-System");  
       // Proxy.read(path);

    }
 
}
