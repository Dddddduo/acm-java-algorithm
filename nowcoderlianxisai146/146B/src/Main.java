// https://github.com/Dddddduo/acm-java-algorithm
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static class T {
        int t;
        int x;
        T(int t, int x) {
            this.t = t;
            this.x = x;
        }
    }

    private static void solve() throws IOException {

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<T> ts = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            ts.add(new T(t, x));
        }

        int q = sc.nextInt();
        int[] qs = new int[q];
        for (int i = 0; i < q; i++) {
            qs[i] = sc.nextInt();
        }

        double min0 = 0, max0 = 0;
        double min1 = Double.POSITIVE_INFINITY, max1 = Double.NEGATIVE_INFINITY;
        int ct = 0;

        for (T t : ts) {
            int tt = t.t;
            int x = t.x;
            int dt = tt - ct;

            if (dt > 0) {
                double cm0 = min0, cmx0 = max0;
                double cm1 = min1, cmx1 = max1;

                double nm0 = Double.POSITIVE_INFINITY, nmx0 = Double.NEGATIVE_INFINITY;
                double nm1 = Double.POSITIVE_INFINITY, nmx1 = Double.NEGATIVE_INFINITY;

                if (cm0 <= cmx0) {
                    int mj = dt - (dt % 2);
                    nm0 = Math.min(nm0, cm0);
                    nmx0 = Math.max(nmx0, cmx0 + mj);
                }
                if (cm1 <= cmx1 && dt >= 1) {
                    int mj = (dt % 2 != 0) ? dt : dt - 1;
                    nm0 = Math.min(nm0, cm1 + 1);
                    nmx0 = Math.max(nmx0, cmx1 + mj);
                }

                if (cm0 <= cmx0 && dt >= 1) {
                    int mj = (dt % 2 != 0) ? dt : dt - 1;
                    nm1 = Math.min(nm1, cm0 + 1);
                    nmx1 = Math.max(nmx1, cmx0 + mj);
                }
                if (cm1 <= cmx1) {
                    int mj = dt - (dt % 2);
                    nm1 = Math.min(nm1, cm1);
                    nmx1 = Math.max(nmx1, cmx1 + mj);
                }

                min0 = nm0; max0 = nmx0;
                min1 = nm1; max1 = nmx1;
            }

            if (x == 0) {
                min0 = Double.POSITIVE_INFINITY;
                max0 = Double.NEGATIVE_INFINITY;
            } else {
                min1 = Double.POSITIVE_INFINITY;
                max1 = Double.NEGATIVE_INFINITY;
            }

            ct = tt;
        }

        if (ct < n) {
            int dt = n - ct;
            double cm0 = min0, cmx0 = max0;
            double cm1 = min1, cmx1 = max1;

            double nm0 = Double.POSITIVE_INFINITY, nmx0 = Double.NEGATIVE_INFINITY;
            double nm1 = Double.POSITIVE_INFINITY, nmx1 = Double.NEGATIVE_INFINITY;

            if (cm0 <= cmx0) {
                int mj = dt - (dt % 2);
                nm0 = Math.min(nm0, cm0);
                nmx0 = Math.max(nmx0, cmx0 + mj);
            }
            if (cm1 <= cmx1 && dt >= 1) {
                int mj = (dt % 2 != 0) ? dt : dt - 1;
                nm0 = Math.min(nm0, cm1 + 1);
                nmx0 = Math.max(nmx0, cmx1 + mj);
            }

            if (cm0 <= cmx0 && dt >= 1) {
                int mj = (dt % 2 != 0) ? dt : dt - 1;
                nm1 = Math.min(nm1, cm0 + 1);
                nmx1 = Math.max(nmx1, cmx0 + mj);
            }
            if (cm1 <= cmx1) {
                int mj = dt - (dt % 2);
                nm1 = Math.min(nm1, cm1);
                nmx1 = Math.max(nmx1, cmx1 + mj);
            }

            min0 = nm0; max0 = nmx0;
            min1 = nm1; max1 = nmx1;
        }

        for (int s : qs) {
            boolean ok = false;
            if (s % 2 == 0) {
                ok = (s >= min0 && s <= max0);
            } else {
                ok = (s >= min1 && s <= max1);
            }
            sc.println(ok ? "Yes" : "No");
        }

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
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

    public void println(int a) throws IOException{
        print(a);
        println();
    }

    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException{
        print(a);
        println();
    }

    public void print(String a) throws IOException{
        bw.write(a);
    }

    public void println(long a) throws IOException{
        print(a);
        println();
    }

    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException{
        print(a);
        println();
    }

    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException{
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException{
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException{
        print(a);
        println();
    }

    public void println() throws IOException{
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}