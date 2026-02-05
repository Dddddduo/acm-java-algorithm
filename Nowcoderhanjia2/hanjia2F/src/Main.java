// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner sc = new IoScanner();
//    private static final long mod = (long) (1e9 + 7);
//    private static final long mod = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    private static void solve() throws IOException {

        long n=sc.nextInt();

//        sc.println((20^30));
//        sc.println((40^50));

//        long max=Long.MAX_VALUE;
//        long x=0,y=0;
//        for(int i=1;i<=1000;i++) {
//            for (int j = 1; j <= 1000; j++) {
//                if (i != j && gcd(i, j) == n) {
//                    long xor = (i ^ j);
//                    if (xor <= max) {
//                        max = xor;
//                        x = i;
//                        y = j;
//                    }
//                }
//            }
//        }

//        int cnt=0;
//        for(int i=0;i<64;i++){
//            if( ((n>>i)&1) ==1){
//                cnt++;
//            }
//        }
//        sc.println(n+" "+x+" "+y);
//        sc.println("多少个1:"+cnt);

//        sc.println( (n*(1<<cnt))+" "+(n*((1<<cnt)+1)) );


        for(int i=0;i<64;i++){
            if(((n<<i)&n)==0){
                long x=n<<i;
                long y=x+n;
                sc.println(x+" "+y);
                return;
            }
        }

    }

    /**
     input
     10
     1
     2
     3
     4
     5
     6
     7
     8
     9
     10

     output
     2 3
     4 6
     12 15
     8 12
     10 15
     24 30
     56 63
     16 24
     18 27
     20 30

     input
     5
     50
     60
     70
     100
     200
     output
     200 250
     60 120
     280 350
     400 500
     800 1000


     input
     5
     132
     133
     134
     135
     136
     137
     output
     264 396
     266 399
     536 670
     270 405
     272 408
     */

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

    private static <T> void dduo(T t) {
        System.out.print(t);
    }

    private static <T> void dduoln() {
        System.out.println("");
    }

    private static <T> void dduoln(T t) {
        System.out.println(t);
    }

}

class IoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public IoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    protected String nextLine() throws IOException {
        return bf.readLine();
    }

    protected String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    protected char nextChar() throws IOException {
        return next().charAt(0);
    }

    protected int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    protected long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    protected double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    protected float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    protected BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    protected BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }

    protected void println(int a) throws IOException {
        print(a);
        println();
    }

    protected void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(String a) throws IOException {
        print(a);
        println();
    }

    protected void print(String a) throws IOException {
        bw.write(a);
    }

    protected void println(long a) throws IOException {
        print(a);
        println();
    }

    protected void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(double a) throws IOException {
        print(a);
        println();
    }

    protected void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    protected void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    protected void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(char a) throws IOException {
        print(a);
        println();
    }

    protected void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    protected void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    protected boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}