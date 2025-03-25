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
 * https://codeforces.com/problemset/problem/1937/B
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
        String str1=sc.next();
        String str2=sc.next();
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        int l1=arr1.length;
        int l2=arr2.length;

        int k=n-1;

        StringBuilder sb=new StringBuilder();
        sb.append(arr1[0]);
        for(int i=1,j=0;i<l1&&j<l2;i++,j++){
            if(arr1[i]=='1'&&arr2[j]=='1'){
                sb.append(1);
            }
            if(arr1[i]=='0'&&arr2[j]=='0'){
                sb.append(0);
            }
            if(arr1[i]=='0'&&arr2[j]=='1'){
                sb.append(0);
            }
            if(arr1[i]=='1'&&arr2[j]=='0'){
//                System.out.println(str2.substring(j,l2-1));
                k=j;
                sb.append(str2.substring(j,l2-1));
                break;
            }
        }
        sb.append(arr2[l2-1]);
        String str = sb.toString();
        System.out.println(str);
        int cnt=1;

//        for(int i=1;i<=n;i++){
//            String newStr=str1.substring(0,i)+str2.substring(i-1,n);
//            if(newStr.equals(str))cnt++;
//        }

        for(int i=k;i>=1;i--){
            if(arr1[i]==arr2[i-1]){
                cnt++;
            }else{
                break;
            }
        }

//        System.out.println(k);

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