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
 * https://codeforces.com/problemset/problem/2020/C
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
//        long b=sc.nextLong();
//        long c=sc.nextLong();
//        long d=sc.nextLong();
//
//        for(long a=0;a<=10000;a++){
//            long l = (a | b);
//            long r = (a & c);
//            if( ( l-r )==d){
//                dduoln(a);
////                return;
//            }
//        }
//        dduoln("-1");
//
//        long a=d-c;
//        if(a>=0){
//            long l = a | c;
//            long r = a & c;
//            if( ( l-r )==d){
//                dduoln(a);
//                return;
//            }
//        }
//
//        a=d+c;
//        if(a>=0){
//            long l = a | c;
//            long r = a & c;
//            dduoln(a+" "+l+" "+c);
//            if( ( l-r )==d){
//                dduoln(a);
//                return;
//            }
//        }
//
//        dduoln("-1");

        long bbb=sc.nextLong();
        long ccc=sc.nextLong();
        long ddd=sc.nextLong();

        String bb=Long.toBinaryString(bbb);
        String cc=Long.toBinaryString(ccc);
        String dd=Long.toBinaryString(ddd);

        int bChar=bb.length()-1;
        int cChar=cc.length()-1;
        int dChar=dd.length()-1;

        StringBuilder sb=new StringBuilder();

//        dduoln(bChar+" "+cChar+" "+dChar);
//
        while(bChar>=0||cChar>=0||dChar>=0){
//            dduoln("123");
            char b = bChar>=0?  bb.charAt(bChar) : '0' ;
            char c = cChar>=0?  cc.charAt(cChar) : '0' ;
            char d = dChar>=0?  dd.charAt(dChar) : '0' ;
//            dduoln(b+" "+c+" "+d);

            if(b=='0'&&c=='0'&&d=='0'){
                sb.append('0'); // 0
            }else if(b=='0'&&c=='0'&&d=='1'){
                sb.append('1'); // 1
            }else if(b=='0'&&c=='1'&&d=='1'){
                dduoln("-1");
                return;
            }else if(b=='1'&&c=='1'&&d=='1'){
                sb.append('0');
            }else if(b=='1'&&c=='0'&&d=='1'){
                sb.append('0'); //
            }else if(b=='1'&&c=='1'&&d=='0'){
                sb.append('1'); // 1
            }else if(b=='1'&&c=='0'&&d=='0'){
                dduoln("-1");
                return;
            }else if(b=='0'&&c=='1'&&d=='0'){
                sb.append('1'); // 0
            }
//            dduoln(sb);

            bChar--;cChar--;dChar--;
        }

        sb=sb.reverse();
//        System.out.println(sb);
        dduoln(Long.parseLong(sb.toString(),2));
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