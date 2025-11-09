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
        int k = sc.nextInt();

        Long x[]=new Long[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
        }

        int m = (n + k - 1) / k;

        Long[] sortedX = x.clone();
        Arrays.sort(sortedX);
        reverse(sortedX);
        Set<Long> keySet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            keySet.add(sortedX[i]);
        }

        Deque<Long> stack = new ArrayDeque<>();
        List<Long> output = new ArrayList<>();
        int inputIndex = 0;

        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                if (!stack.isEmpty() && keySet.contains(stack.peek())) {
                    output.add(stack.pop());
                } else {
                    while (inputIndex < n) {
                        if (keySet.contains(x[inputIndex])) {
                            output.add(x[inputIndex]);
                            inputIndex++;
                            break;
                        } else {
                            stack.push(x[inputIndex]);
                            inputIndex++;
                        }
                    }
                    if (inputIndex >= n && !stack.isEmpty()) {
                        output.add(stack.pop());
                    }
                }
            } else {
                if (!stack.isEmpty() && !keySet.contains(stack.peek())) {
                    output.add(stack.pop());
                } else {
                    while (inputIndex < n) {
                        if (!keySet.contains(x[inputIndex])) {
                            output.add(x[inputIndex]);
                            inputIndex++;
                            break;
                        } else {
                            stack.push(x[inputIndex]);
                            inputIndex++;
                        }
                    }
                    if (inputIndex >= n && !stack.isEmpty()) {
                        output.add(stack.pop());
                    }
                }
            }
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                total += output.get(i);
            }
        }
        sc.println(total);

        StringBuilder sb = new StringBuilder();
        for (Long num : output) {
            sb.append(num).append(" ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        sc.println(sb.toString());

    }

    private static void reverse(Long[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Long temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
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

    public void println(int a) throws IOException{
        print(a);
        println();
    }

    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException{
        print(a);
        println();
    }

    public void print(String a) throws IOException{
        bw.write(a);
    }

    public void println(long a) throws IOException{
        print(a);
        println();
    }

    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException{
        print(a);
        println();
    }

    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException{
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException{
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException{
        print(a);
        println();
    }

    public void println() throws IOException{
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}