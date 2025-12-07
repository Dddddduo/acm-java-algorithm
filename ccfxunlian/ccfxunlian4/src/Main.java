// https://github.com/Dddddduo/acm-java-algorithm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
    static final int MOD = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static long[] f;

    private static void solve() throws IOException {
        int a = sc.nextInt();
        int[] b = new int[a];
        int[] c = new int[a + 1];
        for (int i = 0; i < a; i++) {
            b[i] = sc.nextInt();
            c[b[i]] = i;
        }

        int[] d = new int[a];
        int[] e = new int[a];
        Arrays.fill(d, -1);
        Arrays.fill(e, -1);

        List<Integer> st = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            while (!st.isEmpty() && b[st.get(st.size() - 1)] < b[i]) {
                st.remove(st.size() - 1);
            }
            if (!st.isEmpty()) {
                d[i] = st.get(st.size() - 1);
            }
            st.add(i);
        }

        st.clear();
        for (int i = a - 1; i >= 0; i--) {
            while (!st.isEmpty() && b[st.get(st.size() - 1)] < b[i]) {
                st.remove(st.size() - 1);
            }
            if (!st.isEmpty()) {
                e[i] = st.get(st.size() - 1);
            }
            st.add(i);
        }

        precomputeInverse(a);

        long[] g = new long[a];
        long[] h = new long[a];
        long[] i = new long[a];
        int[] j = new int[a];
        int[] k = new int[a];

        for (int m = a; m >= 1; m--) {
            int u = c[m];
            if (d[u] != -1) {
                j[u] = j[d[u]] + 1;
                h[u] = (h[d[u]] + g[d[u]]) % MOD;
            } else {
                j[u] = 0;
                h[u] = 0;
            }
            if (e[u] != -1) {
                k[u] = k[e[u]] + 1;
                i[u] = (i[e[u]] + g[e[u]]) % MOD;
            } else {
                k[u] = 0;
                i[u] = 0;
            }
            int t = j[u] + k[u];
            if (t == 0) {
                g[u] = 0;
            } else {
                long s = (h[u] + i[u]) % MOD;
                long term = s * f[t] % MOD;
                g[u] = (1 + term) % MOD;
            }
        }

        for (int ii = 0; ii < a; ii++) {
            sc.print(g[ii]+" ");
        }
        sc.println();
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

    static void precomputeInverse(int a) {
        f = new long[a + 1];
        f[1] = 1;
        for (int i = 2; i <= a; i++) {
            f[i] = (MOD - (MOD / i) * f[(int)(MOD % i)] % MOD) % MOD;
        }
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