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
 * https://codeforces.com/contest/2096/problem/D
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
//        Integer arr[][]=new Integer[n][2];
//        for (int i = 0; i < n; i++) {
//            arr[i][0]=sc.nextInt();
//            arr[i][1]=sc.nextInt();
//        }
//        Arrays.sort(arr,((o1, o2) -> {
//            if(o1[0].equals(o2[0])){
//                return o1[1]-o2[1];
//            }else {
//                return o1[0]-o2[0];
//            }
//        }));
//        for (int i = 0; i < n; i++) {
//            dduoln(arr[i][0]+" "+arr[i][1]);
//        }
//
//        for (int i = 0; i < n-4; i+=4) {
//            int x1=arr[i][0],y1=arr[i][1];
//            int x2=arr[i+1][0],y2=arr[i+1][1];
//            int x3=arr[i+2][0],y3=arr[i+2][1];
//            int x4=arr[i+3][0],y4=arr[i+3][1];
//
//
//        }
        int px=0;int py=0;
        for (int i = 0; i < n; i++) {
            long x=sc.nextLong();
            long y=sc.nextLong();
            px^=x;
            py^=(x+y);
        }
        dduoln(px+" "+(py-px));

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