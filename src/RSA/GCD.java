package RSA;

public class GCD {

    public static int gcd(int a,int b){
        while (a != b) {
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }
        return b;
    }

    public static int EEA(int a,int b){
        int gcd = b;
        int q = 0;
        int k = 1;
        int x = 1;
        int y = 0;
        int x1 = 0;
        int y1 = 1;
        while (a != 0 && b != 0){
            if (k > 1){
                // tempx and tempy are used to keep previous values of x1 and y1.
                int tempx = x1;
                int tempy = y1;
                x1 = x1 * q + x;
                x = tempx;
                y1 = y1 * q + y;
                y = tempy;
            }
            q = a/b;
            int temp = a - q*b;
            k++;
            a = b;
            b = temp;
            if(b>0){
                gcd = b;
            }
        }
        int N = k-1; //Column index of GCD
        x = (int) (Math.pow(-1,N)* x1);
        y = (int) (Math.pow(-1,N+1) * y1);
        return gcd;
    }
}
