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
 * https://codeforces.com/problemset/problem/2004/D
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


    static ArrayList<Integer> BG = new ArrayList<>();
    static ArrayList<Integer> BR = new ArrayList<>();
    static ArrayList<Integer> BY = new ArrayList<>();
    static ArrayList<Integer> GR = new ArrayList<>();
    static ArrayList<Integer> GY = new ArrayList<>();
    static ArrayList<Integer> RY = new ArrayList<>();
    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();
        int q = sc.nextInt();

        Map<String, List<Integer>> k = new HashMap<>();
        String[] a = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.next();
            k.computeIfAbsent(a[i],  key -> new ArrayList<>()).add(i);
        }

        for (int i = 1; i <= q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }

            if (a[x].charAt(0) == a[y].charAt(0) || a[x].charAt(0) == a[y].charAt(1) ||
                    a[x].charAt(1) == a[y].charAt(1) || a[x].charAt(1) == a[y].charAt(0)) {
                    dduoln(Math.abs(x  - y));
            } else {
                int ans = (int) (1e9 + 10);
                for (Map.Entry<String, List<Integer>> entry : k.entrySet())  {
                    String s = entry.getKey();
                    if (!s.equals(a[x])  && !s.equals(a[y]))  {
                        List<Integer> list = entry.getValue();
                        int f = binarySearch(list, x);
                        if (f != list.size())  {
                            int nex1 = list.get(f);
                            int nex2 = 0;
                            if (f != 0) {
                                nex2 = list.get(f  - 1);
                            }
                            if (nex1 > y) {
                                ans = Math.min(ans,  2 * nex1 - x - y);
                            } else {
                                ans = Math.min(ans,  y - x);
                            }
                            if (nex2 != 0) {
                                ans = Math.min(ans,  x + y - 2 * nex2);
                            }
                        } else {
                            int nex = list.get(list.size()  - 1);
                            ans = Math.min(x  + y - 2 * nex, ans);
                        }
                    }
                }
                if (ans > (int) (1e9 / 2)) {
                    dduoln(-1);
                } else {
                    dduoln(ans);
                }
            }
        }
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)  < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
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