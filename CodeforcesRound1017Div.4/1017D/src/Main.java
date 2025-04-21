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
 * https://codeforces.com/contest/2094/problem/D
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
        String str1=sc.next(); // 实际
        String str2=sc.next(); // 听到的

        int ans=1;

        int ans1=ans;
        for(int i=1;i< str1.length();i++){
            if(str1.charAt(i)!=str1.charAt(i-1)){
                ans1++;
            }
        }

        int ans2=ans;
        for(int i=1;i< str2.length();i++){
            if(str2.charAt(i)!=str2.charAt(i-1)){
                ans2++;
            }
        }

        if(ans1!=ans2){
            dduoln("NO");
            return;
        }

        int arr1[]=new int[ans1];
        int arr2[]=new int[ans1];

        char c=str1.charAt(0);
        int p=0;
        int cnt=1;

        ArrayList<Character>list1=new ArrayList<>();
        list1.add(c);

        for(int i=1;i<str1.length();i++){
            if(str1.charAt(i)!=c){
                c= str1.charAt(i);
                arr1[p]=cnt;
                p++;
                cnt=1;
                list1.add(c);
            }else{
                cnt++;
            }
        }
        arr1[p]=cnt;

//        for (int i : arr1) {
//            dduo(i+" ");
//        }
//        dduoln();

//        for (Character character : list1) {
//            dduoln(character);
//        }

        c=str2.charAt(0);
        p=0;
        cnt=1;

        ArrayList<Character>list2=new ArrayList<>();
        list2.add(c);

        for(int i=1;i<str2.length();i++){
            if(str2.charAt(i)!=c){
                c= str2.charAt(i);
                arr2[p]=cnt;
                p++;
                cnt=1;
                list2.add(c);
            }else{
                cnt++;
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)!=list2.get(i)){
                dduoln("NO");
                return;
            }
        }

        arr2[p]=cnt;

//        for (int i : arr2) {
//            dduo(i+" ");
//        }
//        dduoln();

        for (int i = 0; i < ans1; i++) {
            int cnt1 = arr1[i];
            int cnt2 = arr2[i];
//            dduoln(cnt1+" "+cnt2);
            if(cnt2>2*cnt1||cnt2<cnt1){
                dduoln("NO");
                return;
            }
        }

        dduoln("YES");


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