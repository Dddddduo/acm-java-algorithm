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
 *
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
        int k=sc.nextInt();
        int q=sc.nextInt();

        int arr[]=new int[200000+5];
        for (int i = 0; i < n; i++) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            arr[l-1]++;
            arr[r]--;
        }

        int a[]=new int[200000+5];
        int aaa=0;
        for(int i=0;i<=200000;i++){
            a[i]=aaa;
            aaa+=arr[i];
        }

//        for(int i=1;i<=100;i++){
//            dduoln(i+" "+a[i]);
//        }

        for(int i=1;i<=200000;i++){
            if(a[i]>=k){
                a[i]=1;
            }else {
                a[i]=0;
            }
        }

//        for(int i=1;i<=100;i++){
//            dduoln(i+" "+a[i]);
//        }

        int pre[]=new int[200000+5] ;
        for(int i=1;i<=200000;i++){
            pre[i]=pre[i-1]+a[i];
//            aaa+=arr[i];
        }

        for (int i = 0; i < q; i++) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            dduoln(pre[r]-pre[l-1]);
        }


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