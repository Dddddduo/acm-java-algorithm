// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

/**
 * 题目地址
 * https://vjudge.net/contest/705739#problem/K
 */

// 多多的迷你哈希链表
class DduoHashLinkedList {
    private static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val  = val; }
    }

    private final Node head, tail;
    private final Map<Integer, LinkedHashSet<Node>> valueToNodes;
    private final Map<Node, Integer> nodeToValue;

    public DduoHashLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next  = tail;
        tail.prev  = head;
        valueToNodes = new HashMap<>();
        nodeToValue = new HashMap<>();
    }

    // 添加元素到链表末尾（初始化使用）
    public void add(int val) {
        Node newNode = new Node(val);
        // 维护链表连接
        newNode.prev  = tail.prev;
        newNode.next  = tail;
        tail.prev.next  = newNode;
        tail.prev  = newNode;
        // 更新哈希表
        valueToNodes.computeIfAbsent(val,  k -> new LinkedHashSet<>()).add(newNode);
        nodeToValue.put(newNode,  val);
    }

    // 在第一个x节点后插入y
    public void insertAfter(int x, int y) {
        if (!valueToNodes.containsKey(x))  return;

        LinkedHashSet<Node> xNodes = valueToNodes.get(x);
        if (xNodes.isEmpty())  return;

        Node xNode = xNodes.iterator().next();  // 取第一个出现的x节点
        Node yNode = new Node(y);

        // 维护链表连接
        yNode.prev  = xNode;
        yNode.next  = xNode.next;
        xNode.next.prev  = yNode;
        xNode.next  = yNode;

        // 更新哈希表
        valueToNodes.computeIfAbsent(y,  k -> new LinkedHashSet<>()).add(yNode);
        nodeToValue.put(yNode,  y);
    }

    // 删除第一个x节点
    public void remove(int x) {
        if (!valueToNodes.containsKey(x))  return;

        LinkedHashSet<Node> xNodes = valueToNodes.get(x);
        if (xNodes.isEmpty())  return;

        Iterator<Node> it = xNodes.iterator();
        Node delNode = it.next();  // 取第一个出现的x节点
        it.remove();

        // 维护链表连接
        delNode.prev.next  = delNode.next;
        delNode.next.prev  = delNode.prev;

        // 清理哈希表
        nodeToValue.remove(delNode);
        if (xNodes.isEmpty())  {
            valueToNodes.remove(x);
        }
    }

    // 转换为输出字符串
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head.next;
        while (curr != tail) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        return sb.toString().trim();
    }
}

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();

        DduoHashLinkedList list = new DduoHashLinkedList();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.insertAfter(x,  y);
            } else if (op == 2) {
                int x = sc.nextInt();
                list.remove(x);
            }
        }

        dduoln(list);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static <T> void dduo(T t) {
        System.out.print(t);
    }

    static <T> void dduoln() {
        System.out.println("");
    }

    static <T> void dduoln(T t) {
        System.out.println(t);
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