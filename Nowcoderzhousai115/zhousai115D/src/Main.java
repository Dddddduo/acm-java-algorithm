import java.util.*;
import java.io.*;

public class Main {
    static IoScanner sc = new IoScanner();

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // 优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int current = 0;
        int index = 0;

        while (true) {

            while (index < n && arr[index][0] <= current) {
                pq.offer(arr[index][1]);
                index++;
            }

            while (!pq.isEmpty() && pq.peek() < current) {
                pq.poll();
            }

            if (pq.isEmpty()) {
                break;
            }

            pq.poll();
            current++;
        }

        System.out.println(current);
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
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
}