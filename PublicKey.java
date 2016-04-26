 

public class PublicKey {
    public int e1;
    public int e2;
    
    public int a;
    public int n;

    public static PublicKey create(int p, int q, int k) {
        PublicKey key = new PublicKey();
        
        int x = (p - 1) * (q - 1); //phi
        int y = Euclidean.extendedAlgorithm(k, x);
        
        key.e1 = Euclidean.m;
        key.e2 = Euclidean.n;
        
        key.a = y;
        key.n = p * q;
        
        return key;
    }
}
