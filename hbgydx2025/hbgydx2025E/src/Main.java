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
 * https://ac.nowcoder.com/acm/contest/106269/E
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
        long sum=0; // 当前总和 要减去的
        long jianshao=0; // 总共可以减少的
        long a[][]=new long[n][2];
        for(int i=0;i<n;i++){
            long x=sc.nextLong();
            long y=sc.nextLong();
            a[i][0]=x;
            a[i][1]=y;
            sum+=y;
            jianshao+=(y-x);
        }

        if(jianshao<sum){
            dduoln("No");
            return;
        }

        long arr[]=new long[n];
        for (int i = 0; i < n; i++) {
            long ans=a[i][1]-a[i][0]; // 可减少的
            if(ans<sum){
                arr[i]=a[i][0];
                sum-=ans;
            }else{
                arr[i]=a[i][1]-sum;
                sum=0;
            }
        }

        long summ=0;
        for(int i=0;i<n;i++){
            summ+=arr[i];
            if(arr[i]<a[i][0]||arr[i]>a[i][1]){
                dduoln("No");
                return;
            }
        }

        if(summ!=0){
            dduoln("No");
            return;
        }

        dduoln("Yes");
        for (int i = 0; i < n; i++) {
            dduo(arr[i]+" ");
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