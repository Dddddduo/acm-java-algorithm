import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 998244353;
    static final int inv2 = 499122177;
    static IoScanner sc = new IoScanner();
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        long[] pow2 = new long[n];
        pow2[0]  = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long[] powInv2 = new long[n + 2];
        powInv2[0]  = 1;
        for (int i = 1; i <= n + 1; i++) {
            powInv2[i] = (powInv2[i - 1] * inv2) % MOD;
        }

        long[] s = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = (A[i] * pow2[i]) % MOD;
        }

        long[] suffixSum = new long[n + 1];
        suffixSum[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = (s[i] + suffixSum[i + 1]) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long term1 = (long) A[i] * A[i] % MOD;
            if (i == n - 1) {
                ans = (ans + term1) % MOD;
                continue;
            }
            long sumS = suffixSum[i + 1];
            int exponent = i + 1;
            long inv = powInv2[exponent];
            long temp = (sumS * inv) % MOD;
            long term2 = ((long) A[i] * temp) % MOD;
            ans = (ans + term1 + term2) % MOD;
        }

        System.out.println(ans);
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