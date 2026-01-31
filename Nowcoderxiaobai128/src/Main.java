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
        int n = Integer.parseInt(sc.nextLong() + "");
        long[] arr = new long[n];
        HashSet<Long> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            visited.add(arr[i]);
        }

        if (visited.size() == 1) {
            sc.println((long) n / 2);
            return;
        }

        Arrays.sort(arr);

        long cnt = Long.MAX_VALUE;

        if (n / 2 % 2 == 1) {
            long mid1 = arr[0];
            if (n != 2) mid1 = arr[n / 2 / 2];
            long mid2 = arr[n - 1];
            if (n != 2) mid2 = arr[n - n / 2 / 2 - 1];
            for(long i=mid1-10;i<mid1+10;i++){
                for(long j=mid2-10;j<mid2+10;j++){
                    if(i==j)continue;
                    long temp=0;
                    for (int i1 = 0; i1 < n / 2; i1++) {
                        temp+= Math.abs(arr[i1] - i);
                    }
                    for (int i1 = n / 2; i1 < n; i1++) {
                        temp+= Math.abs(arr[i1] - j);
                    }
                    cnt=Math.min(cnt,temp);
                }
            }
            sc.println(cnt);
        } else {
            long mid1 = (arr[n / 2 / 2 - 1] + arr[n / 2 / 2]) / 2;
            long mid2 = arr[n - 1];
            if (n != 2) mid2 = (arr[n - n / 2 / 2 - 1] + arr[n - n / 2 / 2]) / 2;
            for(long i=mid1-10;i<mid1+10;i++){
                for(long j=mid2-10;j<mid2+10;j++){
                    if(i==j)continue;
                    long temp=0;
                    for (int i1 = 0; i1 < n / 2; i1++) {
                        temp+= Math.abs(arr[i1] - i);
                    }
                    for (int i1 = n / 2; i1 < n; i1++) {
                        temp+= Math.abs(arr[i1] - j);
                    }
                    cnt=Math.min(cnt,temp);
                }
            }
//            for (int i1 = 0; i1 < n / 2; i1++) {
//                cnt += Math.abs(arr[i1] - mid1);
//            }
//            for (int i1 = n / 2; i1 < n; i1++) {
//                cnt += Math.abs(arr[i1] - mid2);
//            }
            sc.println(cnt);
        }
    }

    /**
     8
     2
     3 3
     2
     1 2
     4
     1 1 1 1
     4
     1 2 3 4
     6
     1 1 1 1 1 1
     6
     1 2 3 4 5 6
     10
     10 20 30 40 50 60 70 80 90 100
     12
     10 20 30 40 50 60 70 80 90 100 110 120

     6
     6
     1 1 1 1 1 2
     6
     1 1 1 1 2 2
     6
     1 1 1 2 2 2
     6
     1 1 2 2 2 2
     6
     1 2 2 2 2 2
     6
     2 2 2 2 2 2
     */

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