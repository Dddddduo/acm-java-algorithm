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
 * https://codeforces.com/problemset/problem/1955/C
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
        long k=sc.nextLong();

        Deque<Long>deque=new LinkedList<>();

        for (int i = 0; i < n; i++) {
            long ans=sc.nextLong();
            deque.add(ans);
        }

        boolean judge=true;

        while(k>0&&deque.size()>=2){
            if(judge==true){
                // 从头部开始
                long first = deque.peekFirst();
                long last = deque.peekLast();
//                dduoln(first+" "+last);
                if(first<=last){
                    // 下一次操作是从后面开始 前面一个数变成0了
                    long cnt=first*2-1;
                    if(cnt>k){
                        break;
                    }else{
                        k-=cnt;
                        judge=false;
                        deque.removeFirst();
                        deque.removeLast();
                        deque.addLast(last-first+1);
                    }
                }else if(first>last){
                    // 下一次操作时从头部开始 后面那个数变成0了
                    long cnt=last*2;
//                    dduoln(cnt);
                    if(cnt>k){
                        break;
                    }else{
                        k-=cnt;
                        judge=true;
                        deque.removeLast();
                        deque.removeFirst();
                        deque.addFirst(first-last);
                    }
                }
            }else if(judge==false){
                // 从尾部开始
                long last = deque.peekFirst();
                long first = deque.peekLast();
                if(first<=last){
                    // 下一次操作是从后面开始 前面一个数变成0了
                    long cnt=first*2-1;
                    if(cnt>k){
                        break;
                    }else{
                        k-=cnt;
                        judge=true;
                        deque.removeFirst();
                        deque.removeLast();
//                        deque.addLast(last-first+1);
                        deque.addFirst(last-first+1);
                    }
                }else if(first>last){
                    // 下一次操作时从头部开始 后面那个数变成0了
                    long cnt=last*2;
                    if(cnt>k){
                        break;
                    }else{
                        k-=cnt;
                        judge=false;
                        deque.removeLast();
                        deque.removeFirst();
//                        deque.addFirst(first-last);
                        deque.addLast(first-last);
                    }
                }
            }
        }

        if(k>0&&deque.size()==1){
            Long l = deque.getFirst();
//            System.out.println(l+" "+k);
            if(l<=k){
                deque.pollFirst();
            }
        }

        dduoln(n-deque.size());


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