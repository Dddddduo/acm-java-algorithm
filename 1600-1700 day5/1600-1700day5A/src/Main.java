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
        int n=sc.nextInt();
        char wang=sc.next().charAt(0);
        HashMap<Character ,Integer> hm=new HashMap<>();
        ArrayList<PriorityQueue<Integer>>list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new PriorityQueue<>());
        }
        for (int i = 0; i < 2 * n; i++) {
            String str=sc.next();
            int a=str.charAt(0)-'0';
            char b=str.charAt(1);
            list.get(b).add(a);
//            dduoln(a+" "+b);
            hm.put(b,hm.getOrDefault(b,0)+1);
        }

//        for (Map.Entry<Character, Integer> characterIntegerEntry : hm.entrySet()) {
//            dduoln(characterIntegerEntry.getKey()+" "+characterIntegerEntry.getValue());
//        }

        // 看一下王牌的数量
        int nunWang=hm.getOrDefault(wang,0);
        int needWang=0;
        for (Character c : hm.keySet()) {
            if(c==wang)continue;
            if(hm.get(c)%2!=0){
//                dduoln(c+" "+hm.get(c));
                needWang++;
            }
        }

//        dduoln(needWang+" "+nunWang);

        if(needWang>nunWang||(nunWang-needWang)%2!=0){
            dduoln("IMPOSSIBLE");
        }else {
            for (Character c : hm.keySet()) {
                if(c==wang)continue;
                int num=hm.get(c); // 数量
                if(num%2==0){
                    PriorityQueue<Integer> pq = list.get(c);
                    while (!pq.isEmpty()){
                        Integer poll1 = pq.poll();
                        Integer poll2 = pq.poll();
                        dduoln((poll1+""+c)+" "+(poll2+""+c));
                    }
                }else if(num%2!=0){
                    PriorityQueue<Integer> pq = list.get(c);
                    while (pq.size()!=1){
                        Integer poll1 = pq.poll();
                        Integer poll2 = pq.poll();
                        dduoln((poll1+""+c)+" "+(poll2+""+c));
                    }
                    Integer lastPoll = pq.poll();
                    PriorityQueue<Integer> wangpq = list.get(wang);
                    Integer wangpoll = wangpq.poll();
                    dduoln((lastPoll+""+c)+" "+(wangpoll+""+wang));
                }
            }

            PriorityQueue<Integer> wangpq = list.get(wang);
            while (!wangpq.isEmpty()){
                Integer poll1 = wangpq.poll();
                Integer poll2 = wangpq.poll();
                dduoln((poll1+""+wang)+" "+(poll2+""+wang));
            }
        }

//        dduoln();

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