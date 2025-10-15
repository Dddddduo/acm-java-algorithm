import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    private static void solve() {
        long num = sc.nextLong();
        int cnt = 0;

        while (num != 2) {
            num = countFactors(num);
            cnt++;
        }

        System.out.println(cnt);
    }

    // 分解质因数模版
    private static long countFactors(long n) {
        if (n == 1) return 1;
        long result = 1;
        int exponent;
        exponent = 0;
        while (n % 2 == 0) {
            exponent++;
            n /= 2;
        }
        if (exponent > 0) {
            result *= (exponent + 1);
        }
        for (long i = 3; i * i <= n; i += 2) {
            exponent = 0;
            while (n % i == 0) {
                exponent++;
                n /= i;
            }
            if (exponent > 0) {
                result *= (exponent + 1);
            }
        }
        if (n > 1) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int t = 1;
        // t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
