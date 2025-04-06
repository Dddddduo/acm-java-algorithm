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
 * https://ac.nowcoder.com/acm/contest/106318/G
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];

    // 邻边矩阵
    static ArrayList<ArrayList<Integer>> adj;
    // 价值
    static long val[];
    // 最大价值和
    static long max;
    //
    static int x;
    static int y;

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n=sc.nextInt(); // 节点数量
        int q=sc.nextInt(); // 询问次数

        adj = new ArrayList<>();
        val=new long[n+1];
        for (int i = 1; i <= n; i++) {
            val[i]=sc.nextLong(); // 节点的价值
        }

        for (int i = 0; i < n + 5; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            // 当前节点i 父节点是f
            int f=sc.nextInt();
            // 单向图
            adj.get(f).add(i);
        }

        for (int i = 0; i < q; i++) {
            max=0;
            x=sc.nextInt();
            y=sc.nextInt();
            // 把x的父节点变成y
            adj.get(y).add(x);
            // 递归
            dfs(1,1,0);
            // 清除状态
            adj.get(y).remove((Integer) x);
            // 打印
            System.out.println(max);
        }
    }
    /**
     * @param f 父节点
     * @param u 当前节点
     */
    private static void dfs(int f,int u,long value) {
        ArrayList<Integer> list = adj.get(u);
        if(u==x&&f!=y){
            max=Math.max(max,value);
            return;
        }
        long nowvalue=value+val[u];
        if(list.isEmpty()){
            max=Math.max(max,nowvalue);
        }else {
            for (Integer i : list) {
                dfs(u,i,nowvalue);
            }
        }
    }

    /**
     6 2
     2 10 4 7 6 3
     1 2 3 4 5
     4 6
     2 5

     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
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