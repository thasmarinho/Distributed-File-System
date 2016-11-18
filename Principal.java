import java.io.IOException;
 
public class Principal {
 
    public static void main(String args[]) throws IOException {
        String path = "C:/Users/Thais/Documents/GitHub/ExclusaoMutua/ExclusaoMutua/src/Mapa.txt";
 
        //MapaDeReplicacao.write(path);
        MapaDeReplicacao.read(path);
    }
 
}