import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt();
        while (t-->0){
            solve();
        }
    }

    static void solve() {
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        long ans = (k % n == 0) ? k / n : k / n + 1;

        long l = 2, r = m;
        long j = m;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sum = c(m, mid);
            if (sum >= ans) {
                j = mid - 1;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(j);

    }

    public static long c(long m, long i) {
        return m / i * (i - 1) + m % i;
    }

}