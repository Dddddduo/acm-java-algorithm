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
 * https://codeforces.com/problemset/problem/1989/C
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
        long arr1[]=new long[n];
        long arr2[]=new long[n];
        for (int i = 0; i < n; i++) {
            arr1[i]=sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            arr2[i]=sc.nextLong();
        }

        long ans1=0;
        long ans2=0;

        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(arr1[i]==arr2[i]&&arr1[i]!=0){
                list.add(arr1[i]);
            }else{
                if(arr1[i]>arr2[i]){
                    ans1+=arr1[i];
                }else if(arr1[i]<arr2[i]){
                    ans2+=arr2[i];
                }
            }
        }

        long cnt1=0;
        long cntfu1=0;
        for (Long l : list) {
            if(l==1)cnt1++;
            if(l==-1)cntfu1++;
        }

        // 确保ans1<ans2
        if(ans1>ans2){
            long temp=ans1;
            ans1=ans2;
            ans2=temp;
        }

//        dduoln(ans1+" "+ans2);

        // 加1的操作
        long cha=ans2-ans1;
        if(cha>cnt1){
            ans1+=cnt1;
        }else if(cha<=cnt1){
            ans1=ans2;
            cnt1-=cha;
            if(cnt1%2==0){
                ans1+=cnt1/2;
                ans2+=cnt1/2;
            }else {
                ans1+=cnt1/2;
                ans2+=cnt1/2;
                ans2+=1;
            }
        }

//        dduoln(ans1+" "+ans2);

        cha=ans2-ans1;
        if(cha>cntfu1){
            ans2-=cntfu1;
        }else if(cha<=cntfu1){
            ans2=ans1;
            cntfu1-=cha;
            if(cntfu1%2==0){
                ans1-=cntfu1/2;
                ans2-=cntfu1/2;
            }else {
                ans1-=cntfu1/2;
                ans1-=1;
                ans2-=cntfu1/2;
            }
        }

//        dduoln(ans1+" "+ans2);

        dduoln(Math.min(ans1,ans2));




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