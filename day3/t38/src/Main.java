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
 * ?????
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static long arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        n=sc.nextInt();
        arr=new long[n];

        long max=0;

        ArrayList<Long>list=new ArrayList<>();

        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
            list.add(arr[i]);
            max=Math.max(max,arr[i]);
        }

        Deque<Long> deque = new LinkedList<>();
        deque.add(max);

        long ans1=max;
        while(true){
            if(ans1%3==0){
                if(list.contains(ans1/3)){
                    deque.addLast(ans1/3);
                    list.remove(ans1/3);
                    ans1/=3;
                    continue;
                }
            }
            if(list.contains(ans1*2)){
                deque.addLast(ans1*2);
                list.remove(ans1*2);
                ans1*=2;
                continue;
            }
            break;
        }

        ans1=max;
        while(true){
            if(ans1%2==0){
                if(list.contains(ans1/2)){
                    deque.addFirst(ans1/2);
                    list.remove(ans1/2);
                    ans1/=2;
                    continue;
                }
            }
            if(list.contains(ans1*3)){
                deque.addFirst(ans1*3);
                list.remove(ans1*3);
                ans1*=3;
                continue;
            }
            break;
        }

        for (Long l : deque) {
            dduo(l+" ");
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