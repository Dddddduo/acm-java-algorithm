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
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


    static class Element {
        long a;
        long b;
        long c;
        long num;
    }

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {


        // todo
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        Element[] str = new Element[(int) (n + 1)];
        for (int i = 1; i <= n; i++) {
            str[i] = new Element();
        }

        for (int i = 1; i <= n; i++) {
            str[i].a = sc.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            str[i].b = sc.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            str[i].c = sc.nextLong();
            str[i].num = (str[i].b * m - str[i].a) / str[i].c + 1;
        }

        Arrays.sort(str,  1, (int) (n + 1), new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return Long.compare(e1.num,  e2.num);
            }
        });

        for (int i = 1; i <= n; i++) {
            if (k - str[i].num < 0) {
                dduoln(i  - 1);
                return;
            } else {
                k -= str[i].num;
            }
        }

        if (k > 0) {
            dduoln(n);
        }
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