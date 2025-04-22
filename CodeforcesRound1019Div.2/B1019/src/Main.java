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
 * https://codeforces.com/contest/2103/problem/B
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
        String str=sc.next();
        //  1101010010011011100
        //  0111010010011011100

        boolean judge1=false;
        int p1=-1;
        boolean judge2=false;
        int p2=-1;

        for (int i = 0; i < n-1; i++) {
//            char c = str.charAt(i);
            if(judge1==true&&judge2==true)break;
            // 寻找前置1
            if(judge1==false&&str.charAt(i)=='1'){
                judge1=true;
                p1=i;
                continue;
            }
            // 寻找后置0
            if(judge1==true&&str.charAt(i)=='0'&&str.charAt(i+1)=='1'){
                judge2=true;
                p2=i;
                continue;
            }
        }
//        dduoln(p1+" "+p2);
        StringBuilder sb =new StringBuilder("");
        if(p1!=-1){
            if(p2==-1){
                p2=str.length()-1;
            }
            String str1 = str.substring(0, p1);
//            dduoln(str1);//
            sb.append(str1);
            String str2 = new StringBuilder(str.substring(p1, p2+1)).reverse().toString();
//            dduoln(str2);//
            sb.append(str2);
            String str3 = str.substring(p2+1, str.length());
//            dduoln(str3);//
            sb.append(str3);
        }else {
            sb.append(str);
        }

        String string = sb.toString();
//        System.out.println(string);

        // 初始值为0
        char a='0';
        int cnt=0;
        for(int i=0;i<n;i++){
            if(string.charAt(i)==a){
                cnt++;
                continue;
            }
            if(string.charAt(i)!=a){
                cnt+=2;
                if(string.charAt(i)=='0'){
                    a='0';
                    continue;
                }
                if(string.charAt(i)=='1'){
                    a='1';
                    continue;
                }
            }
        }

        dduoln(cnt);

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