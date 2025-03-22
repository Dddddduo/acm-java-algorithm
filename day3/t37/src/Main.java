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
 * https://vjudge.net/contest/703329#problem/B
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    //    static final int mod = (int) (1e9 + 7);
    static final int mod = (int) (998244353);

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
        int color[]=new int[n+1];
        HashMap<Integer,Integer>hm=new HashMap<>();

        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<n+5;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt();
            int v=i+2;
            // 有向图
            list.get(u).add(v);
        }

        // 当前层数的元素
        ArrayList<Integer>ceng=new ArrayList<>();

        int cnt=0;

        // 计算每层的元素
        Queue<Integer>queue=new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()){
            int num=queue.size();
            ceng.add(num);
            for(int i=0;i<num;i++){
                int ans=queue.poll();
                for(Integer ii:list.get(ans)){
//                    dduoln(ii);
                    queue.add(ii);
                }
            }
//            dduoln("s "+queue.size());
        }

        // 每一层的元素个数
//        for (Integer i : ceng) {
//            dduoln(i);
//        }

        Queue<Integer>newqueue=new LinkedList<>();
        newqueue.add(1);
        int k=0; // 当前层

        while (!newqueue.isEmpty()){
            int size = newqueue.size();
            for(int i=0;i<size;i++){
                Integer poll = newqueue.poll();
                if(poll==1){
                    cnt+=list.get(1).size();
                    cnt%=mod;
                }else{
                    // 下一层元素个数减去邻边
                    if(k+1<ceng.size()){
                        int i1 = ceng.get(k + 1) - list.get(poll).size();
                        if(i1==0){
                            continue;
                        }
                        cnt+=i1;
                    }
                    cnt%=mod;
                }
                for(Integer v:list.get(poll)){
                    newqueue.add(v);
                }
//                dduoln(poll+" "+cnt);
            }
            k++;
        }

        dduoln((cnt+1)%mod);
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