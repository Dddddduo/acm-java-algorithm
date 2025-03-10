import java.io.*;
import java.math.*;
import java.util.*;
// https://www.luogu.com.cn/problem/P1725
public class Main {

    static IOS sc=new IOS();
    static int MOD=(int) (1e9+7);

    static void solve() throws IOException {

        // 读取 n, L, R
        int n = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        // 读取数组 a
        long[] a = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = sc.nextLong();
        }

        // 定义优先队列
        PriorityQueue<Long> q1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> q2 = new PriorityQueue<>(Collections.reverseOrder());

        // 初始化 q2
        for (int i = 1; i < L; i++) {
            q2.add(a[i]);
        }

        // 定义 f 数组
        long[] f = new long[n + 1];
        for (int i = L; i <= n; i++) {
            if (i - L >= 0) {
                q1.add(f[i  - L]);
            }
            if (i - R - 1 >= L) {
                q2.add(f[i  - R - 1]);
            }
            // 同步两个优先队列
            while (!q2.isEmpty()  && (q1.peek()).equals(q2.peek()))  {
                q1.poll();
                q2.poll();
            }
            // 计算 f[i]
            f[i] = q1.peek()  + a[i];
        }

        // 找出 ans
        long ans = Long.MIN_VALUE;
        for (int i = n - R + 1; i <= n; i++) {
            ans = Math.max(ans,  f[i]);
        }

        // 输出结果
        dduoln(ans);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {solve();}
    }

    static <T> void dduo(T t) {System.out.print(t);}
    static <T> void dduoln(T t) {System.out.println(t);}
    static <T> void dduoln() {System.out.println("");}
}

class IOS{
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;
    public IOS(){
        bf=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer("");
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public String nextLine() throws IOException{
        return bf.readLine();
    }
    public String next() throws IOException{
        while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    public char nextChar() throws IOException{
        return next().charAt(0);
    }
    public int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    public long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    public float nextFloat() throws IOException{
        return Float.parseFloat(next());
    }
    public BigInteger nextBigInteger() throws IOException{
        return new BigInteger(next());
    }
    public BigDecimal nextDecimal() throws IOException{
        return new BigDecimal(next());
    }
}