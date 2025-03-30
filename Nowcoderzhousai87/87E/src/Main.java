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
 * https://ac.nowcoder.com/acm/contest/105623/E
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

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 检查 x | y 是否等于 x
        if ((x | y) != x) {
            System.out.println("NO");
            return;
        }

        int[] ans = new int[n];
        int c = 1;

        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) == 0) {
                continue;
            }
            if (((y >> i) & 1) == 0) {
                if (n == 1) {
                    System.out.println("NO");
                    return;
                }
                if (c == 1) {
                    for (int j = 0; j < n - (n % 2); j++) {
                        ans[j] |= 1 << i;
                    }
                } else {
                    for (int j = 0; j < n - (n % 2); j++) {
                        ans[n - j - 1] |= 1 << i;
                    }
                }
            } else {
                if (c == 1) {
                    for (int j = 0; j < n - (n % 2 ^ 1); j++) {
                        ans[j] |= 1 << i;
                    }
                } else {
                    for (int j = 0; j < n - (n % 2 ^ 1); j++) {
                        ans[n - j - 1] |= 1 << i;
                    }
                }
            }
            c ^= 1;
        }

        for (int num : ans) {
            if (num == 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print("  ");
            }
            System.out.print(ans[i]);
        }
        System.out.println();
    }

    public static boolean judge(int n, long x, long y) {
        if ((x | y) != x) {
            return false;
        }
        if (n == 1) {
            return x == y;
        }
        return true;
    }
//
//    public static void printSolution(int n, long x, long y) {
//
//
//
//    }

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