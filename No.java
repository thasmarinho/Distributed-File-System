import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class No {
	static List<File> paths = new ArrayList();

	public static boolean existFile (String path) {
		File f = new File(path); 
        if (f.exists()) {
            return true;
        } else {
           return false;
        } 
	}

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

	public static void readFile (String fileName) {
		try {
            FileInputStream fStream = new FileInputStream(fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
            while (in.ready()) {
                System.out.println(in.readLine());
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File input error");
        }
	}
}

