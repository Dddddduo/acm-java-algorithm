// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.net.Inet4Address;
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

/**
 * 题目地址
 * https://codeforces.com/problemset/problem/2040/C
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
        Queue<Long>queue=new LinkedList<>();
        TreeMap<Long,Long>tm=new TreeMap<>();

        for (int i = 0; i < n; i++) {
            long a=sc.nextLong();
            queue.add(a);
            tm.put(a,tm.getOrDefault(a,0L)+1);
        }

        List<Long> list=new ArrayList<>();

        List<Long> temp = new ArrayList<>();

        while (!queue.isEmpty()){
            long poll= queue.poll();
            long val=tm.get(poll);
            if(poll>tm.firstKey()){
//                long poll = queue.poll();
                long now=poll+1;
                temp.add(now);
                if(val==1){
                    tm.remove((Long)poll);
                }else{
                    tm.put(poll,val-1);
                }
                tm.put(now,tm.getOrDefault(now,0L)+1);
            }else if(poll==tm.firstKey()){
//                long poll = queue.poll();
                list.add(poll);
                if(val==1){
                    tm.remove((Long)poll);
                }else{
                    tm.put(poll,val-1);
                }
            }

            if(queue.isEmpty()){
//                dduoln("123");
                Collections.sort(temp);
                queue.addAll(temp);
                temp.clear();
            }

        }

        Collections.sort(temp);
        list.addAll(temp);

        StringBuilder sb=new StringBuilder("");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+" ");
//            dduo();
        }
        dduoln(sb);

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