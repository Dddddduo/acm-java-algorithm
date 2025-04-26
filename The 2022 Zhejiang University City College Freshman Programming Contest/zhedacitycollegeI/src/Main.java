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
        int a=sc.nextInt(); // a个1
        int b=sc.nextInt(); // b个0

        int c=sc.nextInt(); // c个1

        if(c>a+b-1){
            dduoln("-1");
            return;
        }

        if(a==0){
            if(c!=0){
                dduoln(-1);
            }else {
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < b; i++) {
                    sb.append('0');
                }
                dduoln(sb);
                dduoln(sb);
            }
            return;
        }else if(b==0){
            if(c!=0){
                dduoln(-1);
            }else {
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < a; i++) {
                    sb.append('1');
                }
                dduoln(sb);
                dduoln(sb);
            }
            return;
        }

        StringBuilder sb1=new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb1.append('1');
        }
        for (int i = 0; i < b; i++) {
            sb1.append('0');
        }

        StringBuilder sb2=new StringBuilder("");

        // 01110001
        if(c>=a-1&&c<=a+b-1){
            sb2.append('0');
            for (int i = 0; i < a - 1; i++) {
                sb2.append('1');
            }
            for (int i = 0; i < c - b + 1; i++) {
                sb2.append('0');
            }
            sb2.append('1');
            for (int i = 0; i < a+b-2-(a-1)-(c-b+1);  i++) {
                sb2.append('0');
            }
        } else if(c<a-1){   // 111010000
            for (int i = 0; i < a - 1; i++) {
                sb2.append('1');
            }
            for (int i = 0; i < c; i++) {
                sb2.append('0');
            }
            sb2.append('1');
            for (int i = 0; i < b - c; i++) {
                sb2.append('0');
            }

        }

//        dduoln("123");
        dduoln(sb1);
        dduoln(sb2);
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