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
 *
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {

        int n=sc.nextInt();
        int m=sc.nextInt();

        char arr[][]=new char[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            String str=" "+sc.next();
            arr[i]=str.toCharArray();
        }

        ArrayList<ArrayList<ArrayList<int[]>>> adj =new ArrayList<>();

        for (int i = 0; i < n + 5; i++) {
            ArrayList<ArrayList<int[]>>list = new ArrayList<>();
            for (int i1 = 0; i1 < m + 5; i1++) {
                list.add(new ArrayList<>());
            }
            adj.add(list);
        }

        // true 困不了
        // false 被困住
        boolean visited[][]=new boolean[n+2][m+2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(arr[i][j]=='U'){
                    adj.get(i-1).get(j).add(new int[]{i,j});
                } else if(arr[i][j]=='D'){
                    adj.get(i+1).get(j).add(new int[]{i,j});
                } else if(arr[i][j]=='L'){
                    adj.get(i).get(j-1).add(new int[]{i,j});
                } else if(arr[i][j]=='R'){
                    adj.get(i).get(j+1).add(new int[]{i,j});
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // 困不住
        for (int i = 0; i <= n+1; i++) {
            queue.add(new int[]{i,0});
            visited[i][0]=true ;
        }
        for (int i = 0; i <= n+1; i++) {
            queue.add(new int[]{i,m+1});
            visited[i][m+1]=true ;
        }
        for (int j = 0; j <= m+1; j++) {
            queue.add(new int[]{0,j});
            visited[0][j]=true ;
        }
        for (int j = 0; j <= m+1; j++) {
            queue.add(new int[]{n+1,j});
            visited[n+1][j]=true ;
        }

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x=poll[0];int y=poll[1];
            for (int[] a : adj.get(x).get(y)) {
                int newx = a[0];
                int newy = a[1];
                if(visited[newx][newy]==false){
                    visited[newx][newy]=true;
                    queue.add(new int[]{newx,newy});
                }
            }
        }

        // 理论上这是一种贪心
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == '?' &&
                        visited[i - 1][j]&&
                        visited[i][j + 1] &&
                        visited[i + 1][j] &&
                        visited[i][j - 1]) {
                    visited[i][j] = true;
                }
            }
        }

//        for (int i = 0; i < n+2; i++) {
//            for (int i1 = 0; i1 < m + 2; i1++) {
//                dduo(visited[i][i1]+" ");
//            }
//            dduoln();
//        }

        int cnt=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(!visited[i][j]){
                    cnt++;
                }
            }
        }
        dduoln(cnt);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
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