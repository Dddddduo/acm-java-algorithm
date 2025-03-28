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
 * https://ac.nowcoder.com/acm/contest/105825/E
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
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        Arrays.fill(dp,-1);

        dp[0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (dp[j - 1] != -1 && check(arr, j, i)) {
                    dp[i] = Math.max(dp[i],  dp[j - 1] + 1);
                }
            }
        }

        dduoln(dp[n]);

    }

    public static boolean check(int[] arr, int left, int right) {
        if (right - left + 1 < 2) {
            return false;
        }
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();

        for (int i = left; i <= right; i++) {
            List<Integer> factors = primeFactors(arr[i]);
            for (int factor : factors) {
                primeToIndices.computeIfAbsent(factor,  k -> new ArrayList<>()).add(i);
            }
        }

        for (int i = left; i <= right; i++) {
            boolean judge = false;
            List<Integer> factors = primeFactors(arr[i]);
            for (int factor : factors) {
                List<Integer> indices = primeToIndices.get(factor);
                for (int index : indices) {
                    if (index != i) {
                        judge = true;
                        break;
                    }
                }
                if (judge) {
                    break;
                }
            }
            if (!judge) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> primeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                if (!factors.contains(i))  {
                    factors.add(i);
                }
                num /= i;
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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