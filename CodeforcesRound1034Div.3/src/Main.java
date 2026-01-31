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

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    private static void solve() throws IOException {

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

    private String nextLine() throws IOException {
        return bf.readLine();
    }

    private String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    private char nextChar() throws IOException {
        return next().charAt(0);
    }

    private int nextInt() throws IOException {
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
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}