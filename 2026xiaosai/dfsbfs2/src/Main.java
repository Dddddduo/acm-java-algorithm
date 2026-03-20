import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Dduo {
    String author() default "";

    String description() default "";

    String version() default "";

    String slogan() default "Dduo is the cutest girl in the world!";
}

@Dduo(
        author = "Dduo from bhu-acm",
        description = "coding by Dduo from bhu-acm",
        version = "1.0"
)
public class Main {

    private static DduoScanner sc = new DduoScanner();
//    private static final long MOD = (long) (1e9 + 7);
//    private static final long MOD = (long) (998244353);

    private static int n;
    private static int arr[];
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();
    private static int dx[] = {0, 1, 0, -1};
    private static int dy[] = {1, 0, -1, 0};

    private static void solve() throws IOException {
        int n=sc.nextInt();
        int m=sc.nextInt();
        char map[][]=new char[n][m];
        for (int i1 = 0; i1 < n; i1++) {
            String str=sc.next();
            map[i1]=str.toCharArray();
        }

        int firstX=-1,firstY=-1;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i = 0; i < m; i++) {
                if(map[i1][i]=='s') {
                    firstX=i1;
                    firstY=i;
                    break;
                }
            }
        }

        int dx[]=new int[]{1,-1,0,0};
        int dy[]=new int[]{0,0,1,-1};

        boolean visited[][]=new boolean[n][m];
        visited[firstX][firstY]=true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{firstX, firstY});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i1 = 0; i1 < 4; i1++) {
                int newX = poll[0] + dx[i1];
                int newY = poll[1] + dy[i1];
                if(newX<0||newX>=n||newY<0||newY>=m)continue;
                if(visited[newX][newY])continue;
                if(map[newX][newY]=='x') continue;
                if(map[newX][newY]=='t'){
                    sc.println("YES");
                    return;
                }
                queue.add(new int[]{newX, newY});
                visited[newX][newY]=true;
            }
        }

        sc.println("NO");

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        // 默认开启多组输入
        t = sc.nextInt();
        多多世界第一可爱:
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }

}

@Dduo(
        author = "Dduo",
        description = "Java快速流模版",
        version = "1.0"
)
class DduoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public DduoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    protected String nextLine() throws IOException {
        return bf.readLine();
    }

    protected String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    protected char nextChar() throws IOException {
        return next().charAt(0);
    }

    protected int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    protected long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    protected double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    protected float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    protected BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    protected BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }

    protected void println(int a) throws IOException {
        print(a);
        println();
    }

    protected void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(String a) throws IOException {
        print(a);
        println();
    }

    protected void print(String a) throws IOException {
        bw.write(a);
    }

    protected void println(long a) throws IOException {
        print(a);
        println();
    }

    protected void print(long a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(double a) throws IOException {
        print(a);
        println();
    }

    protected void print(double a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void print(BigInteger a) throws IOException {
        bw.write(a.toString());
    }

    protected void println(BigInteger a) throws IOException {
        bw.write(a.toString());
        println();
    }

    protected void print(char a) throws IOException {
        bw.write(String.valueOf(a));
    }

    protected void println(char a) throws IOException {
        print(a);
        println();
    }

    protected void println() throws IOException {
        bw.newLine();
    }

    //其他调试命令：
    protected void flush() throws IOException {
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    protected boolean hasNext() throws IOException {
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}