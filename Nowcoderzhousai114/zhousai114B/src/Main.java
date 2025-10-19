import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        int n=sc.nextInt();
        String str=sc.next();

        long cnt=0;

        for(int i=0;i<n;i++){
            for(int j=i+2;j<n;j++){
                String substring = str.substring(i, j + 1);
                if(substring.length()%3!=0){
                    continue;
                }
                int cnt1=0;
                int cnt2=0;
                int cnt3=0;
                for(int k=0;k<substring.length();k++){
                    if(substring.charAt(k)=='1'){
                        cnt1++;
                    }else if(substring.charAt(k)=='2'){
                        cnt2++;
                    }else if(substring.charAt(k)=='3'){
                        cnt3++;
                    }
                }
                if(cnt1==cnt2 && cnt2==cnt3){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
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