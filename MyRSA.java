import java.util.ArrayList; 

/**
    Please note that no exceptions should be thrown, rather a null must be returned on error.
**/

public class MyRSA {

    public static String encrypt(int p, int q, int privateKey, String message) {
        ArrayList<Integer> asciiCodes = convertToAscii(message);
        String encrypted = "";
        PublicKey key = PublicKey.create(p, q, privateKey);
        
        int mod = key.n;
        int euc = key.a;
        
        int e = key.e1;
        int d = key.e2;
        
        for(int encryptInt : asciiCodes) {
            int m = Euclidean.mod(encryptInt, e, mod);
            int c = Euclidean.mod(m, d, mod);
            
            encrypted += Integer.toString(m) + " ";
        }
        
        return encrypted;
    }
    
    public static String decrypt(int privateKey, String encryptedString, int p, int q) {
        PublicKey key = PublicKey.create(p, q, privateKey);
        
        int mod = key.n;
        int euc = key.a;
        
        String split[] = encryptedString.split(" ");
        String decrypted = "";
        
        for(String encAscii : split) {
            int encCode = Integer.parseInt(encAscii);
            int c = Euclidean.mod(encCode, privateKey, mod);
            decrypted += Character.toString((char) c);
        }
        return decrypted;
    }
    
    public static ArrayList<Integer> convertToAscii(String message) {
        ArrayList<Integer> codes = new ArrayList();
        for(int i = 0; i < message.length(); i++) {
            int code = (int) message.charAt(i);
            codes.add(code);
        }
        return codes;
    }
}
