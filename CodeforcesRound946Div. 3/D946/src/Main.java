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
 * https://codeforces.com/contest/1974/problem/D
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

        long N=0;
        long S=0;
        long W=0;
        long E=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N')N++;
            else if(str.charAt(i)=='S')S++;
            else if(str.charAt(i)=='W')W++;
            else if(str.charAt(i)=='E')E++;
        }

//        dduoln(N+" "+S+" "+W+" "+E);

        boolean judgeNyiban=false,judgeSyiban=false,judgeWyiban=false,judgeEyiban=false;
        if(N%2!=0)judgeNyiban=true;
        if(S%2!=0)judgeSyiban=true;
        if(W%2!=0)judgeWyiban=true;
        if(E%2!=0)judgeEyiban=true;

        if((N+S-Math.min(N,S)*2)%2!=0||(W+E-Math.min(W,E)*2)%2!=0){
            dduoln("NO");
            return;
        }
        if(N==1&&S==1&&W==0&&E==0){
            dduoln("NO");
            return;
        }
        if(N==0&&S==0&&W==1&&E==1){
            dduoln("NO");
            return;
        }

        boolean judgeN=false,judgeS=false,judgeW=false,judgeE=false;

        boolean judge1=false,judge2=false;

        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='N'){
               if(N==1&&judgeNyiban==true){
                   sb.append("R");
                    continue;
               }
               if(judgeN==false){
                   judgeN=true;
                   sb.append('R');
               }else if(judgeN==true){
                   judgeN=false;
                   sb.append('H');
               }
               N--;
            }else if(c=='S'){
                if(S==1&&judgeSyiban==true){
                    sb.append("R");
                    continue;
                }
                if(judgeS==false){
                    judgeS=true;
                    sb.append('R');
                }else if(judgeS==true){
                    judgeS=false;
                    sb.append('H');
                }
                S--;
            }else if(c=='W'){
                if(W==1&&judgeWyiban==true){
                    sb.append("H");
                    continue;
                }
                if(judgeW==false){
                    judgeW=true;
                    sb.append('R');
                }else if(judgeW==true){
                    judgeW=false;
                    sb.append('H');
                }
                W--;
            }else if(c=='E'){
                if(E==1&&judgeEyiban==true){
                    sb.append("H");
                    continue;
                }
                if(judgeE==false){
                    judgeE=true;
                    sb.append('R');
                }else if(judgeE==true){
                    judgeE=false;
                    sb.append('H');
                }
                E--;
            }
        }
        dduoln(sb.toString());
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