// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

/**
 * 题目地址
 * https://ac.nowcoder.com/acm/contest/107000/F
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj ;

    static HashSet<Integer>p;

    static List<Integer>[] tree;
//    static int[] baohan, tichu;
    static int[][] dp;

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        n=sc.nextInt();
        adj=new ArrayList<>();
        for (int i = 0; i < n + 5; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dfs(1, -1);
//        dduoln(dp[1][0]+" "+dp[1][1]);
        dduoln(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int u, int parent) {
        List<Integer> children = new ArrayList<>();
        for (int v : adj.get(u)) {
            if (v != parent) {
                dfs(v, u);
                children.add(v);
            }
        }
        int sum0 = 0;
        int sum1 = 0;
        for (int v : children) {
            sum0 += (dp[v][1] + 1);
            sum1 += Math.min(dp[v][0], dp[v][1] + 1);
        }
        dp[u][0] = sum0;
        dp[u][1] = sum1;
    }

    /**
     18
     1 2
     1 3
     2 4
     2 5
     3 6
     3 7
     3 8
     4 9
     5 10
     5 11
     6 12
     7 13
     7 14
     8 15
     8 16
     8 17
     17 18
     */



    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static <T> void dduo(T t) {
        System.out.print(t);
    }

    static <T> void dduoln() {
        System.out.println("");
    }

    static <T> void dduoln(T t) {
        System.out.println(t);
    }
}

/**
 * IoScanner类
 *
 * @author Dduo
 * @version 1.0
 * @description 通过IO流操作缓冲区减少了与底层输入输出设备的交互次数，旨在简化 Java 中的标准输入读取操作。
 */
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