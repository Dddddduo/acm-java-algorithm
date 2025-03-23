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
 * 牛客周赛 Round 86 F
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
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int max = a[i];

            if (max >= min) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                list.add(a[j]);
            }
            if (list.isEmpty()) {
                continue;
            }
            int sum = 0;
            for (int x : list) {
                sum += x;
            }
            if (sum <= max) {
                continue;
            }
            boolean[] dp = new boolean[sum + 5];
            dp[0] = true;

            // 当前最大值
            int c = 0;

            for (int x : list) {
                for (int j = c; j >= 0; j--) {
                    if (dp[j] == true) {
                        int newSum = j + x;
                        if (newSum > sum) {
                            continue;
                        }
                        if (dp[newSum] == false) {
                            dp[newSum] = true;
                            if (newSum > c) {
                                c = newSum;
                            }
                        }
                    }
                }
            }

            for (int sumOther = max + 1; sumOther <= c; sumOther++) {
                if (dp[sumOther]) {
                    int perimeter = sumOther + max;
                    if (perimeter < min) {
                        min = perimeter;
                    }
                    break;
                }
            }
        }
        dduoln(min == 2147483647 ? "-1" : min);
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