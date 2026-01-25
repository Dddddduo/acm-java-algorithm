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
//    private static final long mod = (long) (998244353);

    private static int n, k;
    private static long[] a;
    private static long b, c;
    private static boolean d;

    private static void solve() throws IOException {
        n = sc.nextInt();
        k = sc.nextInt();
        a = new long[n + 1];
        b = 0;
        c = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            b += a[i];
            c += a[i] * i;
        }
        d = false;
        f(1, 0, 0, 0);
        if (d) sc.print("Yes");
        else sc.print("No");
        sc.println();
    }

    private static void f(int i, int j, long x, long y) {
        if (d) return;
        if (j == k) {
            if (y * b == x * c) d = true;
            return;
        }
        if (i > n) return;
        f(i + 1, j + 1, x + a[i], y + a[i] * i);
        if (n - i + j + 1 > k) f(i + 1, j, x, y);
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

    public String nextLine() throws IOException {
        return bf.readLine();
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = bf.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public char nextChar() throws IOException {
        return next().charAt(0);
    }

    public int nextInt() throws IOException {
        String s = next();
        return s == null ? 0 : Integer.parseInt(s);
    }

    public long nextLong() throws IOException {
        String s = next();
        return s == null ? 0 : Long.parseLong(s);
    }

    public double nextDouble() throws IOException {
        String s = next();
        return s == null ? 0 : Double.parseDouble(s);
    }

    public float nextFloat() throws IOException {
        String s = next();
        return s == null ? 0 : Float.parseFloat(s);
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