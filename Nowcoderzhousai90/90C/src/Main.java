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
 * https://ac.nowcoder.com/acm/contest/108782/C
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
        int n=sc.nextInt();
        long a[]=new long[n];
        Long b[]=new Long[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextLong()*(i+1);
        }
//        for (long l : a) {
//            dduoln(l);
//        }
        for (int i = 0; i < n; i++) {
            b[i]=sc.nextLong();
        }

        Arrays.sort(b,Collections.reverseOrder());

        // value index 值 索引
        ArrayList<long[]>list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new long[]{a[i],i});
        }

        Collections.sort(list,((o1, o2) -> {
            return Long.compare(o2[0],o1[0]);
        }));

        long ans[]=new long[n];

        int i=0;
        for (long[] longs : list) {
//            dduoln(longs[0]+" "+longs[1]);
            ans[(int) longs[1]]=b[i];
            i++;
        }

        StringBuilder sb=new StringBuilder();
        for (int ii = 0; ii < n; ii++) {
//            dduo(ans[ii]+" ");
            sb.append(ans[ii]+" ");
        }
        dduoln(sb);

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