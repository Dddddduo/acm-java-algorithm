// https://github.com/Dddddduo/acm-java-algorithm
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.logging.XMLFormatter;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        long arr[]=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        SegmentTree segmentTree = new SegmentTree(arr);

        for (int i = 0; i < m; i++) {
            int way=sc.nextInt();
            if(way==1){
                int x=sc.nextInt();
                int y=sc.nextInt();
                if(x>y){
                    int temp=x;
                    x=y;
                    y=temp;
                }
                long res=segmentTree.queryMaxSubarray(x-1,y-1);
                sc.println(res);
            }else if(way==2){
                int x=sc.nextInt();
                long y=sc.nextLong();
                segmentTree.pointSet(x-1, y);
            }
        }

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

/**
 * 多功能线段树模板（内存优化版）
 * 核心优化：用数组存储节点字段+动态扩容，大幅降低内存占用
 */
class SegmentTree {
    // 用独立数组存储节点字段，替代对象存储（减少对象头开销）
    private long[] total;         // 区间总和
    private long[] maxSub;        // 最大连续子段和
    private long[] maxPrefix;     // 最大前缀和
    private long[] maxSuffix;     // 最大后缀和
    private long[] maxVal;        // 区间最大值
    private long[] minVal;        // 区间最小值
    private long[] addLazy;       // 加法懒标记
    private long[] setLazy;       // 覆盖懒标记
    private boolean[] hasSet;     // 覆盖标记是否有效
    private int capacity;         // 当前节点数组容量
    private int n;                // 原始数组长度

    /**
     * 构造函数：初始化动态数组，容量从16开始
     */
    public SegmentTree(long[] originalArr) {
        this.n = originalArr.length;
        this.capacity = 16;  // 初始容量，动态扩容
        // 初始化所有字段数组
        initArrays(capacity);
        build(0, n - 1, 0, originalArr);
    }

    /**
     * 初始化/扩容字段数组
     */
    private void initArrays(int newCapacity) {
        total = new long[newCapacity+5];
        maxSub = new long[newCapacity+5];
        maxPrefix = new long[newCapacity+5];
        maxSuffix = new long[newCapacity+5];
        maxVal = new long[newCapacity+5];
        minVal = new long[newCapacity+5];
        addLazy = new long[newCapacity+5];
        setLazy = new long[newCapacity+5];
        hasSet = new boolean[newCapacity+5];
        // 初始化新扩容的字段默认值
        for (int i = capacity; i < newCapacity+5; i++) {
            maxSub[i] = Long.MIN_VALUE;
            maxPrefix[i] = Long.MIN_VALUE;
            maxSuffix[i] = Long.MIN_VALUE;
            maxVal[i] = Long.MIN_VALUE;
            minVal[i] = Long.MAX_VALUE;
            addLazy[i] = 0;
            setLazy[i] = 0;
            hasSet[i] = false;
        }
        capacity = newCapacity;
    }

    /**
     * 检查节点索引是否超出容量，需要则扩容
     */
    private void ensureCapacity(int node) {
        if (node >= capacity) {
            int newCapacity = Math.max(capacity * 2, node + 1);
            initArrays(newCapacity);
        }
    }

    /**
     * 构建线段树（递归）
     */
    private void build(int start, int end, int node, long[] arr) {
        ensureCapacity(node);  // 确保当前节点容量足够
        if (start == end) {
            long val = arr[start];
            total[node] = val;
            maxSub[node] = val;
            maxPrefix[node] = val;
            maxSuffix[node] = val;
            maxVal[node] = val;
            minVal[node] = val;
            return;
        }

        int mid = (start + end) >>> 1;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        build(start, mid, leftChild, arr);
        build(mid + 1, end, rightChild, arr);
        merge(node, leftChild, rightChild);
    }

    /**
     * 合并左右子节点信息
     */
    private void merge(int parent, int left, int right) {
        // 合并总和
        total[parent] = total[left] + total[right];
        // 合并最大子段和
        maxSub[parent] = max(maxSub[left], maxSub[right], maxSuffix[left] + maxPrefix[right]);
        // 合并最大前缀
        maxPrefix[parent] = max(maxPrefix[left], total[left] + maxPrefix[right]);
        // 合并最大后缀
        maxSuffix[parent] = max(maxSuffix[right], total[right] + maxSuffix[left]);
        // 合并最大/最小值
        maxVal[parent] = max(maxVal[left], maxVal[right]);
        minVal[parent] = min(minVal[left], minVal[right]);
    }

    /**
     * 推送懒加载标记
     */
    private void pushDown(int node, int start, int end) {
        if (start == end) return;

        int mid = (start + end) >>> 1;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        ensureCapacity(leftChild);  // 确保子节点容量
        ensureCapacity(rightChild);

        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        // 优先处理覆盖更新
        if (hasSet[node]) {
            long setVal = setLazy[node];
            // 更新左子树
            total[leftChild] = setVal * leftSize;
            maxSub[leftChild] = setVal;
            maxPrefix[leftChild] = setVal;
            maxSuffix[leftChild] = setVal;
            maxVal[leftChild] = setVal;
            minVal[leftChild] = setVal;
            setLazy[leftChild] = setVal;
            hasSet[leftChild] = true;
            addLazy[leftChild] = 0;

            // 更新右子树
            total[rightChild] = setVal * rightSize;
            maxSub[rightChild] = setVal;
            maxPrefix[rightChild] = setVal;
            maxSuffix[rightChild] = setVal;
            maxVal[rightChild] = setVal;
            minVal[rightChild] = setVal;
            setLazy[rightChild] = setVal;
            hasSet[rightChild] = true;
            addLazy[rightChild] = 0;

            // 清空当前节点set标记
            hasSet[node] = false;
        }

        // 处理加法更新
        if (addLazy[node] != 0) {
            long addVal = addLazy[node];
            // 更新左子树
            total[leftChild] += addVal * leftSize;
            maxSub[leftChild] += addVal;
            maxPrefix[leftChild] += addVal;
            maxSuffix[leftChild] += addVal;
            maxVal[leftChild] += addVal;
            minVal[leftChild] += addVal;
            addLazy[leftChild] += addVal;

            // 更新右子树
            total[rightChild] += addVal * rightSize;
            maxSub[rightChild] += addVal;
            maxPrefix[rightChild] += addVal;
            maxSuffix[rightChild] += addVal;
            maxVal[rightChild] += addVal;
            minVal[rightChild] += addVal;
            addLazy[rightChild] += addVal;

            // 清空当前节点add标记
            addLazy[node] = 0;
        }
    }

    // ---------------------- 公开方法（逻辑不变，仅适配数组存储）----------------------
    public void rangeSet(int L, int R, long val) {
        if (L < 0 || R >= n || L > R) {
            throw new IllegalArgumentException("无效的区间范围");
        }
        rangeSet(0, n - 1, L, R, val, 0);
    }

    private void rangeSet(int start, int end, int L, int R, long val, int node) {
        ensureCapacity(node);
        if (start >= L && end <= R) {
            int size = end - start + 1;
            total[node] = val * size;
            maxSub[node] = val;
            maxPrefix[node] = val;
            maxSuffix[node] = val;
            maxVal[node] = val;
            minVal[node] = val;
            setLazy[node] = val;
            hasSet[node] = true;
            addLazy[node] = 0;
            return;
        }

        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        if (L <= mid) rangeSet(start, mid, L, R, val, leftChild);
        if (R > mid) rangeSet(mid + 1, end, L, R, val, rightChild);
        merge(node, leftChild, rightChild);
    }

    public void rangeAdd(int L, int R, long val) {
        if (L < 0 || R >= n || L > R) {
            throw new IllegalArgumentException("无效的区间范围");
        }
        rangeAdd(0, n - 1, L, R, val, 0);
    }

    private void rangeAdd(int start, int end, int L, int R, long val, int node) {
        ensureCapacity(node);
        if (start >= L && end <= R) {
            int size = end - start + 1;
            total[node] += val * size;
            maxSub[node] += val;
            maxPrefix[node] += val;
            maxSuffix[node] += val;
            maxVal[node] += val;
            minVal[node] += val;
            addLazy[node] += val;
            return;
        }

        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        if (L <= mid) rangeAdd(start, mid, L, R, val, leftChild);
        if (R > mid) rangeAdd(mid + 1, end, L, R, val, rightChild);
        merge(node, leftChild, rightChild);
    }

    public void pointSet(int index, long val) {
        if (index < 0 || index >= n) {
            throw new IllegalArgumentException("无效的索引");
        }
        rangeSet(index, index, val);
    }

    public void pointAdd(int index, long val) {
        if (index < 0 || index >= n) {
            throw new IllegalArgumentException("无效的索引");
        }
        rangeAdd(index, index, val);
    }

    public long querySum(int L, int R) {
        if (L < 0 || R >= n || L > R) {
            return 0;
        }
        return querySum(0, n - 1, L, R, 0);
    }

    private long querySum(int start, int end, int L, int R, int node) {
        ensureCapacity(node);
        if (start >= L && end <= R) {
            return total[node];
        }

        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        long sum = 0;

        if (L <= mid) sum += querySum(start, mid, L, R, 2 * node + 1);
        if (R > mid) sum += querySum(mid + 1, end, L, R, 2 * node + 2);
        return sum;
    }

    public long queryMax(int L, int R) {
        if (L < 0 || R >= n || L > R) {
            return Long.MIN_VALUE;
        }
        return queryMax(0, n - 1, L, R, 0);
    }

    private long queryMax(int start, int end, int L, int R, int node) {
        ensureCapacity(node);
        if (start >= L && end <= R) {
            return maxVal[node];
        }

        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        long max = Long.MIN_VALUE;

        if (L <= mid) max = max(max, queryMax(start, mid, L, R, 2 * node + 1));
        if (R > mid) max = max(max, queryMax(mid + 1, end, L, R, 2 * node + 2));
        return max;
    }

    public long queryMin(int L, int R) {
        if (L < 0 || R >= n || L > R) {
            return Long.MAX_VALUE;
        }
        return queryMin(0, n - 1, L, R, 0);
    }

    private long queryMin(int start, int end, int L, int R, int node) {
        ensureCapacity(node);
        if (start >= L && end <= R) {
            return minVal[node];
        }

        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        long min = Long.MAX_VALUE;

        if (L <= mid) min = min(min, queryMin(start, mid, L, R, 2 * node + 1));
        if (R > mid) min = min(min, queryMin(mid + 1, end, L, R, 2 * node + 2));
        return min;
    }

    public long queryMaxSubarray(int L, int R) {
        if (L < 0 || R >= n || L > R) {
            return Long.MIN_VALUE;
        }
        TempNode res = queryMaxSubarray(0, n - 1, L, R, 0);
        return res == null ? Long.MIN_VALUE : res.maxSub;
    }

    // 临时节点：查询最大子段和时用，避免创建过多对象
    private static class TempNode {
        long total;
        long maxSub;
        long maxPrefix;
        long maxSuffix;
    }

    private TempNode queryMaxSubarray(int start, int end, int L, int R, int node) {
        ensureCapacity(node);
        if (start >= L && end <= R) {
            TempNode temp = new TempNode();
            temp.total = total[node];
            temp.maxSub = maxSub[node];
            temp.maxPrefix = maxPrefix[node];
            temp.maxSuffix = maxSuffix[node];
            return temp;
        }

        pushDown(node, start, end);
        int mid = (start + end) >>> 1;
        TempNode leftRes = null;
        TempNode rightRes = null;

        if (L <= mid) leftRes = queryMaxSubarray(start, mid, L, R, 2 * node + 1);
        if (R > mid) rightRes = queryMaxSubarray(mid + 1, end, L, R, 2 * node + 2);

        if (leftRes != null && rightRes != null) {
            TempNode merged = new TempNode();
            merged.total = leftRes.total + rightRes.total;
            merged.maxPrefix = max(leftRes.maxPrefix, leftRes.total + rightRes.maxPrefix);
            merged.maxSuffix = max(rightRes.maxSuffix, rightRes.total + leftRes.maxSuffix);
            merged.maxSub = max(leftRes.maxSub, rightRes.maxSub, leftRes.maxSuffix + rightRes.maxPrefix);
            return merged;
        } else if (leftRes != null) {
            return leftRes;
        } else {
            return rightRes;
        }
    }

    // 工具方法（不变）
    private long max(long a, long b) {
        return Math.max(a, b);
    }

    private long max(long a, long b, long c) {
        return max(max(a, b), c);
    }

    private long min(long a, long b) {
        return Math.min(a, b);
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
