// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner s = new IoScanner();
    private static final long M = (long) (1e9 + 7);
//    private static final long m = (long) (998244353);

    private static int n;
    private static int a[];
    private static boolean v[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> st = new Stack<>();
    private static Queue<Integer> q = new LinkedList<>();
    private static Deque<Integer> d = new LinkedList<>();

    private static final int MAX = 2000000;
    private static long[] sf;
    private static int[] p;
    private static boolean[] np;
    private static int c;
    private static Map<Integer, Long> h;
    private static boolean isInit = false;
    private static final long I6 = 166666668; // 6关于M的逆元
    private static final long I2 = 500000004; // 2关于M的逆元

    private static void init() {
        if (isInit) return;
        sf = new long[MAX + 1];
        p = new int[MAX / 2];
        np = new boolean[MAX + 1];
        c = 0;

        sf[1] = 1;

        for (int i = 2; i <= MAX; i++) {
            if (!np[i]) {
                p[c++] = i;
                long x = (long)i * i % M;
                sf[i] = (M - x) % M;
            }
            for (int j = 0; j < c && (long)i * p[j] <= MAX; j++) {
                int y = p[j];
                int z = i * y;
                np[z] = true;

                if (i % y == 0) {
                    sf[z] = 0;
                    break;
                } else {
                    long x = (long)y * y % M;
                    long t = (M - x) % M;
                    sf[z] = sf[i] * t % M;
                }
            }
        }

        for (int i = 2; i <= MAX; i++) {
            sf[i] = (sf[i-1] + sf[i]) % M;
        }

        h = new HashMap<>();
        isInit = true;
    }

    private static long calc(long n) {
        if (n == 0) return 0;
        long a = n % M;
        long b = (n + 1) % M;
        long c = (2 * n + 1) % M;
        long res = a * b % M;
        res = res * c % M;
        res = res * I6 % M;
        return res;
    }

    private static long get(int n) {
        if (n <= MAX) return sf[n];
        if (h.containsKey(n)) return h.get(n);

        long ans = 1;
        for (int l = 2, r; l <= n; l = r + 1) {
            r = n / (n / l);
            if (r == 0) r = n;

            long g = (calc(r) - calc(l - 1) + M) % M;
            long f = get(n / l);

            ans = (ans - g * f % M + M) % M;
        }

        h.put(n, ans);
        return ans;
    }

    private static void solve() throws IOException {
        n = s.nextInt();
        init();

        long tot = 0;
        for (int l = 1, r; l <= n; l = r + 1) {
            r = n / (n / l);

            long s = (get(r) - get(l - 1) + M) % M;

            long k = n / l;
            long sk = (k % M) * ((k + 1) % M) % M * I2 % M;
            long sk2 = sk * sk % M;

            tot = (tot + s * sk2 % M) % M;
        }
        outln(tot);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.flush();
        s.bw.close();
    }

    private static <T> void out(T t) {
        System.out.print(t);
    }

    private static <T> void outln() {
        System.out.println("");
    }

    private static <T> void outln(T t) {
        System.out.println(t);
    }

}

class IoScanner {
    BufferedReader br;
    StringTokenizer st;
    BufferedWriter bw;

    public IoScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private String nextLine() throws IOException {
        return br.readLine();
    }

    private String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private char nextChar() throws IOException {
        return next().charAt(0);
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    private BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    private BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }

    private void println(int a) throws IOException{
        print(a);
        println();
    }

    private void print(int a) throws IOException{
        bw.write(String.valueOf(a));
    }

    private void println(String a) throws IOException{
        print(a);
        println();
    }

    private void print(String a) throws IOException{
        bw.write(a);
    }

    private void println(long a) throws IOException{
        print(a);
        println();
    }

    private void print(long a) throws IOException{
        bw.write(String.valueOf(a));
    }

    private void println(double a) throws IOException{
        print(a);
        println();
    }

    private void print(double a) throws IOException{
        bw.write(String.valueOf(a));
    }

    private void print(BigInteger a) throws IOException{
        bw.write(a.toString());
    }

    private void println(BigInteger a) throws IOException{
        bw.write(a.toString());
        println();
    }

    private void print(char a) throws IOException{
        bw.write(String.valueOf(a));
    }

    private void println(char a) throws IOException{
        print(a);
        println();
    }

    private void println() throws IOException{
        bw.newLine();
    }

    //其他调试命令：
    void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    private boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //s.flush()
        //调试完可删去
        return br.ready();
    }

}