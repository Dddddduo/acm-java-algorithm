import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;
//        t = sc.nextInt();
        多多世界第一可爱:
        for (int i1 = 0; i1 < t; i1++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String arr[] = new String[(int) 1e5];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            SegmentTree segmentTree = new SegmentTree(arr, true, "null");
            for (int i = 0; i < q; i++) {
                char c = sc.next().charAt(0);
                if (c == 'U') {
                    int index = sc.nextInt();
                    String str = sc.next();
                    segmentTree.update(index - 1, str);
                } else {
                    int index1 = sc.nextInt();
                    int index2 = sc.nextInt();
                    Object query = segmentTree.query(index1 - 1, index2 - 1);
                    System.out.println((String) query);
                }
            }
        }
    }
}

// 线段树模版
class SegmentTree<T> {
    private final T[] tree;          // 线段树数组
    private final T[] data;          // 原始数据
    private final boolean isMax;     // true：最大值，false：最小值
    private final T defaultVal;      // 无交集区间的默认值
    private final Comparator<T> comparator; // 比较器（统一数值/字符串比较逻辑）

    private static int compareString(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }

    /**
     * 构造函数
     *
     * @param arr        原始数组
     * @param isMax      是否求最大值
     * @param defaultVal 无交集区间默认值（如Integer.MIN_VALUE/Integer.MAX_VALUE）
     */
    public SegmentTree(T[] arr, boolean isMax, T defaultVal) {
        this.data = arr.clone();
        this.isMax = isMax;
        this.defaultVal = defaultVal;
        this.tree = (T[]) new Object[4 * arr.length]; // 4倍空间足够
        // 核心比较规则
        this.comparator = (a, b) -> {
            // todo
            if (a == null) return b == null ? 0 : -1;
            if (b == null) return 1;
//            return ((Comparable<T>) a).compareTo(b);
            return compareString((String) a, (String) b);
        };
        build(0, 0, arr.length - 1);
    }

    // 构造函数
    public SegmentTree(T[] arr, boolean isMax, T defaultVal, Comparator<T> comparator) {
        this.data = arr.clone();
        this.isMax = isMax;
        this.defaultVal = defaultVal;
        this.comparator = comparator;
        this.tree = (T[]) new Object[4 * arr.length];
        build(0, 0, arr.length - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = data[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        build(leftChild, start, mid);
        build(rightChild, mid + 1, end);
        tree[node] = merge(tree[leftChild], tree[rightChild]);
    }

    // 单点更新
    public void update(int idx, T val) {
        // 合法性校验
        if (idx < 0 || idx >= data.length) {
            throw new IllegalArgumentException("更新索引越界：" + idx);
        }
        update(0, 0, data.length - 1, idx, val);
    }

    private void update(int node, int start, int end, int idx, T val) {
        if (start == end) {
            data[idx] = val;
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        if (idx <= mid) {
            update(leftChild, start, mid, idx, val);
        } else {
            update(rightChild, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[leftChild], tree[rightChild]);
    }

    // 区间查询最值
    public T query(int l, int r) {
        if (l < 0 || r >= data.length || l > r) {
            System.out.println(data.length);
            throw new IllegalArgumentException("查询区间不合法：[" + l + "," + r + "]");
        }
        return query(0, 0, data.length - 1, l, r);
    }

    private T query(int node, int start, int end, int l, int r) {
        if (end < l || start > r) {
            return defaultVal;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        T leftVal = query(leftChild, start, mid, l, r);
        T rightVal = query(rightChild, mid + 1, end, l, r);
        return merge(leftVal, rightVal);
    }

    // 合并节点
    private T merge(T a, T b) {
        if (a == defaultVal) return b;
        if (b == defaultVal) return a;
        int cmp = comparator.compare(a, b);
        return isMax ? (cmp > 0 ? a : b) : (cmp < 0 ? a : b);
    }
}