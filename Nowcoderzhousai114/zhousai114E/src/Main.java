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


    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        long a=sc.nextInt();
        long b=sc.nextInt();
        long c=sc.nextInt();

        if(b>a||c>a){
            System.out.println("-1");
            return;
        }

        long n=a+2;
        long arr[]=new long[(int)n];

        arr[0]=2;
        arr[1]=3;

        for(int i=2;i<n;i++){
            if(a==b+c){
                // 构造和为2的倍数的子数组但不是3的倍数的数
                if (b != 0) {
                    long sumPrev = arr[i - 1] + arr[i - 2];
                    long total = sumPrev;
                    // 找到第一个是2的倍数且不是3的倍数的total
                    do {
                        total++;
                    } while (total % 2 != 0 || total % 3 == 0);
                    arr[i] = total - sumPrev;
                    a--;
                    b--;
                }
                // 构造和为3的倍数的子数组但不是2的倍数的数
                else if (c != 0) {
                    long sumPrev = arr[i - 1] + arr[i - 2];
                    long base = (sumPrev / 3 + 1) * 3;
                    long ans = (base % 2 == 0) ? base + 3 : base;
                    arr[i] = ans - sumPrev;
                    a--;
                    c--;
                }
            }else if(a<b+c){
                // 构造和为6的子数组
                long ans = (((arr[i-1]+arr[i-2])/6)+1)*6;
                arr[i]=ans-arr[i-1]-arr[i-2];
                a--;
                b--;
                c--;
            }
            else if (a > b + c) {
                // 构造和为5的倍数，但不是2或3的倍数的子数组
                long sumPrev = arr[i - 1] + arr[i - 2];
                long base = ((sumPrev / 5) + 1) * 5;
                while (base % 2 == 0 || base % 3 == 0) {
                    base += 5;
                }
                arr[i] = (int) (base - sumPrev);
                a--;
            }
        }

        System.out.println(n);
        StringBuilder sb=new StringBuilder();
        for (long i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
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