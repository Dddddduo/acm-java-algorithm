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
 * https://ac.nowcoder.com/acm/contest/108199/F
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);


    static int arr[];
    static boolean visited[];

    // 邻接矩阵
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


    //
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    static int n;
    static int[] sum = new int[1000010];
    static int[] ans = new int[1000010];
    static String str;
    static int idx = 0, cnt = 0;


    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        n = sc.nextInt();
        str = sc.next();

        // 初始化邻接表
        for (int i = 0; i <= n+5; i++) {
            adj.add(new ArrayList<>());
        }

        // 计数
        for (int i = 1; i <= n; i++) {
            int k = sc.nextInt();
            sum[k]++;
        }

        // 优先队列
        for (int i = 1; i <= n; i++) {
            if (sum[i] > 0) {
                pq.add(new int[]{sum[i], i});
            }
        }

        // 建树
        build(1, 0);

        // 从根开始递归赋值
        dfs(0);

        dduoln("YES");

        StringBuilder sb=new StringBuilder("");
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] + " ");
//            dduo();
        }
        dduoln(sb);

    }

    // 建树
    static void build(int now, int fa) {
        // 递归出口 字符串的长度在0~2*n-1
        if (idx == 2 * n - 1) return;

        if (str.charAt(idx++) == '(') {
            adj.get(fa).add(++cnt);
            // 去下一个节点
            build(now + 1, now);
        } else {
            // 回到父节点
            build(fa, fa - 1);
        }

    }

    // 赋值
    static void dfs(int now) {
        List<int[]> cp = new ArrayList<>();
        for (int i : adj.get(now)) {
            // 直接退出
            if (pq.isEmpty()) {
                dduoln("NO");
                System.exit(0);
            }
            int[] t = pq.poll();
            ans[i] = t[1];
            cp.add(new int[]{t[0] - 1, t[1]});
        }
        for (int[] i : cp) {
            pq.add(i);
        }
        for (int i : adj.get(now)) {
            // 下一个节点
            dfs(i);
        }
    }

    /**
     3
     ()()()
     1 2 2
     
     NO
     */

    /**
     4
     ()(())()
     1 2 4 4

     YES
     4 2 4 1
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
