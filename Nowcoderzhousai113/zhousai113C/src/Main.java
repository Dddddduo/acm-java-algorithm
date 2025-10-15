import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {
        int n = sc.nextInt();
        long arr[]=new long[n];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }

        int count2 = 0, count3 = 0, count5 = 0;

        for (long num : arr) {
            count2 += countFactor(num, 2);
            count3 += countFactor(num, 3);
            count5 += countFactor(num, 5);
        }

        System.out.println(Math.min(Math.min(count2, count3), count5));

    }

    private static int countFactor(long x, int factor) {
        int count = 0;
        while (x % factor == 0) {
            count++;
            x /= factor;
        }
        return count;
    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
