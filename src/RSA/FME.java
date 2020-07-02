package RSA;

import java.math.BigInteger;

public class FME {

    public static BigInteger fme(BigInteger a, BigInteger b, BigInteger n){
        if (a.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        if (b.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        BigInteger y;
        if (b.mod(BigInteger.TWO).equals(BigInteger.ZERO))
        {
            y = fme(a, b.divide(BigInteger.valueOf(2)), n);
            y = (y.multiply(y)).mod(n);
        }
        else
        {
            y = a.mod(n);
            y = (y.multiply(fme(a, b.subtract(BigInteger.ONE),
                    n)).mod(n)).mod(n);
        }
        return (BigInteger)((y.add(n)).mod(n));
    }
}
