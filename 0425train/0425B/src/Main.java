// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

/**
 * 题目地址
 * https://codeforces.com/problemset/problem/131/C
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
        long n=sc.nextLong(); // 一共有n名男生
        long m=sc.nextLong(); // 一共有m名女生
        long k=sc.nextLong(); // 恰好选t名演员

//        dduoln(cn(5,4));

        long cnt=0;

        // 选男生
        for (long boy = 4; boy <= n; boy++) {
            long girl = k - boy;
            if(girl>m)break;
            if(girl<1)break;
//            dduoln(boy+" "+girl);
            cnt+=cn(n,boy)*cn(m,girl);
        }

        dduoln(cnt);

    }

    // 计算排列数 An(n, m) = n! / (n-m)!
    public static long an(long n, long m) {
        if (m < 0 || m > n) return 0;
        long result = 1;
        for (long i = 0; i < m; i++) {
            result *= (n - i);
            if (result < 0) { // 检测溢出
                throw new ArithmeticException("An计算溢出，n或m过大");
            }
        }
        return result;
    }

    // 计算组合数 Cn(n, m) = An(n, m) / m!
    public static long cn(long n, long m) {
        if (m < 0 || m > n) return 0;
        return an(n, m) / factorial(m);
    }

    // 计算阶乘（用于组合数分母）
    private static long factorial(long n) {
        if (n < 0) throw new IllegalArgumentException("n不能为负数");
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result *= i;
            if (result < 0) { // 检测溢出
                throw new ArithmeticException("阶乘计算溢出，n过大");
            }
        }
        return result;
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