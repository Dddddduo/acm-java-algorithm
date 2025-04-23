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
 * https://ac.nowcoder.com/acm/contest/108782/E
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
        int n=sc.nextInt();
        long value[]=new long[n];
        for (int i = 0; i < n; i++) {
            value[i]=sc.nextLong();
        }

        adj=new ArrayList<>();
        for (int i = 0; i < n + 5; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            // 无向图
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int min=-1;
        int minU=0; // 选择根节点
        for (int i = 1; i <= n ; i++) {
            int size = adj.get(i).size();
            if(size>min){
                min=size;
                minU=i;
            }
        }
//        dduoln(minU);

        Queue<Integer>queue=new LinkedList<>();
        queue.add(minU);

        ArrayList<Long> list = new ArrayList<>();
        visited=new boolean[n+1];
        visited[minU]=true;

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
//            dduoln(poll);
            visited[poll]=true;
            boolean  judge=false;
            for (Integer i1 : adj.get(poll)) {
                if(visited[i1]==false){
                    queue.add(i1);
                    if(judge==false)judge=true;
                }
            }
            if(judge==false)list.add(value[poll-1]);
        }

//        dduoln("---");
//        for (Long l : list) {
//            dduoln(l);
//        }

        long cnt=0;
        if(list.size()%2==0){
            for (Long l : list) {
                cnt+=l;
            }
        }else {
            Collections.sort(list);
            for (int i = 0; i < list.size()-1; i++) {
                cnt+=list.get(i);
            }
//            cnt+=list.get(list.size()-1)+minv;
            long va = list.get(list.size() - 1);
            Arrays.sort(value);
            long minv=value[0];
            if(minv==va){
                if(value.length<2){
                    cnt+=va*2;
                }else cnt+=va+value[1];
            }else {
                cnt+=va+value[0];
            }
        }

        dduoln(cnt);

    }

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