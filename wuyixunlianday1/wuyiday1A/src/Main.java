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
 * https://ac.nowcoder.com/acm/contest/108199/A
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

        String arr[]=new String[n];
        
        for (int i = 0; i < n; i++) {
            String str=sc.next();
            arr[i]=str;
        }

//        for (char[] chars : a) {
//            dduoln(chars);
//            for (char aChar : chars) {
//                dduoln(aChar);
//            }
//        }

        // 是否已经标记
        boolean judge[]=new boolean[n];

        // 答案
        long answer[]=new long[n];

        // 字符串 数量
        HashMap<String, Integer> hm = new HashMap<>();

        // 截取多少个字符
        for (int i = 1; i <= 105; i++) {

            for (int i1 = 0; i1 < arr.length; i1++) {
                if(judge[i1]==true)continue;
                String str = arr[i1];
                hm.put(new String(str.substring(0,i)),hm.getOrDefault(new String(str.substring(0,i)),0)+1);
            }
            for (int i1 = 0; i1 < arr.length; i1++) {
                if(judge[i1]==true)continue;
                if(hm.get(arr[i1].substring(0,i))==1){
                    judge[i1]=true;
                    answer[i1]=i;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dduoln(answer[i]);
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