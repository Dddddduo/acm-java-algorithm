import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a==b){
            sc.println("purple");
            return;
        }

        adj = new ArrayList<>();
        for (int i = 0; i <= n+5; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[n + 10];

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        int[] distA = bfs(a, n, adj);
        int[] distB = bfs(b, n, adj);

        // 小红一开始就在叶子节点
        if (degree[a] == 1) {
            sc.println("red");
            return;
        }

        // 小红第一步能到叶子节点
        for (int neighbor : adj.get(a)) {
            if (degree[neighbor] == 1 && neighbor != b) {
                sc.println("red");
                return;
            }
        }

        boolean[] control = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (distB[i] <= 2 * distA[i]) {
                control[i] = true;
            }
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (degree[u] == 1) {
                sc.println("red");
                return;
            }
            for (int v : adj.get(u)) {
                if (!visited[v] && !control[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        sc.println("purple");
    }

    private static int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
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

    public void flush() throws IOException{
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        return bf.ready();
    }

}