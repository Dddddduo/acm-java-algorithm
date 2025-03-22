import java.util.*;
import java.io.*;
import java.math.*;

// 图论 DFS
// https://ac.nowcoder.com/acm/contest/105938/D

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];

    //  
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//    static int cnt=0;
    /**
     * @throws IOException
     */
    private static void solve() throws IOException {

        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        adj=new ArrayList<>();
        int a[]=new int[n+5];

        for(int i=0;i<n+5;i++) {
            adj.add(new ArrayList<>(n-1));
        }

        for(int j=1;j<=n;j++){
            a[j]=sc.nextInt();
        }

        for(int j=0;j<m;j++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        long dis[][]=new long[n+5][k+5],ans=(long)1e18;
        for(int j=1;j<=n;j++){
            Arrays.fill(dis[j],(long)1e18);
        }
        Queue<long[]> q=new PriorityQueue<>((x,y)->Long.compare(x[2],y[2]));
        dis[1][0]=a[1];
        q.add(new long[]{1,0,a[1]});
        if(k!=0){
            dis[1][1]=1;
            q.add(new long[]{1,1,1});
        }
        while(!q.isEmpty()){
            long b[]=q.poll();
            if(dis[(int)b[0]][(int)b[1]]<b[2]){
                continue;
            }
            for(int c:adj.get((int) b[0])){
                long d=b[2]+a[c];
                if(dis[c][0]>d){
                    dis[c][0]=d;
                    q.add(new long[]{c,0,d});
                }
                if(b[1]<k){
                    d=b[2]+1;
                    if(dis[c][(int)b[1]+1]>d){
                        dis[c][(int)b[1]+1]=d;
                        q.add(new long[]{c,b[1]+1,d});
                    }
                }
            }
        }
        for(long b:dis[n]){
            ans=Math.min(ans,b);
        }
        dduoln(ans);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {solve();}
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
 * @description 通过IO流操作缓冲区减少了与底层输入输出设备的交互次数，旨在简化 Java 中的标准输入读取操作。
 * @version 1.0
 * @author Dduo
 * @github https://github.com/Dddddduo
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
