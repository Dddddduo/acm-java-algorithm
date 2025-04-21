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
 * https://codeforces.com/problemset/problem/2084/C
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // 定义最大数组长度
    static final int maxn = 200100;
    // 数组 a 存储输入的第一个序列
    static int[] a = new int[maxn];
    // 数组 b 存储输入的第二个序列
    static int[] b = new int[maxn];
    // 数组 p 用于记录元素在 a 数组中的位置
    static int[] p = new int[maxn];
    // 二维数组 ans 存储交换操作的信息
    static int[][] ans = new int[maxn][2];
    // m 记录交换操作的次数
    static int m;

    static void work(int x, int y) {
        if (x == y) {
            return;
        }
        ans[++m][0] = x;
        ans[m][1] = y;

        int temp = a[x];

        a[x] = a[y];
        a[y] = temp;

        p[a[x]] = x;
        p[a[y]] = y;

        temp = b[x];
        b[x] = b[y];
        b[y] = temp;
    }

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            p[a[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        m = 0;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == b[i]) {
                if (n % 2 == 0 || x != 0) {
                    System.out.println("-1");
                    return;
                }
                x = i;
            } else if (b[p[b[i]]] != a[i]) {
                System.out.println("-1");
                return;
            }
        }
        if ((n & 1) == 1) {
            work(x, (n + 1) / 2);
        }
        for (int i = 1; i <= n / 2; i++) {
            work(p[b[i]], n - i + 1);
        }
        System.out.println(m);
        for (int i = 1; i <= m; i++) {
            System.out.println(ans[i][0]  + " " + ans[i][1]);
        }
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