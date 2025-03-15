import java.io.*;
import java.math.*;
import java.util.*;
// https://ac.nowcoder.com/acm/contest/103151/B
public class Main {

    static ScannerIos sc=new ScannerIos();
    static int MOD=(int) (1e9+7);

    static void solve() throws IOException {

        long n=sc.nextLong();
        long m=sc.nextLong();
        long q=sc.nextLong();

        long ans= m%2==0 ? 1 : -1; // 1偶数 2奇数

        long arr[]=new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }

        for (int i = 0; i < q; i++) {
            long x=sc.nextLong();
            long y=sc.nextLong();
            if(x!=y){
                ans*=-1;
            }
            dduoln(ans==1?"even":"odd");
        }

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

class ScannerIos{
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;
    public ScannerIos(){
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