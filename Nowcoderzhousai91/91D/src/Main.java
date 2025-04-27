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

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo

        int t=sc.nextInt();
        for (int i1 = 0; i1 < t; i1++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                String row = sc.next();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = row.charAt(j) - '0';
                }
            }

            boolean allZero = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 0) {
                        allZero = false;
                        break;
                    }
                }
                if (!allZero) {
                    break;
                }
            }
            if (allZero) {
                System.out.println("YES");
                continue;
            }

            ArrayList<Integer> onesRows = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boolean allOne = true;
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 1) {
                        allOne = false;
                        break;
                    }
                }
                if (allOne) {
                    onesRows.add(i);
                }
            }
            if (onesRows.size() == 2) {
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if (onesRows.contains(i)) {
                        continue;
                    }
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] != 0) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) {
                        break;
                    }
                }
                if (valid) {
                   dduoln("YES");
                    continue;
                }
            }

            java.util.ArrayList<Integer> onesCols = new java.util.ArrayList<>();
            for (int j = 0; j < m; j++) {
                boolean allOne = true;
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] != 1) {
                        allOne = false;
                        break;
                    }
                }
                if (allOne) {
                    onesCols.add(j);
                }
            }
            if (onesCols.size() == 2) {
                boolean valid = true;
                for (int j = 0; j < m; j++) {
                    if (onesCols.contains(j)) {
                        continue;
                    }
                    for (int i = 0; i < n; i++) {
                        if (grid[i][j] != 0) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) {
                        break;
                    }
                }
                if (valid) {
                    dduoln("YES");
                    continue;
                }
            }

            boolean found = false;
            for (int r = 0; r < n; r++) {
                int zeroCount = 0;
                for (int j = 0; j < m; j++) {
                    if (grid[r][j] == 0) {
                        zeroCount++;
                    }
                }
                if (zeroCount != 1) {
                    continue;
                }
                int c = -1;
                for (int j = 0; j < m; j++) {
                    if (grid[r][j] == 0) {
                        c = j;
                        break;
                    }
                }
                int zeroCol = 0;
                for (int i = 0; i < n; i++) {
                    if (grid[i][c] == 0) {
                        zeroCol++;
                    }
                }
                if (zeroCol != 1) {
                    continue;
                }
                if (grid[r][c] != 0) {
                    continue;
                }
                boolean validCol = true;
                for (int i = 0; i < n; i++) {
                    if (i == r) {
                        continue;
                    }
                    if (grid[i][c] != 1) {
                        validCol = false;
                        break;
                    }
                }
                if (!validCol) {
                    continue;
                }
                boolean validAll = true;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i == r && j == c) {
                            if (grid[i][j] != 0) {
                                validAll = false;
                                break;
                            }
                        } else if (i == r || j == c) {
                            if (grid[i][j] != 1) {
                                validAll = false;
                                break;
                            }
                        } else {
                            if (grid[i][j] != 0) {
                                validAll = false;
                                break;
                            }
                        }
                    }
                    if (!validAll) {
                        break;
                    }
                }
                if (validAll) {
                    found = true;
                    break;
                }
            }
            if (found) {
                dduoln("YES");
                continue;
            }

            dduoln("NO");
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