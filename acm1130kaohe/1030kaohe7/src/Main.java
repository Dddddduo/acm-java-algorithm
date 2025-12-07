import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
    static int n;
    static int ans[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {

        int n = sc.nextInt();
        int m = sc.nextInt();

        String str1 = sc.next();
        String str2 = sc.next();

        int lcm = lcm(n, m);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < lcm / n; i++) {
            sb1.append(str1);
        }

        for (int i = 0; i < lcm / m; i++) {
            sb2.append(str2);
        }


        BigInteger b = new BigInteger("1"+sb1.toString()).subtract(new BigInteger("1"+sb2.toString()));
        if(b.compareTo(BigInteger.ZERO)>=0){
            sc.println(lcm);
            for (int i = 0; i < lcm - b.toString().length(); i++) {
                sc.print("0");
            }
            sc.println(b);
        }else{
            StringBuilder ans1=new StringBuilder("2");
            ans1.append(sb1);
            StringBuilder ans2=new StringBuilder("1");
            ans2.append(sb2);
            BigInteger subtract = new BigInteger(ans1.toString()).subtract(new BigInteger(ans2.toString())).subtract(BigInteger.ONE);
            sc.println(lcm);
            for (int i = 0; i < lcm - subtract.toString().length(); i++) {
                sc.print("0");
            }
            sc.println(subtract);

        }

    }

    /**
     * 欧几里得算法求最大公约数（GCD）
     * @param a 第一个数
     * @param b 第二个数
     * @return 最大公约数
     */
    public static int gcd(int a, int b) {
        // 处理负数（取绝对值），避免计算错误
        a = Math.abs(a);
        b = Math.abs(b);

        // 欧几里得核心：辗转相除，直到余数为0，此时的除数就是GCD
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * 求最小公倍数（LCM）
     * @param a 第一个数
     * @param b 第二个数
     * @return 最小公倍数（若两数都为0，返回0）
     */
    public static int lcm(int a, int b) {
        // 处理特殊情况：两数都为0时，无最小公倍数，返回0
        if (a == 0 && b == 0) {
            return 0;
        }
        // 公式：LCM(a,b) = |a*b| / GCD(a,b)
        return Math.abs(a * b) / gcd(a, b);
    }


    public static void main(String[] args) throws Exception {
        int t = 1;
        // t = sc.nextInt();
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

    public void flush() throws IOException {
        bw.flush();
    }

    public boolean hasNext() throws IOException {
        return bf.ready();
    }

}