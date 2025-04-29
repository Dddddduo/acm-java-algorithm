import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // 最普通的质数筛
    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(number);  i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 埃拉托斯特尼筛
    public static List<Integer> generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }
        return list;
    }


}