import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        long n = sc.nextLong();
        long x = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        double sum = (x * 0.01 * a) + ((100 - x) * 0.01 * b);
        double total = n * sum;

        System.out.println(String.format("%.2f", total));
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }
}