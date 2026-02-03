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


        List<int[]> list = new ArrayList<>();

        for (int start = 2; start + 2 <= n; start += 4) {
            list.add(new int[]{start, start + 1, start + 2});
        }

        System.out.println(list.size());
        for (int[] arr : list) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }

    }

    public static void main(String[] args) throws Exception {
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

/**
 * 0
 * 0
 * 0
 * 1
 * 2 3 4
 * 1
 * 2 3 4
 * 2
 * 1 2 4
 * 3 5 6
 * 2
 * 1 2 4
 * 3 5 6
 * 2
 * 1 2 4
 * 3 5 6
 * 3
 * 1 2 4
 * 5 6 8
 * 3 7 9
 * 3
 * 1 2 4
 * 3 5 6
 * 8 9 10
 * 3
 * 1 2 4
 * 3 5 6
 * 8 9 10
 * 4
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 4
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 4
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 5
 * 1 2 4
 * 5 6 8
 * 3 7 9
 * 10 11 14
 * 12 13 15
 * 5
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 14 15 16
 * 5
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 14 15 16
 * 6
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 13 14 16
 * 15 17 18
 * 6
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 13 14 16
 * 15 17 18
 * 6
 * 1 2 4
 * 3 5 6
 * 7 8 10
 * 9 11 12
 * 13 14 16
 * 15 17 18
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