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
 * https://acm.hdu.edu.cn/contest/problem?cid=1153&pid=1005
 */

// xixi西
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
        double p=sc.nextDouble(); // 当前价格
        int n=sc.nextInt(); // 优惠卷
        int k=sc.nextInt(); // 上限

        double arr[][]=new double[n][2];

        int cnt0=0; // 打折
        int cnt1=0; // 优惠

        for (int i = 0; i < n; i++) {
            arr[i][0]=sc.nextDouble();
            arr[i][1]=sc.nextDouble();
            if(arr[i][0]==0){
                cnt0++;
            }else{
                cnt1++;
            }
        }

        Double arr0[]=new Double[cnt0];
        Double arr1[]=new Double[cnt1];

        int ii=0;
        int jj=0;
        for (int i = 0; i < n; i++) {
            if(arr[i][0]==0){
                arr0[ii]=arr[i][1];
                ii++;
            }else{
                arr1[jj]=arr[i][1];
                jj++;
            }
        }

        Arrays.sort(arr0);
        Arrays.sort(arr1,((o1, o2) -> Double.compare(o2,o1)));

        double pre0[]=new double[cnt0+1];
        double pre1[]=new double[cnt1+1];

        pre0[0]= 1.0;
        for(int i=1;i<arr0.length+1;i++){
            pre0[i]=arr0[i-1]*pre0[i-1]*0.1;
        }

        for(int i=1;i<arr1.length+1;i++){
            pre1[i]=arr1[i-1]+pre1[i-1];
        }

//        for (Double v : pre0) {
//            System.out.println(v);
//        }
//        for (Double v : pre1) {
//            System.out.println(v);
//        }

        int i=0;
        double cnt=Integer.MAX_VALUE;
        while(i<=k){
            int j=(k-i);
//            System.out.println(j);
            if(j<pre1.length&&i<pre0.length) {
//                System.out.println(pre0[i]+" "+pre1[j]);
//                System.out.println(p*pre0[i]-pre1[j]);
                cnt=Math.min(cnt,p*pre0[i]-pre1[j]);
            }
            i++;
        }

        System.out.println(String.format("%.2f",cnt<=0?0:cnt));
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