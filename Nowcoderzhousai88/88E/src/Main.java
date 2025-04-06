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
 * https://ac.nowcoder.com/acm/contest/106318/E
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
        int k=sc.nextInt();
        long a[]=new long[n];
        long b[]=new long[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i]=sc.nextLong();
        }

        long dp1[]=new long[n];
        long dp2[]=new long[n];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int i=0;
        long cnt=0;
        while(cnt<k&&i<n){
            cnt+=a[i];
            i++;
        }
        if(i==n-1){
            dduoln(cnt);
            return;
        }
        i-=1;
        // i
        dp1[i]=cnt;
        for(int j=i;j<n-1;j++){
            // 在表世界

            // 直走
//            dp1[j+1]=dp1[j]+a[j+1];
            dp1[j+1]=Math.max(dp1[j+1],dp1[j]+a[j+1]);
            // 去下一个世界
            if(dp1[j]>=k){
//                dp2[j+1]=dp1[j]+b[j+1]-k;
                dp2[j+1]=Math.max(dp2[j+1],dp1[j]+b[j+1]-k);
            }

            // 在里世界
            if(dp2[j]==-1){
                continue;
            }
            // 直走
//            dp2[j+1]=dp2[j]+b[j+1];
            dp2[j+1]=Math.max(dp2[j]+b[j+1],dp2[j+1]);
            // 去下一个世界
            if(dp2[j]>=k){
//                dp1[j+1]=dp2[j]+a[j+1]-k;
                dp1[j+1]=Math.max(dp1[j+1],dp2[j]+a[j+1]-k);
            }

        }

//        for (int i1 = 0; i1 < dp1.length; i1++) {
//            dduo(dp1[i1]+" ");
//        }
//        dduoln();
//        for (int i1 = 0; i1 < dp1.length; i1++) {
//            dduo(dp2[i1]+" ");
//        }
//        dduoln();

        dduoln(Math.max(dp1[n-1],dp2[n-1]));

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
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