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
 * https://ac.nowcoder.com/acm/contest/105825/D
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    //    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();
        long[] arr = new long[n];
        boolean judge=false;
        HashSet<Long>hs=new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
            if(arr[i]==0)judge=true;
            hs.add(arr[i]);
        }

        long sum=0;
        if(hs.size()==1){
            sum=0;
        }else if(judge==false){
            sum=-1;
        }else {
            Arrays.sort(arr);
            int cnt=0;
            for (int i = 1; i < arr.length; i++) {
//                dduoln(arr[i]+" "+arr[i-1]);
                if(arr[i]>arr[i-1]){
                    sum+=arr[i]-arr[i-1];
                    cnt++;
                }
            }
//            dduoln(cnt);
            sum-=cnt;
            sum++;
        }

//        int rounds = findMinRounds(arr);

//        dduoln(rounds+" "+sum);
        dduoln(sum);
//        dduoln(rounds==sum);

    }

    public static int findMinRounds(long[] a) {
        int rounds = 0;
        Set<String> visited = new HashSet<>();
        while (true) {
            if (allElementsSame(a)) {
                return rounds;
            }
            String state = Arrays.toString(a);
            if (visited.contains(state))  {
                return -1;
            }
            visited.add(state);
            long mex = calculateMex(a);
            for (int i = 0; i < a.length;  i++) {
                a[i] = Math.max(0,  a[i] - mex);
            }
            rounds++;
        }
    }

    public static boolean allElementsSame(long[] a) {
        long first = a[0];
        for (long num : a) {
            if (num != first) {
                return false;
            }
        }
        return true;
    }

    public static long calculateMex(long[] a) {
        Set<Long> set = new HashSet<>();
        for (long num : a) {
            set.add(num);
        }
        long mex = 0;
        while (set.contains(mex))  {
            mex++;
        }
        return mex;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//         t = sc.nextInt();
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