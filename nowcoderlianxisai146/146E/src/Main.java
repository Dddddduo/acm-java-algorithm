import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
    static final int MAX_NM = 100005;
    static List<Integer>[] c = new ArrayList[MAX_NM];
    static List<Integer>[] rc = new ArrayList[MAX_NM];
    static int[] p = new int[MAX_NM];
    static boolean[] s = new boolean[MAX_NM];
    static int[] cir = new int[MAX_NM];

    static {
        for (int i = 0; i < MAX_NM; i++) {
            c[i] = new ArrayList<>();
            rc[i] = new ArrayList<>();
        }
    }

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] g = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                g[i][j] = sc.nextInt();
            }
        }

        if (n > m) {
            int[][] ng = new int[m][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    ng[j][i] = g[i][j];
                }
            }
            g = ng;
            int t = n;
            n = m;
            m = t;
        }

        long ans = 0;
        ArrayList<Integer> dc = new ArrayList<>();
        ArrayList<Integer> nm = new ArrayList<>();
        nm.ensureCapacity(m);

        for (int r1 = 0; r1 < n; ++r1) {
            for (int color : dc) {
                c[color].clear();
            }
            dc.clear();

            Arrays.fill(p, 0, m, -1);
            Arrays.fill(s, 0, m, false);

            for (int r2 = r1; r2 < n; ++r2) {
                int pc = 0;

                for (int j = 0; j < m; ++j) {
                    int color = g[r2][j];
                    if (rc[color].isEmpty()) {
                        cir[pc++] = color;
                    }
                    rc[color].add(j);
                }

                for (int k = 0; k < pc; ++k) {
                    int color = cir[k];
                    if (c[color].isEmpty()) {
                        List<Integer> rcList = rc[color];
                        for (int i = 0; i < rcList.size(); ++i) {
                            if (i > 0) {
                                int u = rcList.get(i - 1);
                                int v = rcList.get(i);
                                if (u + 1 > p[v]) p[v] = u + 1;
                            }
                            c[color].add(rcList.get(i));
                        }
                        dc.add(color);
                    } else {
                        List<Integer> oc = c[color];
                        List<Integer> nc = rc[color];
                        nm.clear();

                        int i = 0, j = 0;
                        int li = -1;

                        while (i < oc.size() || j < nc.size()) {
                            int cv;
                            boolean fn = false;

                            if (i < oc.size() && (j >= nc.size() || oc.get(i) < nc.get(j))) {
                                cv = oc.get(i++);
                            } else if (j < nc.size() && (i >= oc.size() || nc.get(j) < oc.get(i))) {
                                cv = nc.get(j++);
                                fn = true;
                            } else {
                                cv = oc.get(i);
                                s[cv] = true;
                                i++;
                                j++;
                                fn = true;
                            }

                            if (li != -1) {
                                if (li + 1 > p[cv]) p[cv] = li + 1;
                            }
                            nm.add(cv);
                            li = cv;
                        }

                        oc.clear();
                        oc.addAll(nm);
                    }
                    rc[color].clear();
                }

                int cl = 0;
                for (int j = 0; j < m; ++j) {
                    if (s[j]) {
                        cl = j + 1;
                        s[j] = false;
                    } else {
                        if (p[j] + 1 > cl) cl = p[j] + 1;
                    }

                    if (cl <= j) {
                        ans += (j - cl + 1);
                    }
                }
            }
        }

        sc.println(ans);
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

    public String nextLine() throws IOException {
        return bf.readLine();
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = bf.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
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

    public void flush() throws IOException{
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        return bf.ready();
    }
}