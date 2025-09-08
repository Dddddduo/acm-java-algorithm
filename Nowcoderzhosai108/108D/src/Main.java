import java.util.Scanner;

public class Main {
    static long MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            long jiCnt = 0;
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1] = sc.nextLong();
                if (arr[i1] % 2 == 1) jiCnt++;
            }
//            long sum = pow(2, n) ;
//            long jiSum = pow(2, jiCnt) ;
//            long result = sum - jiSum ;
            long sum = (pow(2, n) - 1 + MOD) % MOD;
            long jiSum = (pow(2, jiCnt) - 1 + MOD) % MOD;
            long result = (sum - jiSum + MOD) % MOD;
            System.out.println(result);
        }
    }

    // 快速幂模版
    private static long pow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}