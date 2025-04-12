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
 * https://codeforces.com/contest/2093/problem/D
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

//    static long result[][];

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n=sc.nextInt(); // 表格是 2^n * 2^n

        long sum= (long) Math.pow(2,n);
//        result =rec(n,)

        int q=sc.nextInt();
        for (int ii = 0; ii < q; ii++) {
            String str=sc.next();
            if(str.equals("->")){
                // 查询数字
                int x=sc.nextInt();
                int y=sc.nextInt();
                long[] result = rec1(n, x, y, 0, sum);
                dduoln(result[0]);
            }else if(str.equals("<-")){
                // 查询所在单元格
//                long num=sc.nextLong();
//                long ans=num%4;
//                if(ans==1){
//
//                }else if(ans==2){
//
//                }else if(ans==3){
//
//                }else if(ans==0){
//
//                }
                long num = sc.nextLong();
                long[] arr = rec2(n, num, 1, 1, sum);
                dduoln(arr[0] + " " + arr[1]);
            }
        }
    }

    public static long[] rec1(long n, long x, long y, long num, long size) {
        // 递归出口
        if (size == 2) {
            if (x == 1 && y == 1) {
                return new long[]{num + 1, 1, 1};
            } else if (x == 2 && y == 2) {
                return new long[]{num + 2, 2, 2};
            } else if (x == 2 && y == 1) {
                return new long[]{num + 3, 2, 1};
            } else if(x==1 && y==2){
                return new long[]{num + 4, 1, 2};
            }
        }
        // 递归函数
        long yiban = size / 2;
        if (x <= yiban && y <= yiban) {
            return rec1(n, x, y, num, yiban);
        } else if (x > yiban && y > yiban) {
            return rec1(n, x - yiban, y - yiban, num + yiban * yiban, yiban);
        } else if (x > yiban && y <= yiban) {
            return rec1(n, x - yiban, y, num + 2 * yiban * yiban, yiban);
        } else {
            return rec1(n, x, y - yiban, num + 3 * yiban * yiban, yiban);
        }

    }

    public static long[] rec2(long n, long num, long x, long y, long size) {
        // 递归出口
        if (size == 2) {
            if (num % 4 == 1) {
                return new long[]{x, y};
            } else if (num % 4 == 2) {
                return new long[]{x + 1, y + 1};
            } else if (num % 4 == 3) {
                return new long[]{x + 1, y};
            } else {
                return new long[]{x, y + 1};
            }
        }

        // 递归函数
        long yiban = size / 2;
        long area = yiban * yiban;
        if (num <= area) {
            // 左上
            return rec2(n, num, x, y, yiban);
        } else if (num <= 2 * area) {
            // 右下
            return rec2(n, num - area, x + yiban, y + yiban, yiban);
        } else if (num <= 3 * area) {
            // 左下
            return rec2(n, num - 2 * area, x + yiban, y, yiban);
        } else {
            // 右上
            return rec2(n, num - 3 * area, x, y + yiban, yiban);
        }
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