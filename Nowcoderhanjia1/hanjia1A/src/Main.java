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
    private static final int MOD = (int) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

//    // 数字0：亮1、2、3、5、6、7
//    static int light0[] = new int[]{0,1,1,1,0,1,1,1};
//    // 数字1：亮3、6
//    static int light1[] = new int[]{0,0,0,1,0,0,1,0};
//    // 数字2：亮1、3、4、5、7
//    static int light2[] = new int[]{0,1,0,1,1,1,0,1};
//    // 数字3：亮1、3、4、6、7
//    static int light3[] = new int[]{0,1,0,1,1,0,1,1};
//    // 数字4：亮2、3、4、6
//    static int light4[] = new int[]{0,0,1,1,1,0,1,0};
//    // 数字5：亮1、2、4、6、7
//    static int light5[] = new int[]{0,1,1,0,1,0,1,1};
//    // 数字6：亮1、2、4、5、6、7
//    static int light6[] = new int[]{0,1,1,0,1,1,1,1};
//    // 数字7：亮1、3、6
//    static int light7[] = new int[]{0,1,0,1,0,0,1,0};
//    // 数字8：亮1、2、3、4、5、6、7、8
//    static int light8[] = new int[]{0,1,1,1,1,1,1,1};
//    // 数字9：亮1、2、3、4、6、7
//    static int light9[] = new int[]{0,1,1,1,1,0,1,1};

    static int[][] light = {
            {0, 1, 1, 1, 0, 1, 1, 1},  // light[0] 数字0：亮1、2、3、5、6、7
            {0, 0, 0, 1, 0, 0, 1, 0},  // light[1] 数字1：亮3、6
            {0, 1, 0, 1, 1, 1, 0, 1},  // light[2] 数字2：亮1、3、4、5、7
            {0, 1, 0, 1, 1, 0, 1, 1},  // light[3] 数字3：亮1、3、4、6、7
            {0, 0, 1, 1, 1, 0, 1, 0},  // light[4] 数字4：亮2、3、4、6
            {0, 1, 1, 0, 1, 0, 1, 1},  // light[5] 数字5：亮1、2、4、6、7
            {0, 1, 1, 0, 1, 1, 1, 1},  // light[6] 数字6：亮1、2、4、5、6、7
            {0, 1, 0, 1, 0, 0, 1, 0},  // light[7] 数字7：亮1、3、6
            {0, 1, 1, 1, 1, 1, 1, 1},  // light[8] 数字8：亮1、2、3、4、5、6、7、8
            {0, 1, 1, 1, 1, 0, 1, 1}   // light[9] 数字9：亮1、2、3、4、6、7
    };

    // 每个灯管亮的概率
    static int x[];

    // 每个数字亮的概率
    static long number[];

    private static void solve() throws IOException {

        int c = sc.nextInt();

        // 每个灯管亮的概率
        x = new int[8];
        for (int i = 1; i <= 7; i++) x[i] = sc.nextInt();

        // 每个数字亮的概率
        number = new long[10];
        for (int i1 = 0; i1 <= 9; i1++) { //数字
            long ans = 1;
            for (int i = 1; i <= 7; i++) { // 灯管
                if (light[i1][i] == 1) {
                    // 亮
                    ans = ans * (x[i] % MOD) % MOD;
                } else {
                    // 不亮
                    ans = ans * ((100 - x[i]) % MOD) % MOD;
                }
            }
            ans = ans * inv100_7 % MOD;
            number[i1] = ans;
        }

        long result = 0;

        for (int num1 = 0; num1 <= c; num1++) {
            int num2 = c - num1;
            // 求按出num1和num2的概率
            long temp = 1;

            // 每一位
            int a1 = num1 / 1000;
            int a2 = num1 / 100 % 10;
            int a3 = num1 / 10 % 10;
            int a4 = num1 % 10;

            int b1 = num2 / 1000;
            int b2 = num2 / 100 % 10;
            int b3 = num2 / 10 % 10;
            int b4 = num2 % 10;

            temp = temp * number[a1] % MOD;
            temp = temp * number[a2] % MOD;
            temp = temp * number[a3] % MOD;
            temp = temp * number[a4] % MOD;
            temp = temp * number[b1] % MOD;
            temp = temp * number[b2] % MOD;
            temp = temp * number[b3] % MOD;
            temp = temp * number[b4] % MOD;

            result = (result + temp) % MOD;
        }

        sc.println(result);
    }

    // 计算 q 在模 MOD 下的逆元
    public static int modInverse(int q) {
        return pow(q, MOD - 2, MOD);
    }

    // 快速幂取模函数
    public static int pow(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (int) ((long) result * base % mod);
            }
            exponent = exponent >> 1;
            base = (int) ((long) base * base % mod);
        }
        return result;
    }

    // 计算分数取模结果
    public static int calculateFractionResult(int p, int q) {
        // 计算 q 在模 MOD 下的逆元
        int qInv = modInverse(q);
        // 计算 p 乘以 q 的逆元并对 MOD 取模
        return (int) ((long) p * qInv % MOD);
    }

    private static long inv100_7;

    static {
        long pow100_7 = 1;
        for (int i = 0; i < 7; i++) {
            pow100_7 = pow100_7 * 100 % MOD;
        }
        inv100_7 = pow((int) pow100_7, MOD - 2, MOD);
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