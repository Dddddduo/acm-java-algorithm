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
 * https://acm.hdu.edu.cn/contest/problem?cid=1153&pid=1001
 */

// xixi西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[][] a = new long[n + 1][k + 1];
        long[][] dp = new long[n + 1][k + 1];

        // 读取输入数据
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                a[i][j] = sc.nextLong();
            }
        }

        // 初始化第一行
        for (int i = 1; i <= k; i++) {
            dp[1][i] = a[1][i];
        }

        // 初始化第一列
        for (int i = 1; i <= n; i++) {
            dp[i][1] = a[i][1] + dp[i - 1][1];
        }

        // 动态规划计算
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Math.max(
                        Math.max(dp[i - 1][j - 1] + a[i][j], 0)
                        , Math.max(dp[i][j - 1] - a[i][j-1]+a[i][j], dp[i-1][j]+a[i][j])
                );
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                dduo(dp[i][j] + " ");
//            }
//            dduoln();
//        }

        // 查找最终结果
        long ans = 0;
        for (int j = 1; j <= k; j++) {
            ans = Math.max(ans, dp[n][j]);
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