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
 * https://ac.nowcoder.com/acm/contest/107000/E
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
        int m=sc.nextInt();

        int cnt0=0;
        int cnt1=0;

        char[][]arr=new char[n][m];
        for (int i = 0; i < n; i++) {
            String str=sc.next();
            arr[i]=str.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                if(arr[i][i1]=='0'){
                    cnt0++;
                }else {
                    cnt1++;
                }
            }
        }

        if(cnt0%2!=0){
            dduoln("-1");
            return;
        }

        ArrayList<String>list=new ArrayList<>();

        while (cnt0!=0){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m-1; j++) {
                    if(arr[i][j]=='0'&&arr[i][j+1]=='1'){
                        arr[i][j]='1';
                        arr[i][j+1]='0';
                        list.add((i+1)+" "+(j+1)+" "+(i+1)+" "+(j+2));
                        continue;
                    }
                    if(arr[i][j]=='0'&&arr[i][j+1]=='0'){
                        arr[i][j]='1';
                        arr[i][j+1]='1';
                        list.add((i+1)+" "+(j+1)+" "+(i+1)+" "+(j+2));
                        cnt0-=2;
                        continue;
                    }
                }
            }
            for(int i=0;i<n-1;i++){
                if(arr[i][m-1]=='0'&&arr[i+1][m-1]=='1'){
                    arr[i][m-1]='1';
                    arr[i+1][m-1]='0';
                    list.add((i+1)+" "+(n)+" "+(i+2)+" "+(n));
                    continue;
                }
                if(arr[i][m-1]=='0'&&arr[i+1][m-1]=='0'){
                    arr[i][m-1]='1';
                    arr[i+1][m-1]='1';
                    cnt0-=2;
                    list.add((i+1)+" "+(n)+" "+(i+2)+" "+(n));
                    continue;
                }
            }
        }

        dduoln(list.size());
        for (int i = 0; i < list.size(); i++) {
            dduoln(list.get(i));
        }

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