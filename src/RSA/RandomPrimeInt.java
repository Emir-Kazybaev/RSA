package RSA;

import java.math.BigInteger;
import java.util.Random;

public class RandomPrimeInt {

    public static int getRandom(){
        int number = 0;
        Random random = new Random();
        while (true) {
            number = Math.abs(random.nextInt(15446));
            if (number > 1000) {
                if (primality(BigInteger.valueOf(number)))
                    break;
            }
        }
        return number;
    }

    public static int getRandom(int num){
        int number = 0;
        Random random = new Random();
        while (true) {
            number = Math.abs(random.nextInt(num));
            if (number>=2)
            break;
        }
        return number;
    }

    public static boolean primality(BigInteger num) {
        if (num.equals(BigInteger.TWO) || num.equals(BigInteger.valueOf(3)))
            return true;
        if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO) || (num.compareTo(BigInteger.ONE) < 1))
            return false;
        BigInteger b = num.subtract(BigInteger.ONE);
        BigInteger d = b;
        int S;
        for (S = 0; d.mod(BigInteger.TWO) == BigInteger.ZERO; S++) {
            d = d.divide(BigInteger.TWO);
        }
        BigInteger a = BigInteger.valueOf(getRandom(b.intValue()));
        if ((FME.fme(a, d, num).equals(BigInteger.ONE)) || (FME.fme(a, d, num).equals(b))) {
            return true;
        }
        for (int r = 0; r < S; r++) {
            BigInteger exp = FME.fme(a, (BigInteger.valueOf(2).pow(r)).multiply(d), num);
            if (exp.equals(BigInteger.valueOf(1)))
                return false;
            else if (exp.equals(b))
                return true;
        }
        return false;
    }
}
