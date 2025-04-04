import java.io.*;
import java.math.*;
import java.util.*;
// https://ac.nowcoder.com/acm/contest/103151/A
public class Main {

    static ScannerIos sc=new ScannerIos();
    static int MOD=(int) (1e9+7);

    static void solve() throws IOException {

        long x=sc.nextLong();
        long y=sc.nextLong();
        long min=sc.nextLong();

        int min1= (int) Math.min(x-1,min);
        int min2= (int) Math.min(y-1,min);

        dduoln(Math.min(min1,min2));

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