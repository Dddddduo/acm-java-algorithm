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
 *  https://ac.nowcoder.com/acm/contest/105825/C
 */

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
        int n = sc.nextInt();
        List<Queue<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> elementToQueueIndex = new HashMap<>();
        int sum = 0;
        HashSet<Integer> hs = new HashSet<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            list.add(new  LinkedList<>());
            int nn = sc.nextInt();
            sum += nn;
            for (int i1 = 0; i1 < nn; i1++) {
                int v = sc.nextInt();
                if (!hs.add(v))  {
                    dduoln("NO");
                    return;
                }
                min = Math.min(min,  v);
                list.get(i).add(v);
                elementToQueueIndex.put(v,  i);
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(min);
        int currentQueueIndex = elementToQueueIndex.get(min);
        list.get(currentQueueIndex).poll();

        int current = min;
        while (stack.size()  < sum) {
            int next = current + 1;
            if (elementToQueueIndex.containsKey(next))  {
                int nextQueueIndex = elementToQueueIndex.get(next);
                if (!list.get(nextQueueIndex).isEmpty()  && list.get(nextQueueIndex).peek()  == next) {
                    stack.add(next);
                    list.get(nextQueueIndex).poll();
                    current = next;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        if (stack.size()  == sum) {
            dduoln("YES");
        } else {
            dduoln("NO");
        }
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