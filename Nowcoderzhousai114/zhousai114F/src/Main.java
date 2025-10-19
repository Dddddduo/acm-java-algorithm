import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {

//        long testStart = 100000000;
//        long testEnd = 999999999;
//        System.out.println("开始搜索...（范围：" + testStart + " ~ " + testEnd + "）");
//        long count = 0;
//        for (long a = testStart; a <= testEnd; a++) {
//            for (long b = a; b <= testEnd; b++) {
//                count++;
//                BigInteger product = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
//                if (checkProduct(product)==true) {
//                    System.out.println(a + " × " + b + " = " + product);
//                    return;
//                }
//            }
//        }

        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < n - 2; i++) {
            sb.append(0);
        }
        sb.append(1);
        String num1=sb.toString();

        if(n%2==0){
            sb = new StringBuilder();
            for (int i = 0; i < n; i+=2) {
                sb.append("12");
            }
            String num2 = sb.toString();
            System.out.println(num1+" "+num2);
        }else {
            if(n==3){
                System.out.println(num1+" 131");
            }else{
                sb = new StringBuilder();
                for (int i = 0; i < n-3; i+=2) {
                    sb.append("12");
                }
                sb.append("312");
                String num2 = sb.toString();
                System.out.println(num1+" "+num2);
            }
        }



    }

    // 检查乘积是否符合条件（仅含1、2、3，无连续相同字符，且同时存在1、2、3）
    private static boolean checkProduct(BigInteger product) {
        String numStr = product.toString();
        boolean has1 = false;
        boolean has2 = false;
        boolean has3 = false;

        for (char c : numStr.toCharArray()) {
            if (c < '1' || c > '3') {
                return false;
            }
            if (c == '1') {
                has1 = true;
            } else if (c == '2') {
                has2 = true;
            } else if (c == '3') {
                has3 = true;
            }
        }
        if (!has1 || !has2 || !has3) {
            return false;
        }
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) == numStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
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
