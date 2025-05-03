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
 * https://codeforces.com/gym/105161/problem/I
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static final int N = 100005;
    static int n;
    static long[] a = new long[N];
    static long[] b = new long[N];

    static boolean check(long x) {
        TreeSet<Long> s1 = new TreeSet<>();
        TreeSet<Long> s2 = new TreeSet<>();
        for (int i = 1; i <= n; ++i) {
            if (b[i] == 0) {
                if (s1.isEmpty()) {
                    s2.add(a[i]);
                } else {
                    Long t = s1.ceiling(x - a[i]);
                    if (t == null) {
                        return false;
                    } else {
                        s1.remove(t);
                    }
                }
            } else {
                if (s2.isEmpty()) {
                    s1.add(a[i]);
                } else {
                    Long t = s2.ceiling(x - a[i]);
                    if (t == null) {
                        return false;
                    } else {
                        s2.remove(t);
                    }
                }
            }
        }
        return true;
    }

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        n = sc.nextInt();
        long maxn = 0;
        for (int i = 1; i <= n; ++i) {
            a[i] = sc.nextLong();
            maxn = Math.max(maxn, a[i]);
        }
        for (int i = 1; i <= n; ++i) {
            b[i] = sc.nextLong();
        }
        long l = 0;
        long r = 2 * maxn + 1;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }

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