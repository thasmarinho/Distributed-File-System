import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;

public class Cliente{

    private Cliente() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        int porta = 1099;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Registry registry = LocateRegistry.getRegistry(host, porta); //host, porta
            Balanceador stub = (Balanceador) registry.lookup("Balanceador");

      
          

            porta = stub.getProxy();

            Registry registry2 = LocateRegistry.getRegistry(host, porta);
            Proxy stub2 = (Proxy) registry2.lookup("Proxy");     

            System.out.println("entre a operacao que deseja ser feita: Criar[C] ou Ler[L] um arquivo");
            while(true) {
                String key = br.readLine();
                try {
                    String response = stub2.operation(key); //bastaria fazer a operacao o restante o proxy se vira
                    System.out.print(response);
                } catch (Exception e) {
                System.err. println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
        } catch (Exception e) {
            System.err. println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
