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
    private static boolean visitedited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();
    private static int dx[] = {0, 1, 0, -1};
    private static int dy[] = {1, 0, -1, 0};

    private static void solve() throws IOException {

        int m = sc.nextInt();
        long c = sc.nextLong();
        int q = sc.nextInt();

        long[] a = new long[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextLong();
        }

        loop:for (int i1 = 0; i1 < q; i1++) {

            long x = sc.nextLong();

            if (c == x) {
                sc.println("Yes");
                continue;
            }

            if (c < x) {
                sc.println("No");
                continue;
            }

            long target = c - x;

            long[] visited = new long[m];
            Arrays.fill(visited, -1);

            ArrayList<Integer> path = new ArrayList<>();

            int u = (int) (x % m);

            long current = 0;

            while (current <= target) {
                if (current == target) {
                    sc.println("Yes");
                    continue loop;
                }
                // 成环
                if (visited[u] != -1) {
                    long start = visited[u];
                    long last = current - start;
                    if (last > 0) {
                        for (int p : path) {
                            long num = visited[p];
                            if (num >= start) {
                                if ((target - num) % last == 0) {
                                    sc.println("Yes");
                                    continue loop;
                                }
                            }
                        }
                    }
                    break;
                // 未成环
                }else{
                    visited[u] = current;
                    path.add(u);
                    long step = a[u];
                    current += step;
                    u = (int) ((u + step) % m);
                }
            }

            sc.println("No");
        }

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        // 默认开启多组输入
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

}

/**
 *
 */

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