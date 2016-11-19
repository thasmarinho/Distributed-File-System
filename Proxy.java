import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.security.*;
 
public class Proxy extends MapaDeReplicacao{
	
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

}
