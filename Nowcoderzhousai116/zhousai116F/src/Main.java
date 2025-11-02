import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] a = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long requiredIntervals = 0;
        for (int i = 1; i <= n; i++) {
            long diff = a[i] - a[i - 1];
            if (diff > 0) {
                requiredIntervals += diff;
            }
        }

        if (requiredIntervals != m) {
            pw.println(-1);
            pw.flush();
            return;
        }

        Deque<Integer> openStarts = new ArrayDeque<>();
        List<Pair> solutions = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            long diff = a[i] - a[i - 1];

            if (diff > 0) {
                for (int k = 0; k < diff; k++) {
                    openStarts.push(i);
                }
            } else if (diff < 0) {
                long numToClose = -diff;
                for (int k = 0; k < numToClose; k++) {
                    int startL = openStarts.pop();
                    solutions.add(new Pair(startL, i - 1));
                }
            }
        }

        while (!openStarts.isEmpty()) {
            int startL = openStarts.pop();
            solutions.add(new Pair(startL, n));
        }

        for (Pair p : solutions) {
            pw.println(p.first + " " + p.second);
        }

        pw.flush();
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}