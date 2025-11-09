// https://github.com/Dddddduo/acm-java-algorithm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);


    static class Pair {
        int x, y;
        // 前一个节点
        Pair prev;

        Pair(int x, int y, Pair prev) {
            this.x = x;
            this.y = y;
            this.prev = prev;
        }
    }

    static int n;
    static int m;
    static int end_x;
    static int end_y;

    public static void solve() throws Exception {

        n = sc.nextInt();
        m = sc.nextInt();

        int k = sc.nextInt();

        int start_x = sc.nextInt();
        int start_y = sc.nextInt();

        end_x = sc.nextInt();
        end_y = sc.nextInt();

        Pair end = bfs(start_x, start_y);

        if (end == null) {
            System.out.println("No");
            return;
        }

        List<Pair> path = new ArrayList<>();
        Pair curr = end;
        while (curr != null) {
            path.add(curr);
            curr = curr.prev;
        }

        Collections.reverse(path);

        int d = path.size() - 1;

        List<Pair> result = new ArrayList<>();
        for (int i = 1; i < path.size(); i++) {
            result.add(path.get(i));
        }

        // 结果需要k次 最短路径是d次
        int num = k - d;

        if(d==0){
//            System.out.println(k);
            if(k%2!=0){
                sc.println("No");
                return;
            }
            List<Pair> nearOne = getNearOne(start_x, start_y, n, m);
            if(nearOne==null||nearOne.size()==0){
                sc.println("No");
                return;
            }
            ArrayList<Pair> ans = new ArrayList<>();
            for (int i = 0; i < k / 2; i++) {
                ans.add(nearOne.get(0));
                ans.add(new Pair(start_x,start_y,null));
            }
            sc.println("Yes");
            for (Pair p : ans) {
                sc.println(p.x + " " + p.y);
            }
            return;
        }

        if (num == 0) {
            sc.println("Yes");
            for (Pair p : result) {
                sc.println(p.x + " " + p.y);
            }
        } else if (num < 0) {
            sc.println("No");
        } else if (num > 0) {
            if (num % 2 != 0) {
                sc.println("No");
                return;
            }

            if(result.size()<=3){
                sc.println("No");
                return;
            }

            ArrayList<Pair> ans = new ArrayList<>();

            ans.add(path.get(1));
            ans.add(path.get(2));

            for (int i = 0; i < num / 2; i++) {
                ans.add(path.get(1));
                ans.add(path.get(2));
            }

            for (int i = 3; i < path.size(); i++) {
                ans.add(path.get(i));
            }

            sc.println("Yes");
            for (Pair p : ans) {
                sc.println(p.x + " " + p.y);
            }

        }

    }

    // 马的行动路径
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    private static Pair bfs(int x1, int y1) {

        boolean[][] visited = new boolean[n + 5][m + 5];

        // 已经访问过了
        visited[x1][y1] = true;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(x1, y1, null));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
//            sc.println(curr.x + " " + curr.y);
            // 到达终点
            if (curr.x == end_x && curr.y == end_y) {
                return curr;
            }
            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (judge(nx, ny, n, m) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny, curr));
                }
            }
        }
        return null;
    }

    // 判断点的合法性
    static boolean judge(int x, int y, int n, int m) {
        if (x < 1 || x > n || y < 1 || y > m) {
            return false;
        } else {
            return true;
        }
    }

    // 获得这个点可以通过一步到达的地方
    static List<Pair> getNearOne(int x, int y, int n, int m) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (judge(nx, ny, n, m)) {
                list.add(new Pair(nx, ny, null));
            }
        }
        return list;
    }

    // 判断当前点是否在路径上
    private static boolean isInPath(Pair p, List<Pair> path) {
        for (Pair pp : path) {
            if (pp.x == p.x && pp.y == p.y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
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

    public void println(int a) throws IOException {
        print(a);
        println();
    }

    public void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException {
        print(a);
        println();
    }

    public void print(String a) throws IOException {
        bw.write(a);
    }

    public void println(long a) throws IOException {
        print(a);
        println();
    }

    public void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException {
        print(a);
        println();
    }

    public void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException {
        print(a);
        println();
    }

    public void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}