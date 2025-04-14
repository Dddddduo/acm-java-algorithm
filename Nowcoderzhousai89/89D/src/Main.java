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
 * https://ac.nowcoder.com/acm/contest/107000/D
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final long MOD = (long) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo

        long n = sc.nextLong();
        long k = sc.nextLong();

        if (k == n) {
            dduoln(2);
            return;
        }

        if (k % 2 == 0) {
            dduoln(pow(2, n - 1 ,MOD));
        } else {
            dduoln(pow(2, n ,MOD));
        }
    }

    // 快速幂模版
    public static long pow(long base, long exponent, long mod) {
        long result = 1 % mod;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) != 0) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result%MOD;
    }

    // 组合数模版
    // 计算组合数C(a,b) = a!/(b!(a-b)!)
    // 计算组合数 C(a, b) = a! / (b! * (a - b)!) 并进行取模操作
    public static long  c(long a, long b) {
        // 处理非法输入
        if (b < 0 || b > a) return 0;
        if (b == 0 || b == a) return 1;

        // 优化：取较小的 b 计算
        b = Math.min(b,  a - b);

        long result = 1;
        for (int i = 1; i <= b; i++) {
            // 计算分子部分并取模
            result = result * (a - b + i) % MOD;
            // 计算分母部分的逆元并取模
            result = result * modInverse(i, MOD) % MOD;
        }
        return result;
    }

    // 计算排列数 A(a, b) = a! / (a - b)! 并进行取模操作
    public static long a(long a, long b) {
        // 处理非法输入
        if (b < 0 || b > a) return 0;
        if (b == 0) return 1;

        long result = 1;
        for (long i = a; i > a - b; i--) {
            // 累乘并取模
            result = result * i % MOD;
        }
        return result;
    }

    // 计算模逆元（使用费马小定理）
    private static long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    // 快速幂算法，用于计算 a^b % m
    private static long power(long a, long b, long m) {
        long res = 1;
        a = a % m;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % m;
            }
            b = b >> 1;
            a = a * a % m;
        }
        return res;
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