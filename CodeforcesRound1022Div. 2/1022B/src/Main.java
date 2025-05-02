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
 * https://codeforces.com/contest/2108/problem/B
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
        long n=sc.nextLong(); // 一共多少个数
        long x=sc.nextLong(); // 最终值

        if(n==2&&x==1){
            dduoln("5");
            return;
        }

        if(n==1&&x==0){
            dduoln("-1");
            return;
        }

        // 有多少位是1
        long bit1 = Long.bitCount(x);

        // 每个数位1贡献一次
        if(n<=bit1){
            dduoln(x);
        }else if(n>=bit1){
            // 每个数位贡献完毕
            // 当前数值为x
            long ans=x;

            // 但是有些n为0
            // 要把其改成大于0的数

            // 剩余的数n 当前值为0 需要改成大于0的数
            long sheng=n-bit1;

//            dduoln(ans);
//            dduoln(sheng);

            // 偶数个1对当前数位贡献不变
            if(sheng%2==0){
//                dduoln(sheng+ans);
                ans+=sheng;
            }else if(sheng%2!=0){
                ans+=(sheng-1);
                // 还有一个数为0
                if(bit1>1||bit1==1&&x!=1){
                    // 在最后一位上修改
                    ans+=2;
                }else {
                    // 在倒数第二位上修改
                    ans+=4;
                }
            }
            dduoln(ans);
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