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
 * https://codeforces.com/contest/2107/problem/C
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

        // 最大子数组和
        long k=sc.nextLong();

        String str=sc.next();

        long arr[]=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            // 表示的是缺失部分
            if(str.charAt(i)=='0'){
                list.add(i);
                arr[i]=Integer.MIN_VALUE;
            }
        }

        // 找出当前最大值
        long max=Integer.MIN_VALUE;

        // 记录当前数值
        long ans=0;

        for (int i = 0; i < n; i++) {
            if(ans+arr[i]>=0){
                ans+=arr[i];
            }else if(ans+arr[i]<=0){
                ans=0;
            }
            max=Math.max(max,ans);
        }

        if(max>k){
            dduoln("No");
            return;
        }

        if(max!=k&&list.size()==0){
            dduoln("No");
            return;
        }

        if(max==k&&list.size()==0){
            dduoln("Yes");
            for (long l : arr) {
                dduo(l+" ");
            }
            dduoln();
            return;
        }

        dduoln("Yes");
//        dduoln(max);

        long qian=0;
        long hou=0;

        // 第一个索引
        Integer i1 = list.get(0);

        long a=0;
        for(int i=i1-1;i>=0;i--){
            a+=arr[i];
            qian=Math.max(a,qian);
        }

        a=0;
        for(int i=i1+1;i<=n-1;i++){
            a+=arr[i];
            hou=Math.max(a,hou);
        }

        long maxvalue=qian+hou;
        arr[i1]=(long) k-(long) maxvalue;

        for (long l : arr) {
            dduo(l+" ");
        }
        dduoln();
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