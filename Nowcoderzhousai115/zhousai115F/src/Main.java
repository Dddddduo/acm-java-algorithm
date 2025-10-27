import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {

        long n = sc.nextLong();
        long k = sc.nextLong();

        if (k == 1) {
            System.out.println((n * n));
            return;
        }

        long ans = Long.MIN_VALUE;

//        for (long i = 1; i <= n; i++) {
        for (long i = n; i >= 1; i--) {
            // 分成m份
            long m = n/i;
            if (m<k) {
                continue;
            }
//            System.out.println(m);
            long gcd = n/m;
            // 2 4 8 m=3 gcd=2 sum=14
            // 3 6 9 m=3 gcd=3 sum=18
            // 4 8 12 m=3 gcd=4 sum=24
            long sum = gcd*m*(m+1)/2;
            long temp = gcd*sum;
//            System.out.println(m + " " + gcd);
            if(temp>ans) {
//                System.out.println(m);
                ans = temp;
            }else break;

        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

}

class IoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public IoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public String nextLine() throws IOException {
        return bf.readLine();
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    public char nextChar() throws IOException {
        return next().charAt(0);
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    public BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }
}