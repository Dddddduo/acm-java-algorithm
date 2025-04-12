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
 * https://codeforces.com/contest/1978/problem/C
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
        long n=sc.nextLong();
        long k=sc.nextLong();

        // k不能是奇数
        if(k%2!=0){
            dduoln("No");
            return;
        }

        long max=0;

        // 计算最大可以得到的数值

        if(n%2==0){
            // 偶数
            long num=n/2;
            max=(1+n-1)*num/2*2;
        }else{
            max=(n-1)*(n+1)/2;
        }

//        dduoln(max);

        if(k>max){
            dduoln("No");
            return;
        }

        dduoln("Yes");
        // k

        long a=(n-1)*2;
        int arr[]=new int[(int) (n/2)];

        long p[]=new long[(int) n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        k /= 2;
        for (int i = 0; k > 0; i++) {
            long currentMaxSwap = (n - 1) - 2 * i;
            if (k >= currentMaxSwap) {
                swap(p, i, n - 1 - i);
                k -= currentMaxSwap;
            } else {
                swap(p, i, i + k);
                k = 0;
            }
        }

        for (long num : p) {
            System.out.print((num  + 1) + " ");
        }
        System.out.println();

    }

    private static void swap(long[] arr, long i, long j) {
        long temp = arr[(int) i];
        arr[(int) i] = arr[(int) j];
        arr[(int) j] = temp;
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