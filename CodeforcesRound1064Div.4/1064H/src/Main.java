import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i) { br = new BufferedReader(new InputStreamReader(i)); }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { return null; }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    static class C implements Comparable<C> {
        int x;
        long y;
        public C(int i, long s) { x = i; y = s; }
        public int compareTo(C o) { return Long.compare(o.y, this.y); }
    }

    static class V implements Comparable<V> {
        int i;
        long v;
        public V(int x, long y) { i = x; v = y; }
        public int compareTo(V o) { return Long.compare(o.v, this.v); }
    }

    static int[] tr;
    static int n;

    static void add(int x, int v) { for (; x <= n; x += x & -x) tr[x] += v; }
    static int ask(int x) { int s = 0; for (; x > 0; x -= x & -x) s += tr[x]; return s; }

    static int fk(int k) {
        if (k <= 0) return 0;
        int x = 0, s = 0, m = 1;
        while ((m << 1) <= n) m <<= 1;
        for (; m > 0; m >>= 1) {
            int nx = x + m;
            if (nx <= n && s + tr[nx] < k) { x = nx; s += tr[x]; }
        }
        return x + 1;
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextLong();

            long[] S = new long[n + 1];
            for (int i = 1; i <= n; i++) S[i] = S[i-1] + a[i];

            int[] B = new int[n + 1];
            for (int i = 1; i < n; i++) B[i] = S[i] < a[i+1] ? 1 : 0;

            int[] sb = new int[n + 2];
            for (int i = n - 1; i >= 1; i--) sb[i] = sb[i+1] + B[i];

            V[] vs = new V[n];
            for (int i = 1; i <= n; i++) vs[i-1] = new V(i, a[i] - S[i-1]);
            Arrays.sort(vs);

            C[] cs = new C[n];
            for (int i = 1; i <= n; i++) cs[i-1] = new C(i, a[i]);
            Arrays.sort(cs);

            int[] ans = new int[n + 1];
            tr = new int[n + 1];
            int p = 0;

            for (C c : cs) {
                int x = c.x;
                long v = c.y;
                while (p < n && vs[p].v > v) { add(vs[p].i, 1); p++; }
                int res = 0;

                int pt = lbS(S, 2 * v);
                int s1 = x + 1;
                int e1 = Math.min(n, pt - 1);
                if (s1 <= e1) {
                    if (sb[s1] <= k) res += e1 - s1 + 1;
                    else {
                        int pv = lbsb(sb, k, s1, e1);
                        if (pv != -1) res += e1 - pv + 1;
                    }
                }

                int s2 = Math.max(x + 1, pt);
                int e2 = n;
                if (s2 <= e2) {
                    if (sb[s2] <= k - 1) res += e2 - s2 + 1;
                    else {
                        int pv = lbsb(sb, k - 1, s2, e2);
                        if (pv != -1) res += e2 - pv + 1;
                    }
                }

                int rk = k - sb[x];
                if (rk >= 0) {
                    int ta = ask(x - 1);
                    int tg = ta - rk;
                    int ix = lbS(S, v, 0, x - 1);
                    int pc = ix + 1;

                    int qs1 = 2;
                    int qe1 = Math.min(x, pc - 1);
                    if (qs1 <= qe1) {
                        int L = fk(tg);
                        int vs1 = Math.max(qs1, L + 1);
                        if (vs1 <= qe1) res += qe1 - vs1 + 1;
                    }

                    int qs2 = Math.max(2, pc);
                    int qe2 = x;
                    if (qs2 <= qe2) {
                        int L = fk(tg + 1);
                        int vs2 = Math.max(qs2, L + 1);
                        if (vs2 <= qe2) res += qe2 - vs2 + 1;
                    }

                    if (1 < pc) {
                        if (ta <= rk) res++;
                    } else {
                        if (ta + 1 <= rk) res++;
                    }
                }
                ans[x] = res;
            }

            for (int i = 1; i <= n; i++) out.print(ans[i] + " ");
            out.println();
        }
        out.flush();
    }

    static int lbS(long[] S, long v) {
        int l = 0, r = S.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (S[m] >= v) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int lbS(long[] S, long v, int L, int R) {
        int l = L, r = R + 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (S[m] >= v) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int lbsb(int[] sb, int k, int L, int R) {
        int l = L, r = R, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (sb[m] <= k) { res = m; r = m - 1; }
            else l = m + 1;
        }
        return res;
    }
}