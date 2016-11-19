import java.io.IOException;

public class Principal {
 
    public static void main(String args[]) throws IOException {
        String path = "C:\\Users\\Bruno Augusto\\Desktop\\testeTXT\\mapa.txt";
        String MD5Result;
        String Partition;
        //Proxy.write(path);
        MD5Result=Proxy.md5("foto.png");
        System.out.println(MD5Result);
        Proxy.read(path);
        Partition=Proxy.Search(path,MD5Result);
    }
 
}
