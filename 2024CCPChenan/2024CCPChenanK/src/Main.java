// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
    static int n;
    static long val[];
    static ArrayList<ArrayList<Integer>> adj;

    private static void solve() throws IOException {
        n = sc.nextInt();
        val = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            val[i] = sc.nextLong();
        }

        adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 构建父节点关系
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        parent[1] = 0; // root节点父节点设为0
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    q.add(v);
                }
            }
        }

        // BFS统计可达节点
        boolean[] reachable = new boolean[n + 1];
        reachable[1] = true;
        int count = 1;
        q.clear();
        q.add(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (v == parent[u]) continue; // 跳过父节点
                if (val[u] <= 2 * val[v] && !reachable[v]) {
                    reachable[v] = true;
                    count++;
                    q.add(v);
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}

class IoScanner {
    BufferedReader bf;
    StringTokenizer st;

    public IoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
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

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
