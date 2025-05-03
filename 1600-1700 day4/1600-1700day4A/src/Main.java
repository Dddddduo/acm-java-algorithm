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
 * https://codeforces.com/problemset/problem/2061/D
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
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            pq1.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            pq2.add(b[i]);
        }

//        while (!pq1.isEmpty()){
//            dduoln(pq1.poll());
//        }

        while (pq1.isEmpty()==false&&pq2.isEmpty()==false){
            Integer poll1 = pq1.poll();
            Integer poll2 = pq2.poll();
//            dduoln(poll1+" "+poll2);
            if(poll1==poll2)continue;
            else if(poll2>poll1){
                if(poll2%2==0){
                    pq2.add(poll2/2);
                    pq2.add(poll2/2);
                }else if(poll2%2!=0){
                    pq2.add(poll2/2);
                    pq2.add(poll2/2+1);
                }
                pq1.add(poll1);
            }else if(poll2<poll1){
                dduoln("NO");
                return;
            }
            if(pq1.size()<pq2.size()){
                dduoln("NO");
                return;
            }
        }
        if(pq1.isEmpty()&&pq2.isEmpty()){
            dduoln("YES");
        }else {
            dduoln("NO");
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