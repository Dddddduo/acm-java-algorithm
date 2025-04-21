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
 * https://codeforces.com/problemset/problem/2027/C
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n=sc.nextInt();
        long arr[]=new long[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i]=sc.nextLong();
        }

        HashMap<Long,ArrayList<Long>>adj=new HashMap<>();

        for (int i = 2; i <= n; i++) {
//            dduoln("数组长度为:"+(arr[i]+i-1)+" 的时候,添加"+(i-1)+"个0");
            long u=arr[i]+i-1;
            long v=u+(i-1);
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }

        long max=Long.MIN_VALUE;

        Queue<Long>queue=new LinkedList<>();
        HashSet<Long>vis=new HashSet<>();
        queue.add((long) n);
        // 处理已经访问过的情况时 越先处理时间复杂度越低
        vis.add((long) n);
        while(!queue.isEmpty()){
            Long u = queue.poll();
            for (Long l :adj.getOrDefault(u,new ArrayList<>())) {
                if(vis.contains(l)==false){
                    vis.add(l);
                    queue.add(l);
                }
            }
        }
        dduoln(Collections.max(vis));
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