// https://github.com/Dddddduo/acm-java-algorithm
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
    static final int MOD= (int) (99824453);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int k = sc.nextInt();

        long arr[]=new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        SegmentTree st = new SegmentTree(arr,998244353);

        long max=0;

        for(int i=0;i<n-k+1;i++){
            long query = st.query(i, i + k - 1);
            max=Math.max(max,query);
        }

        System.out.println(max);
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

// 线段树模版 (求积取模版)
class SegmentTree {

    // 线段树数组，存储区间乘积（取模后）
    private long[] tree;

    // 原始数据数组
    private long[] data;

    // 数据长度
    private int n;

    // 模数
    private final long mod;

    // 构造函数，初始化线段树并指定模数
    public SegmentTree(long[] arr, long mod) {
        this.n = arr.length;
        this.data = new long[n];
        System.arraycopy(arr, 0, this.data, 0, n);
        this.mod = mod;
        // 线段树大小通常取 4*n 确保足够
        this.tree = new long[4 * n];
        build(0, 0, n - 1);
    }

    // 构建线段树（带模运算）
    private void build(int node, int start, int end) {
        if (start == end) {
            // 叶子节点：单个元素取模后存储
            tree[node] = data[start] % mod;
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            // 递归构建左右子树
            build(leftChild, start, mid);
            build(rightChild, mid + 1, end);
            // 当前节点值 = 左右子树乘积 % 模
            tree[node] = (tree[leftChild] * tree[rightChild]) % mod;
        }
    }

    // 单点更新：将 index 位置的值更新为 val（带模）
    public void update(int index, int val) {
        if (index < 0 || index >= n) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        data[index] = val;
        update(0, 0, n - 1, index, val);
    }

    // 递归实现单点更新（带模）
    private void update(int node, int start, int end, int index, int val) {
        if (start == end) {
            // 目标位置：更新后取模
            tree[node] = val % mod;
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            if (index <= mid) {
                update(leftChild, start, mid, index, val);
            } else {
                update(rightChild, mid + 1, end, index, val);
            }
            // 更新当前节点值（乘积后取模）
            tree[node] = (tree[leftChild] * tree[rightChild]) % mod;
        }
    }

    // 区间查询：查询 [l, r] 区间的乘积（带模）
    public long query(int l, int r) {
        if (l < 0 || r >= n || l > r) {
            throw new IllegalArgumentException("Invalid query range");
        }
        return query(0, 0, n - 1, l, r);
    }

    // 递归实现区间查询（带模）
    private long query(int node, int start, int end, int l, int r) {
        // 区间不相交，返回 1（乘法单位元，不影响乘积）
        if (r < start || end < l) {
            return 1;
        }
        // 当前区间完全在查询区间内，返回当前节点值（已取模）
        if (l <= start && end <= r) {
            return tree[node];
        }
        // 部分相交，递归查询左右子树
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        long leftProduct = query(leftChild, start, mid, l, r);
        long rightProduct = query(rightChild, mid + 1, end, l, r);
        // 左右子树乘积后取模
        return (leftProduct * rightProduct) % mod;
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

    //其他调试命令：
    public void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}