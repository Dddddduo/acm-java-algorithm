import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAXN = 200200;
    static String[] arr = new String[MAXN];
    static int[] len = new int[MAXN];
    static int[] zrr = new int[MAXN];
    static int n;
    static int m;

    // 有多少个0
    static void build() {
        Arrays.fill(zrr, 0);
        for (int i = 0; i < n; ++i) {
            len[i] = arr[i].length();
            for (int j = len[i] - 1; j >= 0 && arr[i].charAt(j) == '0'; --j) {
                ++zrr[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.next();
            }
            build();
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += len[i] - zrr[i];
            }
            Arrays.sort(zrr, 0, n);
            for (int left = 0, right = n - 1; left < right; left++, right--) {
                int temp = zrr[left];
                zrr[left] = zrr[right];
                zrr[right] = temp;
            }
            for (int i = 0; i < n; ++i) {
                if ((i & 1) == 1) {
                    ans += zrr[i];
                }
            }
            System.out.println((ans - 1 >= m) ? "Sasha" : "Anna");
        }
        scanner.close();
    }
}