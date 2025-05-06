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
//    static final int mod = (int) (1e9 + 7);
    static final int mod = (int) (998244353);

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
        long arr[]=new long[n*2+10];
        long cnt[]=new long[(int) (2e5+10)];
        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= 2 * n; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] != -1) {
                list.add(arr[i]);
            }
        }
        Collections.sort(list);

        long fenzi = 1;
        long fenmu = 1;

        int now = 0;
        int sum = 0;
        for (int i = 1; i <= 2 * n; i++) {
            long x = arr[i];
            if (x != -1) {
                sum++;
                cnt[(int) x]++;
            } else {
                long t = list.get(now);
                if (cnt[(int) t] == 0) {
                    fenzi = 0;
                    break;
                } else {
                    fenzi *= cnt[(int) t];
                    fenmu *= sum ;
                    fenzi%=mod;fenmu%=mod;
                    cnt[(int) t]--;
                    sum--;
                }
                now++;
            }
        }
        dduoln(fenzi+" "+fenmu);
        dduoln(fengshumod(fenzi,fenmu));
    }

    /**
        4
        2
        1 2 -1 -1
        3
        1 2 -1 -1 1 -1
        4
        1 -1 2 -1 3 -1 4 -1
        3
        1 2 3 -1 2 -1
     */

    // 分数取模
    public static long fengshumod(long fenzi,long fenmu) {
        return fenzi%mod*pow(fenmu,mod-2,mod)%mod;
    }

    // 计算 q 在模 MOD 下的逆元
    public static long modInverse(long q) {
        return pow(q, mod - 2, mod);
    }

    // 快速幂取模函数
    public static long pow(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result =(long)((long) result * base % mod);
            }
            exponent = exponent >> 1;
            base = (long) ((long) base * base % mod);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
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