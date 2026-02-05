// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner sc = new IoScanner();
//    private static final long mod = (long) (1e9 + 7);
//    private static final long mod = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = s.toCharArray();
        }

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        // 有多少个联通块
        boolean[][] visit = new boolean[n][m];
        int cnt0 = 0, cnt1 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    char ch = arr[i][j];
                    // BFS
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dr[d], ny = y + dc[d];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && arr[nx][ny] == ch) {
                                visit[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                    if (ch == '0') cnt0++;
                    else cnt1++;
                }
            }
        }

        char[][] result = new char[n][m];
        for (int i1 = 0; i1 < n; i1++) {
            for (int i = 0; i < m; i++) {
                result[i1][i] = 'N';
            }
        }

        // 相邻的格子如果有颜色相同，直接为构成一个回文串
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int ni = i + dr[k], nj = j + dc[k];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                    if (result[i][j] == 'Y' && result[ni][nj] == 'Y') continue;
                    if (arr[i][j] == arr[ni][nj]) {
                        result[i][j] = 'Y';
                        result[ni][nj] = 'Y';
                    }
                }
            }
        }

        // 检查每个X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(result[i][j] == 'Y') continue;
                if(arr[i][j] == '1' && cnt1!=1) result[i][j] = 'Y';
                else if(arr[i][j] == '0' && cnt0!=1) result[i][j] = 'Y';
            }
        }

        for (int i1 = 0; i1 < n; i1++) {
            for (int i = 0; i < m; i++) {
                sc.print(result[i1][i]);
            }
            sc.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
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