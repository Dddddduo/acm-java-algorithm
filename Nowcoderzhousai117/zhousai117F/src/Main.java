import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Main {

    static IoScanner sc = new IoScanner();
    static int n;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {

        n = sc.nextInt();

        for (int i = 0; i <= n+5; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int node = bfs(i);
            sb.append(node).append(" ");
        }
        sc.println(sb.toString());
    }

    static int bfs(int start) {

        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        arr[start] = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (arr[current] == 9) {
                cnt++;
            } else if (arr[current] < 9) {
                for (int neighbor : adj.get(current)) {
                    if (arr[neighbor] == -1) {
                        arr[neighbor] = arr[current] + 1;
                        queue.add(neighbor);
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
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