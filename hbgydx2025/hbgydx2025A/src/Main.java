import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int root = 1;
    static IoScanner sc = new IoScanner();
    static class Result {
        int time;
        int count;

        public Result(int time, int count) {
            this.time  = time;
            this.count  = count;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int v= sc.nextInt();
            int u = sc.nextInt();
            tree[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];
        List<Integer> rootChildren = new ArrayList<>();
        for (int child : tree[root]) {
            rootChildren.add(child);
        }

        int maxTime = 0;
        for (int child : rootChildren) {
            Result res = dfs(child, root, visited);
            maxTime = Math.max(maxTime,  res.time);
        }
        System.out.println(maxTime+1);
    }

    private static Result dfs(int node, int parent, boolean[] visited) {
        visited[node] = true;
        List<Integer> children = new ArrayList<>();
        for (int child : tree[node]) {
            if (child != parent && !visited[child]) {
                children.add(child);
            }
        }

        if (children.isEmpty())  {
            return new Result(0, 1);
        }

        List<Result> childResults = new ArrayList<>();
        for (int child : children) {
            Result res = dfs(child, node, visited);
            childResults.add(res);
        }

        childResults.sort((a,  b) -> Integer.compare(b.count,  a.count));

        int max = 0;
        int sumPrevCount = 0;
        for (Result res : childResults) {
            max = Math.max(max,  res.time  + sumPrevCount);
            sumPrevCount += res.count;
        }

        int totalTime = max + 1;
        int totalCount = childResults.stream().mapToInt(r  -> r.count).sum();
        return new Result(totalTime, totalCount);
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