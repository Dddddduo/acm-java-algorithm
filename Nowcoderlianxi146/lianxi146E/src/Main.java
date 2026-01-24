// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner sc = new IoScanner();

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    static int[] aL;
    static int[] aR;
    static int[] b;
    static int[][] c;
    static int[][] d;
    static Point[] e;
    static ArrayList<Point>[] f;
    static int[] g;
    static int[] h;
    static int i;

    static class Point {
        int l, r, v;
        public Point(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }

    static void update(int idx, int val) {
        for (; idx <= i; idx += idx & -idx)
            h[idx] += val;
    }

    static int query(int idx) {
        int s = 0;
        for (; idx > 0; idx -= idx & -idx)
            s += h[idx];
        return s;
    }

    static void solve(int lo, int hi, int[] q) {
        if (q.length == 0) return;

        if (lo == hi) {
            int val = g[lo];
            for (int qid : q) {
                c[aL[qid]][aR[qid]] = val;
            }
            return;
        }

        int mid = (lo + hi + 1) / 2;

        ArrayList<Point> ap = new ArrayList<>();
        for (int v = mid; v <= hi; v++) {
            ap.addAll(f[v]);
        }
        Collections.sort(ap, (p1, p2) -> Integer.compare(p1.r, p2.r));

        int ptid = 0;
        int na = ap.size();

        int pc = 0;
        int fc = 0;
        int[] pq = new int[q.length];
        int[] fq = new int[q.length];

        for (int j = 0; j < q.length; j++) {
            int qid = q[j];
            int R = aR[qid];
            int L = aL[qid];

            while (ptid < na && ap.get(ptid).r <= R) {
                update(ap.get(ptid).l, 1);
                ptid++;
            }

            int cnt = query(i) - query(L - 1);
            int tot = b[qid] + cnt;

            if (tot >= d[L][R]) {
                pq[pc++] = qid;
            } else {
                fq[fc++] = qid;
                b[qid] = tot;
            }
        }

        for (int k = 0; k < ptid; k++) {
            update(ap.get(k).l, -1);
        }

        if (pc > 0)
            solve(mid, hi, Arrays.copyOf(pq, pc));
        if (fc > 0)
            solve(lo, mid - 1, Arrays.copyOf(fq, fc));
    }

    private static void solve() throws IOException {
        String nStr = sc.next();
        if(nStr == null) return;
        int n = Integer.parseInt(nStr);
        int m = sc.nextInt();

        int[] a = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            a[j] = sc.nextInt();
        }

        int np = n * (n + 1) / 2;
        e = new Point[np];
        int pid = 0;

        TreeSet<Integer> vs = new TreeSet<>();

        for (int j = 1; j <= n; j++) {
            int cm = a[j];
            for (int k = j; k <= n; k++) {
                cm = Math.min(cm, a[k]);
                e[pid++] = new Point(j, k, cm);
                vs.add(cm);
            }
        }

        g = new int[vs.size()];
        int vid = 0;
        for (int v : vs) g[vid++] = v;

        f = new ArrayList[g.length];
        for (int j = 0; j < g.length; j++) f[j] = new ArrayList<>();

        for (Point pt : e) {
            int idx = Arrays.binarySearch(g, pt.v);
            f[idx].add(pt);
        }

        for (int j = 0; j < g.length; j++) {
            Collections.sort(f[j], (p1, p2) -> Integer.compare(p1.r, p2.r));
        }

        c = new int[n + 1][n + 1];
        d = new int[n + 1][n + 1];

        aL = new int[np];
        aR = new int[np];
        int qc = 0;

        for (int len = 1; len <= n; len++) {
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;
                aL[qc] = l;
                aR[qc] = r;

                long s = (long)len * (len + 1) / 2;
                d[l][r] = (int)(s / 2) + 1;
                qc++;
            }
        }

        b = new int[qc];
        i = n;
        h = new int[n + 1];

        int[] iq = new int[qc];
        Integer[] qo = new Integer[qc];
        for(int j=0; j<qc; j++) qo[j] = j;
        Arrays.sort(qo, (id1, id2) -> Integer.compare(aR[id1], aR[id2]));
        for(int j=0; j<qc; j++) iq[j] = qo[j];

        solve(0, g.length - 1, iq);

        for (int j = 0; j < m; j++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            sc.println(c[l][r]);
        }
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

    private static <T> void dduo(T t) {
        System.out.print(t);
    }

    private static <T> void dduoln() {
        System.out.println("");
    }

    private static <T> void dduoln(T t) {
        System.out.println(t);
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

    void flush() throws IOException{
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        return bf.ready();
    }

}