import java.io.*;
import java.math.*;
import java.util.*;
// https://codeforces.com/problemset/problem/1886/B
public class Main {

    static IOS sc=new IOS();
    static int MOD=(int) (1e9+7);

    static void solve() throws IOException {

        // 家的位置
        double px=sc.nextDouble();
        double py=sc.nextDouble();

        // 灯笼1
        double ax=sc.nextDouble();
        double ay=sc.nextDouble();

        // 灯笼2
        double bx=sc.nextDouble();
        double by=sc.nextDouble();

        // 单独灯笼到达
        double pa=d(px,py,ax,ay); // 灯笼1距离家
        double pb=d(px,py,bx,by); // 灯笼2距离家

        double oa=d(0,0,ax,ay); // 灯笼1距离原点
        double ob=d(0,0,bx,by); // 灯笼2距离原点

        double ab = d(ax,ay,bx,by); // 灯笼1和灯笼2的距离
        double r=ab/2.0;

        double ans = Double.MAX_VALUE;

        ans = Math.min( Math.max(pb,  ob),  Math.max(pa,  oa));

        ans = Math.min(ans,  Math.max(r, Math.max(pa,  ob)));
        ans = Math.min(ans,  Math.max(r, Math.max(pb,  oa)));

        dduoln(ans);

    }

    static double d(double x1,double y1,double x2,double y2){
        return Math.sqrt( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) );
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
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