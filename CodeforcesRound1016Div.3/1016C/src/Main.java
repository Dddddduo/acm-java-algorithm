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
 * https://codeforces.com/contest/2093/problem/C
 */

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
        long n=sc.nextLong();
        int k=sc.nextInt();

//        dduoln(isPrime(11));

        if(n==1&&k==2){
            dduoln("YES");
            return;
        }

        if(isPrime(n)==true&&k==1){
            dduoln("YES");
        }else {
            dduoln("NO");
        }

    }

    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(number);  i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

//    public static boolean isPrime(BigInteger number) {
//        if (number.compareTo(BigInteger.ONE)  <= 0) {
//            return false;
//        }
//        if (number.equals(BigInteger.valueOf(2)))  {
//            return true;
//        }
//        if (number.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))  {
//            return false;
//        }
//        BigInteger limit = number.sqrt();
//        for (BigInteger i = BigInteger.valueOf(3);  i.compareTo(limit)  <= 0; i = i.add(BigInteger.valueOf(2)))  {
//            if (number.mod(i).equals(BigInteger.ZERO))  {
//                return false;
//            }
//        }
//        return true;
//    }

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