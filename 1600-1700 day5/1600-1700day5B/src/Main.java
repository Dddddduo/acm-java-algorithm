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
 * https://codeforces.com/problemset/problem/2051/E
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
        int k = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {a[i] = sc.nextLong();}
        for (int i = 0; i < n; i++) {b[i] = sc.nextLong();}

        List<long[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new long[]{a[i], 1});
            list.add(new long[]{b[i], 2});
        }

        Collections.sort(list,((o1, o2) ->{
            if(o1[0]==o2[0]){
                return Long.compare(o1[1],o2[1]);
            }else {
                return Long.compare(o1[0],o2[0]);
            }
        }));
        long max=0;
        // 差评
        long chaping=0;
        // 购买数量
        long cnt=n;

        // 根据贪心 我们可以知道 每次的价格无非就是那几个临界值
        // 所以我吗在遍历的过程中选择的是从0-n*2
        // 遍历每一种价格 在循环中控制状态 包括当前差评和购买的总件数
        for(int i=0;i<n*2;){
            // 定价
            long jia=list.get(i)[0];
            if(chaping<=k){
                max=Math.max(max,jia*cnt);
            }
            while (i<2*n&&list.get(i)[0]==jia){
                long[] arr = list.get(i);
                if(arr[1]==1){
                    chaping++;
                }else if(arr[1]==2){
                    chaping--;
                    cnt--;
                }
                i++;
            }
        }
        dduoln(max);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
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