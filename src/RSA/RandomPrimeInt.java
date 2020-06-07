package RSA;

import java.util.Random;

public class RandomPrimeInt {

    public int getRandom(){
        int number = 0;
        Random random = new Random();
        while (true) {
            number = Math.abs(random.nextInt(15446));
            if (number > 1000) {
                if (isPrime(number))
                    break;
            }
        }
        return number;
    }

    static Boolean isPrime(int number){
        for (int i=2; i <= Math.sqrt(number); i++){
            if (number%i==0) {
                return false;
            }
        }
        return true;
    }
}
