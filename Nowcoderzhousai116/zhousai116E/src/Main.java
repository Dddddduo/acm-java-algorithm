import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // 点
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    /**
     * @throws IOException
     */
    private static void solve() throws IOException {

        List<Integer> dataList = new ArrayList<>();

        // 读取所有输入数据
        while (sc.hasNextInt()) {
            dataList.add(sc.nextInt());
        }
        sc.close();

        if (dataList.isEmpty()) {
            return;
        }

        int[] data = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        int n = data[0];
        int m = data[1];
        int[] aList = new int[n];
        System.arraycopy(data, 2, aList, 0, n);

        int cur = 0;
        int totalStarted = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<int[]> intervals = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int a_i = aList[i - 1];

            if (cur < a_i) {
                int x = a_i - cur;
                if (totalStarted + x > m) {
                    System.out.println(-1);
                    return;
                }
                for (int j = 0; j < x; j++) {
                    queue.add(i);
                }
                totalStarted += x;
                cur = a_i;
            } else if (cur > a_i) {
                int y = cur - a_i;
                if (queue.size() < y) {
                    System.out.println(-1);
                    return;
                }
                for (int j = 0; j < y; j++) {
                    int l = queue.poll();
                    intervals.add(new int[]{l, i - 1});
                }
                cur = a_i;
            }
        }

        if (cur > 0) {
            int y = cur;
            if (queue.size() < y) {
                System.out.println(-1);
                return;
            }
            for (int j = 0; j < y; j++) {
                int l = queue.poll();
                intervals.add(new int[]{l, n});
            }
        }

        if (totalStarted != m) {
            System.out.println(-1);
        } else {
            for (int[] inter : intervals) {
                System.out.println(inter[0] + " " + inter[1]);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
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
}