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

    public static HashSet<Long> set;

    private static void solve() throws IOException {
        set = new HashSet<>();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();
        long arr[] = new long[]{a, b, c, d};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if(i!=j&&i!=k&&i!=l&&j!=k&&j!=l&&k!=l){
                            ways(arr[i], arr[j], arr[k], arr[l]);
                        }
                    }
                }
            }
        }

        sc.print(set.size());
    }

    public static void ways(long a, long b, long c, long d) {
        //  0 1 2
        //  + - *
        // a b c d
        for (int i1 = 0; i1 < 3; i1++) {
            for (int i2 = 0; i2 < 3; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    // 27种

                    // 3
                    if (i1 == 0 && i2 == 0 && i3 == 0) set.add(a + b + c + d);
                    if (i1 == 1 && i2 == 1 && i3 == 1) set.add(a - b - c - d);
                    if (i1 == 2 && i2 == 2 && i3 == 2) set.add(a * b * c * d);

                    //6 1 0
                    if (i1 == 1 && i2 == 0 && i3 == 0) set.add(a - b + c + d);
                    if (i1 == 0 && i2 == 1 && i3 == 0) set.add(a + b - c + d);
                    if (i1 == 0 && i2 == 0 && i3 == 1) set.add(a + b + c - d);
                    if (i1 == 1 && i2 == 1 && i3 == 0) set.add(a - b - c + d);
                    if (i1 == 1 && i2 == 0 && i3 == 1) set.add(a - b + c - d);
                    if (i1 == 0 && i2 == 1 && i3 == 1) set.add(a + b - c - d);

                    //6 1 2
                    if (i1 == 1 && i2 == 2 && i3 == 2) set.add(a - b * c * d);
                    if (i1 == 2 && i2 == 1 && i3 == 2) set.add(a * b - c * d);
                    if (i1 == 2 && i2 == 2 && i3 == 1) set.add(a * b * c - d);
                    if (i1 == 1 && i2 == 1 && i3 == 2) set.add(a - b - c * d);
                    if (i1 == 1 && i2 == 2 && i3 == 1) set.add(a - b * c - d);
                    if (i1 == 2 && i2 == 1 && i3 == 1) set.add(a * b - c - d);

                    //6 2 0
                    if (i1 == 2 && i2 == 0 && i3 == 0) set.add(a * b + c + d);
                    if (i1 == 0 && i2 == 2 && i3 == 0) set.add(a + b * c + d);
                    if (i1 == 0 && i2 == 0 && i3 == 2) set.add(a + b + c * d);
                    if (i1 == 2 && i2 == 2 && i3 == 0) set.add(a * b * c + d);
                    if (i1 == 2 && i2 == 0 && i3 == 2) set.add(a * b + c * d);
                    if (i1 == 0 && i2 == 2 && i3 == 2) set.add(a + b * c * d);

                    // 6 0 1 2
                    if (i1 == 0 && i2 == 1 && i3 == 2) set.add(a + b - c * d);
                    if (i1 == 0 && i2 == 2 && i3 == 1) set.add(a + b * c - d);
                    if (i1 == 1 && i2 == 0 && i3 == 2) set.add(a - b + c * d);
                    if (i1 == 1 && i2 == 2 && i3 == 0) set.add(a - b * c + d);
                    if (i1 == 2 && i2 == 1 && i3 == 0) set.add(a * b - c + d);
                    if (i1 == 2 && i2 == 0 && i3 == 1) set.add(a + b + c - d);
                }
            }
        }
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