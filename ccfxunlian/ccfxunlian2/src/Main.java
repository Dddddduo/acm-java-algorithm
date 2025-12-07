// https://github.com/Dddddduo/acm-java-algorithm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
    //    static final int mod = (int) (1e9 + 7);
    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {

        int n = sc.nextInt();
        long result = sc.nextLong();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // you计算出最左边的位置
        // zuo计算出相对于最左边的位置的偏移量
        long temp = 0;
        long you = 0;
        for (int i = 0; i < n; i++) {
            if ((i+1) % 2 == 1) {
                // 奇数 <<
                temp += arr[i];
            } else {
                // 偶数 >>
                temp -= arr[i];
            }
            you = Math.min(temp, you);
        }

        you *= -1;
        if (you >= 40) {
            sc.println("0");
            return;
        }

        // 右移
        result = result >> you;
        if (result == 0) {
            sc.println("0");
            return;
        }

        // 左移
        result = result % mod;
        long zuo = temp + you;
        result = result * fastPowerMod(2, zuo, mod) % mod;
        sc.println(result);

    }

    /**
     * 快速幂模：(base^exponent) % mod
     *
     * @param base     底数
     * @param exponent 指数（必须非负）
     * @param mod      模数（必须为正）
     * @return 结果
     */
    public static long fastPowerMod(long base, long exponent, long mod) {
        long result = 1 % mod; // 处理mod=1的情况
        base = (base % mod + mod) % mod; // 确保base为正数
        while (exponent > 0) {
            if ((exponent & 1) != 0) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
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

    public void println(int a) throws IOException {
        print(a);
        println();
    }

    public void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException {
        print(a);
        println();
    }

    public void print(String a) throws IOException {
        bw.write(a);
    }

    public void println(long a) throws IOException {
        print(a);
        println();
    }

    public void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException {
        print(a);
        println();
    }

    public void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException {
        print(a);
        println();
    }

    public void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}