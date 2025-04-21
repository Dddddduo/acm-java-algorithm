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
 *
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
        int s=sc.nextInt();
        int cnt=0;
        int arr[]=new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            if(arr[i]==1){
                cnt++;
            }
        }
        if(cnt<s){
            dduoln("-1");
            return;
        }

        if(cnt==s){
            dduoln("0");
            return;
        }

        ArrayList<Integer> qian = new ArrayList<>();
        ArrayList<Integer> hou = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(arr[i]==1){
                qian.add(i+1);
            }
        }

        for (int i = n-1; i >= 0; i--) {
            if(arr[i]==1){
                hou.add(n-i);
            }
        }

//        for (Integer i1 : qian) {
//            dduo(i1+" ");
//        }
//        dduoln();
//
//        for (Integer i1 : hou) {
//            dduo(i1+" ");
//        }
//        dduoln();

        int ans=0;
        int a=cnt-s;

        int ii=0;
        int jj=-1;

        int min;
        ii=cnt-s-1;

        min=qian.get(ii);
//        dduoln(min);
//
//        dduoln(ii+" "+jj);

        while (ii>=0&&ii<qian.size()&&jj>=-1&&jj<hou.size()){
            int sum=0;
            if(ii-1>=0){
                sum+=qian.get(ii-1);
            }
            sum+=hou.get(jj+1);
//            dduoln(sum);
            min=Math.min(min,sum);
            ii--;
            jj++;
        }

        dduoln(min);
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