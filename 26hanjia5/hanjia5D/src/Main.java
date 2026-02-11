// https://github.com/Dddddduo/acm-java-algorithm
// coding by Dduo from bhu-acm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
// Dduo is the cutest girl in the world!
public class Main {

    private static DduoScanner sc = new DduoScanner();
    private static final long MOD = (long) (1e9 + 7);
//    private static final long MOD = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();
    private static int dx[]={0,1,0,-1};
    private static int dy[]={1,0,-1,0};

    static class Node implements Comparable<Node> {
        long weight; // 质量
        long count; // 数量

        public Node(long weight, long count) {
            this.weight = weight;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    private static void solve() throws IOException {

        int n = sc.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long c = sc.nextLong();
            long w = sc.nextLong();
            map.put(w, map.getOrDefault(w, 0L) + c);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        long ans = 0;

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            while (!pq.isEmpty() && pq.peek().weight == current.weight) {
                current.count += pq.poll().count;
            }

            if (pq.isEmpty() && current.count == 1) {
                break;
            }

            // 批量处理2倍数的贡献
            if (current.count >= 2) {

                long sum = ((current.weight % MOD * 2) % MOD * ( current.count / 2 % MOD)) % MOD;
                ans = (ans + sum) % MOD;

                pq.offer(new Node(current.weight * 2, current.count / 2));

                // 奇数个
                if (current.count%2 == 1) {
                    pq.offer(new Node(current.weight, 1));
                }
                continue;
            }

            Node next = pq.poll();

            while (!pq.isEmpty() && pq.peek().weight == next.weight) {
                next.count += pq.poll().count;
            }

            long now = (current.weight % MOD + next.weight % MOD) % MOD;
            ans = (ans + now) % MOD;

            long l1 = current.weight + next.weight;
            pq.offer(new Node(l1, 1));

            if (next.count > 1) {
                pq.offer(new Node(next.weight, next.count - 1));
            }

        }

        sc.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        // 默认开启多组输入
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
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