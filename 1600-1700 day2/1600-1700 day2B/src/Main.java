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
 * https://codeforces.com/problemset/problem/1833/E
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj;

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        // 读取输入的 n
        int n = sc.nextInt();
        // 存储输入的数组 a
        int[] a = new int[n];
        // 邻接表存储图 g
        List<Set<Integer>> g = new ArrayList<>();
        // 存储每个节点的邻居节点
        List<Set<Integer>> neighbours = new ArrayList<>();
        // 存储每个节点的度数
        int[] d = new int[n];

        // 初始化图 g 和邻居节点集合
        for (int i = 0; i < n; i++) {
            g.add(new  HashSet<>());
            neighbours.add(new  HashSet<>());
        }

        // 读取输入并构建图
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt()  - 1;
            g.get(i).add(a[i]);
            g.get(a[i]).add(i);
        }

        // 计算每个节点的度数
        for (int i = 0; i < n; i++) {
            d[i] = g.get(i).size();
        }

        // 记录竹子的数量和环的数量
        int bamboos = 0, cycles = 0;
        // 标记节点是否被访问过
        boolean[] vis = new boolean[n];

        // 遍历所有节点，进行广度优先搜索
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                List<Integer> component = new ArrayList<>();
                component.add(i);

                // 广度优先搜索遍历连通分量
                while (!q.isEmpty())  {
                    int u = q.poll();
                    for (int v : g.get(u))  {
                        if (!vis[v]) {
                            vis[v] = true;
                            q.add(v);
                            component.add(v);
                        }
                    }
                }

                // 判断连通分量是否为竹子
                boolean bamboo = false;
                for (int j : component) {
                    if (d[j] == 1) {
                        bamboo = true;
                        break;
                    }
                }

                // 根据判断结果更新竹子和环的数量
                if (bamboo) {
                    bamboos++;
                } else {
                    cycles++;
                }
            }
        }

        // 输出结果
        dduoln(cycles  + Math.min(bamboos,  1) + " " + (cycles + bamboos));
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