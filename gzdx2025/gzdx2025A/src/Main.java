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
 * https://ac.nowcoder.com/acm/contest/104870#question
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
        int m=sc.nextInt();
        char arr[][]=new char[n][m];
        for (int i = 0; i < n; i++) {
            String str=sc.next();
            arr[i]=str.toCharArray();
        }

        StringBuilder sb=new StringBuilder();

        boolean judge=false;
        for (int i = 0; i < n; i++) {
            if(judge==false){
                for (int i1 = 0; i1 < m; i1++) {
                    sb.append(arr[i][i1]);
                }
                judge=true;
                continue;
            }
            if(judge==true){
                for (int m1 = m; m1 > 0; m1--) {
                    sb.append(arr[i][m1-1]);
                }
                judge=false;
                continue;
            }
        }

        String str = sb.toString();
        char[] a = str.toCharArray();
//        System.out.println(a.length);
        long cnt=0;
        for (int i = 0; i < a.length-3; i++) {
            if(a[i]=='G'&&a[i+1]=='Z'&&a[i+2]=='H'&&a[i+3]=='U'){
                cnt++;
            }
        }

        System.out.println(cnt);

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