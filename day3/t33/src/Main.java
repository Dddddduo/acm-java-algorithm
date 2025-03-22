import java.util.*;
import java.io.*;
import java.math.*;

// 河南省第十三届ICPC大学生程序设计竞赛
// https://ac.nowcoder.com/acm/contest/17148/F

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

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            arr[i] = str.toCharArray();
        }

        int x=0;
        int y=0;

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++){
                if(arr[i][j]=='*'&&arr[i-1][j]=='*'&&arr[i][j-1]=='*'&&arr[i+1][j]=='*'&&arr[i][j+1]=='*'){
                    x=i;
                    y=j;
                    break;
                }
            }
        }

        int xx=0;
        int yy=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if(arr[i][j]=='#'){
                    xx=i;
                    yy=j;
                    break;
                }
            }
        }

        dduoln((yy-y)+" "+(x-xx));

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
