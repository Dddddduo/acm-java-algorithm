// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner sc = new IoScanner();
//    private static final long mod = (long) (1e9 + 7);
    private static final long MOD = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    private static void solve() throws IOException {

//        preprocess(100005);

        int n=sc.nextInt();
        int arr1[]=new int[n];
        for (int i1 = 0; i1 < n; i1++) {
            arr1[i1]=sc.nextInt();
        }

        int min=Integer.MAX_VALUE;
        int arr2[]=new int[n];
        for (int i1 = 0; i1 < n; i1++) {
            arr2[i1]=sc.nextInt();
            min=Math.min(min,arr2[i1]);
        }

        int cnt=0;
        for (int i1 = 0; i1 < n; i1++) {
            if(arr1[i1]<min)cnt++;
        }

        // A(cnt,cnt)*A(n-cnt,n-cnt)
        sc.println(perm(cnt,cnt)*perm(n-cnt,n-cnt)%MOD);

    }

//    private static final long MOD = 1000000007;
    private static long[] fact;     // fact[i] = i! mod MOD
    private static long[] invFact;  // invFact[i] = (i!)^(-1) mod MOD

    /**
     * 快速幂取模：计算 (base^exponent) % modu，时间复杂度 O(log exponent)
     * 用于费马小定理求逆元（MOD为质数时，a的逆元 = a^(MOD-2) mod MOD）
     */
    private static long fastPowerMod(long base, long exponent, long modu) {
        long result = 1;
        base = base % modu; // 先取模避免溢出
        while (exponent > 0) {
            // 指数为奇数时，将当前底数乘到结果中
            if ((exponent & 1) == 1) {
                result = (result * base) % modu;
            }
            // 底数平方，指数折半
            base = (base * base) % modu;
            exponent >>= 1;
        }
        return result;
    }

    /**
     * 预处理阶乘和阶乘逆元（需先调用，才能计算组合数/排列数）
     * @param n 最大预处理范围（n <= MOD，且MOD为质数）
     */
    public static void preprocess(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("预处理范围n不能为负数");
        }
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = fastPowerMod(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    /**
     * 计算组合数 C(n, k) = n!/(k!(n−k)!) mod MOD
     */
    public static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    /**
     * 计算排列数 A(n, k) = n!/(n−k)! mod MOD（核心补充方法）
     */
    public static long perm(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0) return 1; // 空排列数量为1
        return fact[n] * invFact[n - k] % MOD;
    }

    public static void main(String[] args) throws Exception {
        preprocess(200005);
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

    private static <T> void dduo(T t) {
        System.out.print(t);
    }

    private static <T> void dduoln() {
        System.out.println("");
    }

    private static <T> void dduoln(T t) {
        System.out.println(t);
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