import java.io.File;

public class No {

	public void verifyFileExists (String filename) {
		File f = new File(filename); 
        if (f.exists()) {
            System.out.println("O arquivo existe");
        } else {
            System.out.println("O arquivo nao existe");
        } 
	}
}