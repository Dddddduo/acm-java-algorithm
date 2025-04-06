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
 * https://ac.nowcoder.com/acm/contest/106318/F
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
        // todo
        int n = sc.nextInt();
        int[] a = new int[n];
        List<int[]> fixed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] != 0) {
                fixed.add(new int[]{i, a[i]});
            }
        }

        // 特判 没有0
//        if (fixed.isEmpty()) {
//            if (n == 1) {
//                dduoln(1);
//            } else {
//                dduoln(-1);
//            }
//            return;
//        }

        // 特判 全是0
        if (fixed.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if(i%2==0){
                    dduo(1+" ");
                }else {
                    dduo(2+" ");
                }
            }
            return;
        }

        // 特判 不能相差太大 1 0 4
//        for (int i = 1; i < fixed.size(); i++) {
//
//            int qian1 = fixed.get(i-1)[0];
//            int qian2 = fixed.get(i-1)[1];
//            int hou1 = fixed.get(i)[0];
//            int hou2 = fixed.get(i)[1];
//            int k = hou1 - qian1;
//            int d = hou2 - qian2;
//            if (Math.abs(d) > k || (d % 2 != k % 2)) {
//                dduoln(-1);
//                return;
//            }
//        }

        int[] res = Arrays.copyOf(a, n);

        // 之间的位置
        for (int i = 1; i < fixed.size(); i++) {
            // 前缀
            int[] prev = fixed.get(i-1);
            // 后缀
            int[] curr = fixed.get(i);

            int l = prev[0], r = curr[0];
            int zuobian = prev[1], youbian = curr[1];
            int k = r - l;

            // 当前两个0 0之间的距离
            int d = youbian - zuobian;

            int x = (d + k) / 2;

            int y = (k - d) / 2;

//            dduoln(i+" "+l+" "+r);
//            dduoln(k+" "+d);

            // 填充从 l+1 到 r-1
            int current = zuobian;
            for (int j = l+1; j < r; j++) {
                if (x > 0) {
                    current++;
                    x--;
                } else {
                    current--;
                    y--;
                }
                res[j] = current;
                if (current < 0) {
                    dduoln(-1);
                    return;
                }
            }
        }

//        dduoln("12");

//        for (int re : res) {
//            dduo(re+" ");
//        }
//        dduoln();

        // 前面一块 0 0 0 0 0 0 0 0 1
        // 起始位置
        int f = fixed.get(0)[0];

        int fans = fixed.get(0)[1];
//        dduoln(fans);
        for (int j = f - 1; j >= 0; j--) {
            fans--;
            res[j] = fans;
            if (fans==-1) {
                dduoln(-1);
                return;
            }
        }

//        for (int re : res) {
//            dduo(re+" ");
//        }
//        dduoln();

        // 后面一块 1 0 0 0 0 0 0 0 0
        // 结束位置
        int l = fixed.get(fixed.size()-1)[0];
        int lans = fixed.get(fixed.size()-1)[1];
        for (int j = l + 1; j < n; j++) {
            lans--;
            res[j] = lans;
            if (lans==-1) {
                dduoln(-1);
                return;
            }
        }

//        for (int re : res) {
//            dduo(re+" ");
//        }
//        dduoln();

        long sum=0;
        for (int i = 0; i < n; i++) {
            sum+=res[i];
        }

//        if(sum>3*n){
//            dduoln("-11");
//            return;
//        }

        // 输出结果
        for (int i = 0; i < n; i++) {
            dduo(res[i] + " ");
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