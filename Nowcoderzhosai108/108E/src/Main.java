import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_T = 20000;
    static final int MAX_K = 100;
    static BitSet[] dp = new BitSet[MAX_K + 1];
    static List<Integer> F = new ArrayList<>();
    static List<Integer>[] T_list = new List[MAX_K + 1];

    static int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

    static boolean isSquare(int x) {
        if (x < 0) return false;
        int root = (int) Math.sqrt(x);
        return root * root == x;
    }

    static void precomputeF() {
        for (int i = 1; i <= 141; i++) {
            int x = i * i;
            if (x > MAX_T) continue;
            int s = digitSum(x);
            if (isSquare(s)) {
                F.add(x);
            }
        }
    }

    static void precomputeDp() {
        for (int k = 0; k <= MAX_K; k++) {
            dp[k] = new BitSet(MAX_T + 1);
            T_list[k] = new ArrayList<>();
        }
        dp[0].set(0);
        for (int k = 1; k <= MAX_K; k++) {
            dp[k].clear();
            for (int x : F) {
                if (x > MAX_T) continue;
                dp[k].or(dp[k - 1].get(x, MAX_T + 1));
            }
        }
        for (int k = 0; k <= MAX_K; k++) {
            for (int t = 0; t <= MAX_T; t++) {
                if (dp[k].get(t)) {
                    T_list[k].add(t);
                }
            }
            Collections.sort(T_list[k]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        precomputeF();
        precomputeDp();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int S = 0;
            boolean allOne = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                S += a[i];
                if (a[i] != 1) allOne = false;
            }
            if (n == 1) {
                if (Collections.binarySearch(F, a[0]) >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            if (allOne) {
                int count = 0;
                for (int num : a) {
                    if (Collections.binarySearch(F, num) >= 0) {
                        count++;
                    }
                }
                System.out.println(count);
                continue;
            }
            int ans = 0;
            int maxK = Math.min(n, 100);
            for (int k = maxK; k >= 0; k--) {
                if (k == n) {
                    int idx = Collections.binarySearch(T_list[k], S);
                    if (idx >= 0) {
                        ans = k;
                        break;
                    }
                } else {
                    int L = k;
                    int R = S - (n - k);
                    if (R < L) continue;
                    int idx = Collections.binarySearch(T_list[k], L);
                    if (idx < 0) idx = -idx - 1;
                    if (idx < T_list[k].size() && T_list[k].get(idx) <= R) {
                        ans = k;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}