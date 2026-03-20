import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 定义最大节点数，与C++的MAXN对应
    private static final int MAXN = 100005;
    // 邻接表存储图，Java中用List数组
    private static List<Integer>[] adj = new ArrayList[MAXN];
    // 记录每个节点的深度
    private static int[] dist = new int[MAXN];
    // 记录节点是否被访问过
    private static boolean[] visited = new boolean[MAXN];

    public static void main(String[] args) throws IOException {
        // 初始化邻接表（Java数组需要手动初始化每个元素）
        for (int i = 0; i < MAXN; i++) {
            adj[i] = new ArrayList<>();
        }

        // 使用BufferedReader加速输入，对应C++的关流加速
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 读入n-1条边
        for (int i = 0; i < n - 1; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        // 初始化dist和visited数组
        Arrays.fill(dist, -1);
        Arrays.fill(visited, false);

        // BFS队列，Java中用LinkedList实现Queue
        Queue<Integer> q = new LinkedList<>();
        // 根节点1入队
        q.offer(1);
        visited[1] = true;
        dist[1] = 0;

        int max_d = 0;

        // BFS核心逻辑
        while (!q.isEmpty()) {
            int u = q.poll();
            // 更新最大深度
            max_d = Math.max(max_d, dist[u]);

            // 遍历当前节点的所有邻接节点
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }

        // 找到深度为max_d的最小编号节点
        int ans_id = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max_d) {
                ans_id = i;
                break; // 从1开始遍历，第一个匹配的就是最小编号
            }
        }

        // 输出结果
        System.out.println(ans_id + " " + max_d);
    }
}