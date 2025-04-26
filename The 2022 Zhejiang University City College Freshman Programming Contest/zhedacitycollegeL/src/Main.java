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
        long m=sc.nextLong(); // 报到m的倍数 交换
        long k=sc.nextLong(); // 总共k个数

        int arr1[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i]=i+1;
        }

        int arr2[]=new int[n];
        for (int i = n+1; i <= 2 * n; i++) {
            arr2[i-n-1]=i;
        }

//        for (int i : arr1) {
//            dduoln(i);
//        }
//
//        for (int i : arr2) {
//            dduoln(i);
//        }

        boolean judge=false;

        int i=0; // 指向数组的指针
        int num=1; // 报数

        while (num<=k){

//            dduoln("123");

//            int i1 = arr1[i];
//            int i2 = arr2[i];

            if(num%m==0){
                int temp=arr1[i];
                arr1[i]=arr2[i];
                arr2[i]=temp;
            }

            i++;
            if(i==n){
                i=0;
            }
            num++;
        }

        for (int a : arr1) {
            dduo(a+" ");
        }
        for (int a : arr2) {
            dduo(a+" ");
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