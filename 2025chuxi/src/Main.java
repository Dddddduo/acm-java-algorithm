// https://github.com/Dddddduo/acm-java-algorithm
// coding by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Main {

    private static DduoScanner sc = new DduoScanner();

    static class Query {
        int l, r, v;
        public Query(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }

    private static void solve() throws IOException {
        String sN = sc.next();
        if (sN == null) return;
        int n = Integer.parseInt(sN);
        int m = sc.nextInt();

        Query[] queries = new Query[m];
        for (int i = 0; i < m; i++) {
            queries[i] = new Query(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int[] ans = new int[n + 2];
        int[] diff = new int[n + 2];

        for (int b = 0; b < 30; b++) {
            Arrays.fill(diff, 0);

            for (Query q : queries) {
                if (((q.v >> b) & 1) == 0) {
                    diff[q.l]++;
                    diff[q.r + 1]--;
                }
            }

            int c = 0;
            for (int i = 1; i <= n; i++) {
                c += diff[i];
                if (c == 0) {
                    ans[i] |= (1 << b);
                }
            }
        }

        int K = 20;
        int[][] st = new int[n + 1][K];

        for (int i = 1; i <= n; i++) {
            st[i][0] = ans[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                st[i][j] = st[i][j - 1] | st[i + (1 << (j - 1))][j - 1];
            }
        }

        for (Query q : queries) {
            int len = q.r - q.l + 1;
            int k = 31 - Integer.numberOfLeadingZeros(len);
            int val = st[q.l][k] | st[q.r - (1 << k) + 1][k];

            if (val != q.v) {
                sc.println("-1");
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            sc.print(ans[i]+" ");
        }
        sc.println();
    }

    public static void main(String[] args) throws Exception {
        solve();
        sc.flush();
        sc.bw.close();
    }
}

class DduoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public DduoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    protected String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = bf.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    protected int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    protected void println(String a) throws IOException {
        bw.write(a);
        bw.newLine();
    }

    protected void println() throws IOException {
        bw.newLine();
    }

    protected void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void print(String a) throws IOException {
        bw.write(a);
    }

    protected void flush() throws IOException {
        bw.flush();
    }
}