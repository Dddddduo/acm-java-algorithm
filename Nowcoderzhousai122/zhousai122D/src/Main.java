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
    // 使用局部变量更安全，这里只保留 n 作为全局静态变量以符合模板习惯

    private static void solve() throws IOException {
        n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        Arrays.sort(a);

        long currentSum = 0;
        for (long x : a) {
            if (x <= currentSum + 1) {
                currentSum += x;
            } else {
                break;
            }
        }

        long m = currentSum + 1;

        if (m == 1) {
            sc.println(n);
            return;
        }

        TreeMap<Long, Integer> counts = new TreeMap<>();
        for (long x : a) {
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }

        long target = m - 1;
        long keptSum = 0;
        int keptCount = 0;

        while (keptSum < target) {
            long limit = keptSum + 1;

            Map.Entry<Long, Integer> entry = counts.floorEntry(limit);

            if (entry == null) break;

            long val = entry.getKey();

            if (val == 0) break;

            keptSum += val;
            keptCount++;

            int count = entry.getValue();
            if (count == 1) {
                counts.remove(val);
            } else {
                counts.put(val, count - 1);
            }
        }

        sc.println(n - keptCount);
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