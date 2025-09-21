import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + a[i];
        }
        long minBalance = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int m = n - 1;
            int k = (m - 1) / 2;
            long median;
            if (k < i) {
                median = a[k];
            } else {
                median = a[k + 1];
            }
            int cntLe = k + 1;
            long sumLe;

            if (k < i) {
                sumLe = prefix[k + 1];
            } else {
                sumLe = prefix[k + 2] - a[i];
            }
            long total = prefix[n] - a[i];
            long sumGt = total - sumLe;
            int cntGt = m - cntLe;
            long balance = median * cntLe - sumLe + sumGt - median * cntGt;
            if (balance < minBalance) {
                minBalance = balance;
            }
        }
        System.out.println(minBalance);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}