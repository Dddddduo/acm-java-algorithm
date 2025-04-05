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
 * https://codeforces.com/problemset/problem/2065/E
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
        int n=sc.nextInt(); // 0的数量
        int m=sc.nextInt(); // 1的数量
        int k=sc.nextInt(); // 平衡值

        StringBuilder sb=new StringBuilder("");

        boolean judge=false;
        // true
        if(n>m){
            judge=true; // 0比较多
        }else{
            judge=false; // 1比较多
        }

        while (n>0||m>0){
            if(judge==true){
                judge=false;
                // 从0开始
                if(n==0)continue;
                if(n>=k){
                    for (int i = 0; i < k; i++) {
                        sb.append("0");
                    }
                    n-=k;
                }else{
                    for (int i = 0; i < n; i++) {
                        sb.append("0");
                    }
                    n=0;
                }
            }else if(judge==false){
                judge=true;
                // 从1开始
                if(m==0)continue;
                if(m>=k){
                    for (int i = 0; i < k; i++) {
                        sb.append("1");
                    }
                    m-=k;
                }else{
                    for (int i = 0; i < m; i++) {
                        sb.append("1");
                    }
                    m=0;
                }
            }
        }

        String str=sb.toString();
//        dduoln(str);

        int cnt0=0;
        int cnt1=0;

        int max=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                cnt1++;
            }else{
                cnt0++;
            }
            max=Math.max(Math.abs(cnt1-cnt0),max);
        }
        if(max!=k){
            dduoln("-1");
        }else {
            dduoln(str);
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