// https://github.com/Dddddduo/acm-java-algorithm
// coding by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
// Dduo is the cutest girl in the world!
public class Main {

    private static DduoScanner sc = new DduoScanner();
//    private static final long MOD = (long) (1e9 + 7);
//    private static final long MOD = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();
    private static int dx[]={0,1,0,-1};
    private static int dy[]={1,0,-1,0};

    private static long INF = (long) 9e18;

    private static void solve() throws IOException {

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] a = new long[n + 1][m + 1];
        long[][] b = new long[n + 1][m + 1];
        long[][] dp = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextLong();
                dp[i][j] = INF;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] = sc.nextLong();
            }
        }

        dp[1][1] = b[1][1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (i == 1 && j == 1) continue;

                if (i >= 2) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
                }
                if (j >= 2) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i][j]);
                }

                dp[i][j] += b[i][j];

                if (a[i][j] - a[1][1] - dp[i][j] < 0) {
                    dp[i][j] = INF;
                }
            }
        }

        boolean flag = false;
        for (int j = 1; j <= m; j++) {
            if (dp[n][j] < INF) {
                flag = true;
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i][m] < INF) {
                flag = true;
                break;
            }
        }

        if(flag)sc.println("YES");
        else sc.println("NO");

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        // 默认开启多组输入
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

}

class DduoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public DduoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    protected String nextLine() throws IOException {
        return bf.readLine();
    }

    protected String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    protected char nextChar() throws IOException {
        return next().charAt(0);
    }

    protected int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    protected long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    protected double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    protected float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    protected BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    protected BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }

    protected void println(int a) throws IOException {
        print(a);
        println();
    }

    protected void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(String a) throws IOException {
        print(a);
        println();
    }

    protected void print(String a) throws IOException {
        bw.write(a);
    }

    protected void println(long a) throws IOException {
        print(a);
        println();
    }

    protected void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(double a) throws IOException {
        print(a);
        println();
    }

    protected void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    protected void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    protected void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(char a) throws IOException {
        print(a);
        println();
    }

    protected void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    protected void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    protected boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}