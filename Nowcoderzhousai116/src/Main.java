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

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            arr[i][0] = l;
            arr[i][1] = r;
            maxLeft = Math.max(maxLeft, l);
            minRight = Math.min(minRight, r);
        }

        if (maxLeft > minRight) {
            System.out.println("No");
            return;
        }

        // 按左端点排序（左端点相同则按右端点排序）
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int left = arr[0][0];

        // 左端点相同的最大的右端点
        int sameRight = arr[0][1];

        // 相对而言的最大右端点
        long maxRight = Long.MIN_VALUE;


        for (int j = 1; j < n; j++) {
            int l = arr[j][0];
            int r = arr[j][1];

            if (l > left) {
                maxRight = Math.max(maxRight, sameRight);
                if (maxRight > r) {
                    System.out.println("No");
                    return;
                }
                left = l;
                sameRight = r;
            } else {
                sameRight = Math.max(sameRight, r);
                if (maxRight > r) {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");

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