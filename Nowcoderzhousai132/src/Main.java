import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
// Dduo is the cutest girl in the world!
public class Main {

    private static DduoScanner sc = new DduoScanner();

    private static final int MAX_LIMIT = 10000050;
    private static int[] visit;
    private static int[] dist;

    private static void solve() throws IOException {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();

        visit = new int[MAX_LIMIT];
        dist = new int[MAX_LIMIT];

        Queue<Integer> queue = new LinkedList<>();
        dist[a]=0;
        queue.offer(a);

        int limit=1;
        long ans=b;
        while(ans>0){
            limit*=10;
            ans/=10;
        }

        if(a>limit){
            sc.println("-1");
            return;
        }

        while(!queue.isEmpty()){

            Integer poll = queue.poll();
            int distance = dist[poll];

            if(poll==b){
                sc.println(distance);
                return;
            }

            // 翻转
            if(poll%10!=0){
                int reverse = reverse(poll);
                if(visit[reverse]==0&&reverse<=limit){
                    visit[reverse]=1;
                    dist[reverse]=distance+1;
                    queue.offer(reverse);
                }
            }

            // 加k
            int add=poll+k;
            if(visit[add]==0&&add<=limit){
                visit[add]=1;
                dist[add]=distance+1;
                queue.offer(add);
            }
        }

        sc.println("-1");


    }

    public static int reverse(int num) {
        int mirror = 0;
        while (num > 0) {
            mirror = mirror * 10 + num % 10;
            num /= 10;
        }
        return mirror;
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
}

class DduoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public DduoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    protected String nextLine() throws IOException {
        return bf.readLine();
    }

    protected String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    protected char nextChar() throws IOException {
        return next().charAt(0);
    }

    protected int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    protected long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    protected double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    protected float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    protected BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    protected BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }

    protected void println(int a) throws IOException {
        print(a);
        println();
    }

    protected void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(String a) throws IOException {
        print(a);
        println();
    }

    protected void print(String a) throws IOException {
        bw.write(a);
    }

    protected void println(long a) throws IOException {
        print(a);
        println();
    }

    protected void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(double a) throws IOException {
        print(a);
        println();
    }

    protected void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    protected void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    protected void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(char a) throws IOException {
        print(a);
        println();
    }

    protected void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    protected void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    protected boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}