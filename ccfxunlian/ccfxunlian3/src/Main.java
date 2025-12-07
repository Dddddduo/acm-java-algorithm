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

        int[] arr1 = new int[4];
        int[] arr2 = new int[4];

        for (int i = 0; i < 4; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] result1 = getArr(arr1);
        int[] result2 = getArr(arr2);

        int totalCombinations = 13 * 13;

        int winCount = 0;
        winCount += result1[2] * (result2[1] + result2[0]);
        winCount += result1[1] * result2[0];

        int tieCount = 0;
        tieCount += result1[2] * result2[2];
        tieCount += result1[1] * result2[1];
        tieCount += result1[0] * result2[0];

        int loseCount = 0;
        loseCount += result1[0] * (result2[1] + result2[2]);
        loseCount += result1[1] * result2[2];

        String resWin = formatFraction(winCount, totalCombinations);
        String resTie = formatFraction(tieCount, totalCombinations);
        String resLose = formatFraction(loseCount, totalCombinations);

        sc.println(resWin + " " + resTie + " " + resLose);
    }

    private static int getHandType(int[] hand) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int card : hand) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(counts.values());
        int maxCount = Collections.max(values);

        if (maxCount >= 4) {
            return 2;
        }
        if (values.contains(3) && values.contains(2)) {
            return 1;
        }
        return 0;
    }

    private static int[] getArr(int[] initialCards) {
        int[] dist = new int[3];
        for (int card = 1; card <= 13; card++) {
            int[] hand = new int[5];
            System.arraycopy(initialCards, 0, hand, 0, 4);
            hand[4] = card;
            int type = getHandType(hand);
            dist[type]++;
        }
        return dist;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static String formatFraction(int num, int den) {
        if (num == 0) {
            return "0/1";
        }
        int commonDivisor = gcd(Math.abs(num), Math.abs(den));
        return (num / commonDivisor) + "/" + (den / commonDivisor);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
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