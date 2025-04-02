// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

/**
 * 题目地址
 * https://codeforces.com/problemset/problem/2071/C
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj ;
    static ArrayList<ArrayList<Integer>> dis ;

    // 用于存储每个节点到起始节点的距离
    static int d[];
    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        // 读取输入的 n, s, e
        n = sc.nextInt();
        int s = sc.nextInt();
        int e = sc.nextInt();

        // 初始化邻接表，存储图的连接关系
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new  ArrayList<>());
        }

        // 读取图的边信息，并添加到邻接表中
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 初始化 dis 列表，用于存储每个深度的节点
        dis = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dis.add(new  ArrayList<>());
        }

        // 初始化 d 数组，用于存储每个节点到起始节点的距离
        d = new int[n + 1];

        dfs(e,  0);

        // 逆序输出每个深度的节点
        for (int i = n; i >= 1; i--) {
            for (int j : dis.get(i))  {
                dduo(j  + " ");
            }
        }
        dduoln();
    }

    static void dfs(int v, int par) {
        d[v] = d[par] + 1;
        dis.get(d[v]).add(v);
        // 遍历当前节点的所有邻居节点
        for (int u : adj.get(v))  {
            if (u == par) continue;
            dfs(u, v);
        }
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static <T> void dduo(T t) {
        System.out.print(t);
    }

    static <T> void dduoln() {
        System.out.println("");
    }

    static <T> void dduoln(T t) {
        System.out.println(t);
    }
}

/**
 * IoScanner类
 *
 * @author Dduo
 * @version 1.0
 * @description 通过IO流操作缓冲区减少了与底层输入输出设备的交互次数，旨在简化 Java 中的标准输入读取操作。
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
}