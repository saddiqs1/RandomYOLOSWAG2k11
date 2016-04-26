
public class Euclidean {
    public static int m;
    public static int n;

    public static int extendedAlgorithm(int a, int b) {
        int x = 0, y = 1, tempx = 1, tempy = 0, temp;
        while (b != 0)
        {
            int q = a / b;
            int r = a % b;

            a = b;
            b = r;

            temp = x;
            x = tempx - q * x;
            tempx = temp;

            temp = y;
            y = tempy - q * y;
            tempy = temp;            
        }

        m = tempx;
        n = tempy;

        if(tempx > tempy){
            return tempx;
        }else{
            return tempy;
        }
    }

    public static int mod(int v, int power, int m) {
        int x = 1;
        for(int i = 0; i < power; i++) {
            x = ((x * v) % m);
        }
        return x;
    }
}
