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
 * https://codeforces.com/contest/2086/problem/D
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
    static final int MOD = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // 预计算阶乘和阶乘的逆元模 MOD
    static long[] fact = new long[1000010];
    static long[] inv_fact = new long[1000010];

    // 快速逆元
    static {
        fact[0] = 1;
        for (int i = 1; i < 1000010; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        inv_fact[1000010 - 1] = modPow(fact[1000010 - 1], MOD - 2);
        for (int i = 1000010 - 2; i >= 0; i--) {
            inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD;
        }
    }

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo

        int[] c = new int[26];
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            c[i] = sc.nextInt();
            sum += c[i];
        }

        if (sum == 0) {
            dduoln(0);
            return;
        }

        // 偶数
        int odd = (sum + 1) / 2;
        // 奇数
        int even = sum / 2;

        long num1 = 1;
        for (int ci : c) {
            if (ci != 0) {
                num1 = num1 * inv_fact[ci] % MOD;
            }
        }

        int ans = odd;
        long[] dp = new long[ans + 1];
        dp[0] = 1;

        for (int ci : c) {
            if (ci == 0 || ci > ans) {
                continue;
            }

            for (int x = ans; x >= ci; x--) {
                dp[x] = (dp[x] + dp[x - ci]) % MOD;
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            dduo(dp[i]+" ");
//        }
//        dduoln();

        long count = dp[odd];

        if (count == 0) {
            System.out.println(0);
            return;
        }

        // 计算答案
        long oddddd = fact[odd];// 偶
        long eveneven = fact[even]; // 奇

//        dduoln(oddddd+" "+eveneven);

        long daan = count * oddddd;
        daan%=MOD;
//        daan  *= fact_even % MOD;
//        daan  *= product_inv % MOD;

        daan*=eveneven;
        daan%=MOD;

        daan*=num1;
        daan%=MOD;
        dduoln(daan% MOD);
    }

    // 快速幂取模 模版
    static long modPow(long base, long exponent) {
        long result = 1;
        base = base % MOD;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = result * base % MOD;
            }
            exponent >>= 1;
            base = base * base % MOD;
        }
        return result;
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