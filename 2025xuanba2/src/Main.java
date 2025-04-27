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
        // 初始生命值
        long h1 = sc.nextLong();
        // 成长生命值
        long h2 = sc.nextLong();

        int m=sc.nextInt();

        // 心之钢使用时间
        long time[]=new long[6];
        time[1]=-1;
        time[2]=-1;
        time[3]=-1;
        time[4]=-1;
        time[5]=-1;

        for (int i = 0; i < m; i++) {
            String str=sc.next();
            long t=getTime(str); // 当前时间
            int o=sc.nextInt();
            if(o==1){ // 购买
                h1+=800;
                time[1]=t;
                time[2]=t;
                time[3]=t;
                time[4]=t;
                time[5]=t;
            }else if(o==2){ // 升级
                h1+=h2;
            }else if(o==3){ // 攻击
                int k=sc.nextInt();
                long anst=time[k];
                if(anst!=-1&&t>=anst){
                    h1+=(int)((125+0.06*(double) h1)*(0.1));
                    time[k]=t+30;
                }
            }
        }
        dduoln(h1);

    }

    private static long getTime(String str){
        String[] split = str.split(":");
        return Long.parseLong(split[0])*60+Long.parseLong(split[1]);
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