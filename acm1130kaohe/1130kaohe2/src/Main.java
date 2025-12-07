// https://github.com/Dddddduo/acm-java-algorithm

import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {
        int n = sc.nextInt();
        long arr[] = new long[n + 2];
        HashSet<Long> integers = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextLong();
            integers.add(arr[i]);
        }

        arr[n + 1] = Long.MAX_VALUE;

        if (integers.size() == 1) {
            sc.println("0");
            return;
        }

        long result = Long.MAX_VALUE;

        // 是否开始出现连续相同的数字
        boolean judge = false;
        // 前面那个相同数的索引
        int pre_index = -1;

        for (int i = 2; i < n + 2; i++) {
            if (judge == false && arr[i] == arr[i - 1]) {
                judge = true;
                pre_index = i - 1;
            } else if (arr[i] != arr[i - 1]) {
                if (judge == true) {
                    judge = false;
                    result = Math.min(result, (long)(pre_index - 1) *(long) arr[i - 1] + (long)(n - (i - 1)) * (long)arr[i - 1]);
//                    sc.println(pre_index+" "+(i-1));
                } else if (judge == false) {
//                    result=Math.min(result,(i-1)*arr[i]+(n-i)*arr[i]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            result=Math.min(result,(long)(i-1)*(long)arr[i]+(long)(n-i)*(long)arr[i]);
        }

        sc.println(result);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

}

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

    public void println(int a) throws IOException {
        print(a);
        println();
    }

    public void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException {
        print(a);
        println();
    }

    public void print(String a) throws IOException {
        bw.write(a);
    }

    public void println(long a) throws IOException {
        print(a);
        println();
    }

    public void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException {
        print(a);
        println();
    }

    public void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException {
        print(a);
        println();
    }

    public void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}