import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MOD = 1000000007;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int c0 = n / 5;
        int r = n % 5;

        int c1 = c0 + (r >= 1 ? 1 : 0);
        int c2 = c0 + (r >= 2 ? 1 : 0);
        int c3 = c0 + (r >= 3 ? 1 : 0);
        int c4 = c0 + (r >= 4 ? 1 : 0);

        long fact = 1;
        for (int i = 1; i < n; i++) {
            fact = (fact * i) % MOD;
        }

        long total = (0L * c0 + 1L * c1 + 2L * c2 + 3L * c3 + 4L * c4) % MOD;
        long ans = (total * fact) % MOD;

        System.out.println(ans);
    }
}
