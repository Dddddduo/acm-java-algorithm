import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static long INF_TIME = 4000000000000000000L;
    static int INF_COST = 2000000000;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    static String s;
    static List<String> g = new ArrayList<>();
    static int[][] no;
    static Pair[][] d;

    static class Pair {
        int c;
        long t;
        Pair(int c, long t) {
            this.c = c;
            this.t = t;
        }
    }

    static int gd(char ch) {
        if (ch == 'U') return 0;
        if (ch == 'D') return 1;
        if (ch == 'L') return 2;
        if (ch == 'R') return 3;
        return -1;
    }

    private static void solve() throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.next();
        int sl = s.length();
        for (int i = 0; i < n; i++) {
            g.add(sc.next());
        }

        no = new int[sl][4];
        for (int i = 0; i < sl; i++) {
            Arrays.fill(no[i], -1);
        }
        int[] lp = {-1, -1, -1, -1};
        for (int i = 2 * sl - 1; i >= 0; i--) {
            int cc = gd(s.charAt(i % sl));
            if (cc != -1) {
                lp[cc] = i;
            }
            if (i < sl) {
                for (int k = 0; k < 4; k++) {
                    if (lp[k] != -1) {
                        no[i][k] = lp[k] - i;
                    } else {
                        no[i][k] = -1;
                    }
                }
            }
        }

        d = new Pair[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = new Pair(INF_COST, INF_TIME);
            }
        }

        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> {
            int c1 = (int) a[0];
            int c2 = (int) b[0];
            if (c1 != c2) return Integer.compare(c1, c2);
            long t1 = (long) a[1];
            long t2 = (long) b[1];
            return Long.compare(t1, t2);
        });

        d[0][0] = new Pair(0, 0);
        pq.add(new Object[]{0, 0L, 0, 0});

        while (!pq.isEmpty()) {
            Object[] cur = pq.poll();
            int c = (int) cur[0];
            long t = (long) cur[1];
            int r = (int) cur[2];
            int col = (int) cur[3];

            if (c > d[r][col].c || (c == d[r][col].c && t > d[r][col].t)) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = col + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || g.get(nr).charAt(nc) == '#') {
                    continue;
                }

                int nc1 = c + 1;
                long nt1 = t + 1;
                if (nc1 < d[nr][nc].c || (nc1 == d[nr][nc].c && nt1 < d[nr][nc].t)) {
                    d[nr][nc] = new Pair(nc1, nt1);
                    pq.add(new Object[]{nc1, nt1, nr, nc});
                }

                int w = no[(int) (t % sl)][k];
                if (w != -1) {
                    int nc2 = c;
                    long nt2 = t + w + 1;
                    if (nc2 < d[nr][nc].c || (nc2 == d[nr][nc].c && nt2 < d[nr][nc].t)) {
                        d[nr][nc] = new Pair(nc2, nt2);
                        pq.add(new Object[]{nc2, nt2, nr, nc});
                    }
                }
            }
        }

        sc.println(d[n-1][m-1].c + " " + d[n-1][m-1].t);
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

    public void println(int a) throws IOException{
        print(a);
        println();
    }

    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException{
        print(a);
        println();
    }

    public void print(String a) throws IOException{
        bw.write(a);
    }

    public void println(long a) throws IOException{
        print(a);
        println();
    }

    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException{
        print(a);
        println();
    }

    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException{
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException{
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException{
        print(a);
        println();
    }

    public void println() throws IOException{
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}