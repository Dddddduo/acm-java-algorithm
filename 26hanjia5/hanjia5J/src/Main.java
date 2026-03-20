// https://github.com/Dddddduo/acm-java-algorithm
// coding by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
// Dduo is the cutest girl in the world!
public class Main {

    private static DduoScanner sc = new DduoScanner();
//    private static final long MOD = (long) (1e9 + 7);
//    private static final long MOD = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();
    private static int dx[] = {0, 1, 0, -1};
    private static int dy[] = {1, 0, -1, 0};

    private static void solve() throws IOException {
        int arr[][] = new int[4][4];
        HashSet<Integer> set = new HashSet<>();
        for (int i1 = 1; i1 <= 3; i1++) {
            for (int i2 = 1; i2 <= 3; i2++) {
                arr[i1][i2] = sc.nextInt();
                set.add(arr[i1][i2]);
            }
        }

        if (set.size() != 9) {
            sc.println("No");
            return;
        }

        int i1 = arr[1][1] + arr[1][2] + arr[1][3];
        int i2 = arr[2][1] + arr[2][2] + arr[2][3];
        int i3 = arr[3][1] + arr[3][2] + arr[3][3];

        int i4 = arr[1][1] + arr[2][1] + arr[3][1];
        int i5 = arr[1][2] + arr[2][2] + arr[3][2];
        int i6 = arr[1][3] + arr[2][3] + arr[3][3];

        int i7 = arr[1][1] + arr[2][2] + arr[3][3];
        int i8 = arr[1][3] + arr[2][2] + arr[3][1];

        if (i1 != i2 || i1 != i3 || i1 != i4 || i1 != i5 || i1 != i6 || i1 != i7 || i1 != i8 ||
                i2 != i3 || i2 != i4 || i2 != i5 || i2 != i6 || i2 != i7 || i2 != i8 ||
                i3 != i4 || i3 != i5 || i3 != i6 || i3 != i7 || i3 != i8 ||
                i4 != i5 || i4 != i6 || i4 != i7 || i4 != i8 ||
                i5 != i6 || i5 != i7 || i5 != i8 ||
                i6 != i7 || i6 != i8 ||
                i7 != i8) {
            sc.println("No");
            return;
        }

        sc.println("Yes");
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        // 默认开启多组输入
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

}

class DduoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public DduoScanner() {
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