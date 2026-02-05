// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner sc = new IoScanner();
//    private static final long mod = (long) (1e9 + 7);
//    private static final long mod = (long) (998244353);

    private static int n;
    private static int arr[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    // 模拟 Minecraft 的方块状态
    static final int TYPE_NORMAL = 0;
    static final int TYPE_MAGMA_DRAG = 1; // 漩涡：不能向上
    static final int TYPE_SOUL_LIFT = 2;  // 涌流：不能向下
    static final int TYPE_OBSTACLE = -1;  // 障碍

    static int N, M;
    static char[][] grid;
    static int[][] state; // 预处理后的流体状态
    static boolean[][] visited;

    // 方向向量：上，下，左，右
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 快速 I/O

        N = sc.nextInt();
        M = sc.nextInt();

        grid = new char[N][M];
        state = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int startR = sc.nextInt();
        int startC = sc.nextInt();

        // 步骤 1：预处理每一列的气泡柱状态 (BubbleColumn Logic)
        // 对应 BubbleColumnBlock.java 的逻辑：气泡状态由下方最近的方块决定
        for (int c = 0; c < M; c++) {
            int currentEffect = TYPE_NORMAL;
            // 从底向上扫描
            for (int r = N - 1; r >= 0; r--) {
                char cell = grid[r][c];

                if (cell == '#') {
                    state[r][c] = TYPE_OBSTACLE;
                    currentEffect = TYPE_NORMAL; // 气泡被阻断
                } else if (cell == 'M') {
                    state[r][c] = TYPE_OBSTACLE;
                    currentEffect = TYPE_MAGMA_DRAG; // 上方产生漩涡
                } else if (cell == 'S') {
                    state[r][c] = TYPE_OBSTACLE;
                    currentEffect = TYPE_SOUL_LIFT; // 上方产生涌流
                } else {
                    // 是水，继承下方的效果
                    state[r][c] = currentEffect;
                }
            }
        }

        // 步骤 2：BFS 寻路 (PathFinder Logic)
        if (bfs(startR, startC)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean bfs(int sr, int sc) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            // 到达水面
            if (r == 0) return true;

            int currentType = state[r][c];

            // 尝试 4 个方向
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 越界检查
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                // 障碍或已访问检查
                if (visited[nr][nc] || state[nr][nc] == TYPE_OBSTACLE) continue;

                // 核心物理规则检查 (Physics Check)

                // 1. 尝试向上 (i=0, dr=-1)
                // 如果当前在岩浆气泡柱中 (Drag)，无法克服吸力向上游
                if (i == 0 && currentType == TYPE_MAGMA_DRAG) continue;

                // 2. 尝试向下 (i=1, dr=1)
                // 如果当前在灵魂沙气泡柱中 (Lift)，无法克服推力向下潜
                if (i == 1 && currentType == TYPE_SOUL_LIFT) continue;

                // 合法移动
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
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

    protected String nextLine() throws IOException {
        return bf.readLine();
    }

    protected String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    protected char nextChar() throws IOException {
        return next().charAt(0);
    }

    protected int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    protected long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    protected double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    protected float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    protected BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    protected BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }

    protected void println(int a) throws IOException {
        print(a);
        println();
    }

    protected void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(String a) throws IOException {
        print(a);
        println();
    }

    protected void print(String a) throws IOException {
        bw.write(a);
    }

    protected void println(long a) throws IOException {
        print(a);
        println();
    }

    protected void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(double a) throws IOException {
        print(a);
        println();
    }

    protected void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    protected void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    protected void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(char a) throws IOException {
        print(a);
        println();
    }

    protected void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    protected void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    protected boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}