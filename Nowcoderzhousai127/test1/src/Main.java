// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo from bhu-acm
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    private static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
    static final long mod = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    private static void solve() throws IOException {
        int n =sc.nextInt();
        long arr[]=new long[n];
//        int index[]=new int[100000000];
        HashMap<Long, Long> hm = new HashMap<>(n);
        for (int i1 = 0; i1 < n; i1++) {
            arr[i1]=sc.nextLong();
//            index[arr[i1]]++;
            hm.put(arr[i1],hm.getOrDefault(arr[i1],0L)+1);
        }

//        hm.keySet().forEach(c -> {
//            try {
//                sc.println(c);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });

        long i = 1L;
        while(hm.containsKey(i)&&hm.get(i)>=2)i++;

        long sum=0;
        long ans=1;

        for (long i1 = 1; i1 < i; i1++) {
            Long i2 = hm.get(i1);
//            sc.println(i1+" "+i2);
            long temp = i2*(i2-1)/2;
            temp%=mod;
            ans*=temp;
            ans%=mod;
            sum+=ans;
            sum%=mod;
        }
        sc.println(sum%mod);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

    private static <T> void dduo(T t) {
        System.out.print(t);
    }

    private static <T> void dduoln() {
        System.out.println("");
    }

    static <T> void dduoln(T t) {
        System.out.println(t);
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

    public void println(int a) throws IOException{
        print(a);
        println();
    }

    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException{
        print(a);
        println();
    }

    public void print(String a) throws IOException{
        bw.write(a);
    }

    public void println(long a) throws IOException{
        print(a);
        println();
    }

    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException{
        print(a);
        println();
    }

    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException{
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException{
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException{
        print(a);
        println();
    }

    public void println() throws IOException{
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}