import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + a;
        }

        int ans = Integer.MIN_VALUE;
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(0);

        for (int i = 1; i <= n; i++) {
            while (!q.isEmpty() && i - q.peekFirst() > m) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, (int) (sum[i] - sum[q.peekFirst()]));
            }
            while (!q.isEmpty() && sum[q.peekLast()] >= sum[i]) {
                q.pollLast();
            }
            q.addLast(i);
        }

        System.out.println(ans);
        br.close();
    }
}