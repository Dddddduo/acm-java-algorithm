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

        int n = 3;
        char arr[][] = new char[n][n];
        for (int i1 = 0; i1 < n; i1++) {
            String str = sc.next();
            arr[i1] = str.toCharArray();
        }

        int count=0;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i = 0; i < n; i++) {
                char c=arr[i1][i];
                if (c == 'X')count++;
            }
        }

        if(count<=2){
            sc.println("Yes");
            return;
        }

        // 第一步就赢
        if (judge1(arr[0][0], arr[0][1], arr[0][2]) ||
                judge1(arr[1][0], arr[1][1], arr[1][2]) ||
                judge1(arr[2][0], arr[2][1], arr[2][2]) ||

                judge1(arr[0][0], arr[1][0], arr[2][0]) ||
                judge1(arr[0][1], arr[1][1], arr[2][1]) ||
                judge1(arr[0][2], arr[1][2], arr[2][2]) ||

                judge1(arr[0][2], arr[1][1], arr[2][0]) ||
                judge1(arr[0][0], arr[1][1], arr[2][2])) {
            sc.println("Yes");
            return;
        }

        // 第一步就赢
        int cnt = 0;
        if (judge2(arr[0][0], arr[0][1], arr[0][2])) cnt++;
        if (judge2(arr[1][0], arr[1][1], arr[1][2])) cnt++;
        if (judge2(arr[2][0], arr[2][1], arr[2][2])) cnt++;
        if (judge2(arr[0][0], arr[1][0], arr[2][0])) cnt++;
        if (judge2(arr[0][1], arr[1][1], arr[2][1])) cnt++;
        if (judge2(arr[0][2], arr[1][2], arr[2][2])) cnt++;
        if (judge2(arr[0][2], arr[1][1], arr[2][0])) cnt++;
        if (judge2(arr[0][0], arr[1][1], arr[2][2])) cnt++;
        if (cnt > 0) {
            sc.println("Yes");
            return;
        }



        sc.println("No");

    }

    // 一步直接获胜
    private static boolean judge1(char i1, char i2, char i3) {
        int X = 0;
        int O = 0;
        int G = 0;
        char[] arr = new char[]{i1, i2, i3};
        for (char c : arr) {
            if (c == 'X') X++;
            else if (c == 'O') O++;
            else if (c == 'G') G++;
        }
        // 自己子 未落子 敌人子
        if (X == 1 && G == 2 && O == 0) return true;
        return false;
    }

    // 封不死
    private static boolean judge2(char i1, char i2, char i3) {
        int X = 0;
        int O = 0;
        int G = 0;
        char[] arr = new char[]{i1, i2, i3};
        for (char c : arr) {
            if (c == 'X') X++;
            else if (c == 'O') O++;
            else if (c == 'G') G++;
        }
        // 自己子2 未落子1 敌人子0
        if (X == 2 && G == 1 && O == 0) return true;
        return false;
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