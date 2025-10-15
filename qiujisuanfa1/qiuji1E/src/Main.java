import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long mod = 1000000007 ;
    private static void solve() {

        long n = sc.nextLong();
        long m = sc.nextLong();

        long ans1 = (n-2)%mod*(m-1)%mod + (n-1)%mod*(m-2)%mod;
        long ans2 = 2*(m+n)%mod-4;


        long cnt = ans1*ans2%mod;
//        cnt %=mod;

        System.out.println(cnt);

    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
