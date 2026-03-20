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
    // 不再使用模板自带的通用变量，针对题目定义特定变量
     private static int arr[];
     private static boolean visited[];
     private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     private static Stack<Integer> stack = new Stack<>();
     private static Queue<Integer> queue = new LinkedList<>();
     private static Deque<Integer> deque = new LinkedList<>();
     private static int dx[]={0,1,0,-1};
     private static int dy[]={1,0,-1,0};

    private static final int MAXN = 300005;
    private static ArrayList<Integer>[] divs; // 预处理因子

    // 预处理因子，只执行一次
    static {
        divs = new ArrayList[MAXN];
        for (int i = 0; i < MAXN; i++) {
            divs[i] = new ArrayList<>();
        }
        // 类似于埃氏筛，预处理每个数的因子
        for (int i = 1; i < MAXN; ++i) {
            for (int j = i; j < MAXN; j += i) {
                divs[j].add(i);
            }
        }
    }

    private static void solve() throws IOException {
        int n = sc.nextInt();

        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val <= n) {
                present[val] = true;
            }
        }

        int[] dp = new int[n + 1];
        int INF = 1000000000;
        Arrays.fill(dp, INF);

        if (present[1]) {
            dp[1] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            if (present[i]) {
                dp[i] = 1;
            }

            for (int d : divs[i]) {
                if (d == 1) continue;

                if (present[d]) {
                    int prev = i / d;
                    if (dp[prev] != INF) {
                        dp[i] = Math.min(dp[i], dp[prev] + 1);
                    }
                }
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (dp[i] == INF) {
                sc.print("-1");
            } else {
                sc.print(dp[i]);
            }
            sc.print(i == n ? "" : " ");
        }
        sc.println();
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        // 默认开启多组输入
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        // 模板中的 bw.close() 在 sc.bw.close() 中被调用
        // sc.bw.close() is private inside DduoScanner usually or accessed via method,
        // assuming standard structure allows accessing bw or flush handles it.
        // 根据下面 DduoScanner 代码，bw 是 package-private (default)，所以在 Main 中可以访问
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
            String line = bf.readLine();
            if (line == null) return null; // 处理 EOF
            st = new StringTokenizer(line);
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
        while (!st.hasMoreTokens()) {
            String line = bf.readLine();
            if (line == null) return false;
            if (line.trim().isEmpty()) continue; // 跳过空行
            st = new StringTokenizer(line);
        }
        return true;
    }

}