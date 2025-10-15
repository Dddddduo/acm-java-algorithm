import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        String s = scanner.next();
        scanner.close();

        long ans = 0;
        ans = Math.max(ans, get(s, n, m, 0));
        ans = Math.max(ans, get(s, n, m, 1));

        System.out.println(ans);
    }

    private static long get(String s, long n, long m, int target) {
        long res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0;
        for (int r = 0; r < n; r++) {
            int num = s.charAt(r) - '0';
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            while (l <= r && cnt.getOrDefault(target, 0) > m) {
                int leftNum = s.charAt(l) - '0';
                cnt.put(leftNum, cnt.get(leftNum) - 1);
                if (cnt.get(leftNum) == 0) {
                    cnt.remove(leftNum);
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
