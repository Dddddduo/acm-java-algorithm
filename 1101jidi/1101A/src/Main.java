import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // 素数表
    static List<Long> primes = Arrays.asList(
            2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L,
            31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L,
            73L, 79L, 83L, 89L, 97L, 101L, 103L, 107L, 109L, 113L,
            127L, 131L, 137L, 139L, 149L, 151L, 157L, 163L, 167L, 173L,
            179L, 181L, 191L, 193L, 197L, 199L, 211L, 223L, 227L, 229L,
            233L, 239L, 241L, 251L, 257L, 263L, 269L, 271L, 277L, 281L
    );

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        int n = sc.nextInt();
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        for (Long prime : primes) {
            long cnt=0;
            for (long l : arr) {
                if(l%prime==0){
                    cnt++;
                }
            }
            if(cnt==n)continue;
            System.out.println(prime);
            return;
        }

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
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
}