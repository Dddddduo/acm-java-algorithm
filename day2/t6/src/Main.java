import java.io.*;
import java.math.*;
import java.util.*;

// xixi♡西
public class Main {

    static IOS sc = new IOS();
    static int mod = (int) (1e9 + 7);
//    static int mod = (int) 998244353;

    static void solve() throws IOException {

        long n=sc.nextLong();
        long k=sc.nextLong();

        if(k%2==0) { // 偶数
            for(int i=0;i<n;i++) {
                if(n-1==i+1){
                    dduo(n+" ");
                }else{
                    dduo((n-1)+" ");
                }
            }
        }else if(k%2!=0){ // 奇数
            for(int i=0;i<n-1;i++) {
                dduo(n+" ");
            }
            dduo(n-1);
        }

        dduoln();

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
    static <T> void dduoln(T t) {
        System.out.println(t);
    }
    static <T> void dduoln() {
        System.out.println("");
    }

    static long pow(long n) {
        return (1L << n) - 1L%mod;
    }

}

class IOS {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public IOS() {
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