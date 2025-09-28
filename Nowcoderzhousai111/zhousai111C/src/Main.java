import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        int n = sc.nextInt();
        long k = sc.nextLong();
        int x = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (x == 1 || k == 0) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            return;
        }

        int time = (int)(k % x);

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        for (int i = 0; i < time; i++) {
            int e = list.remove(x - 1);
            list.add(0, e);
        }

        StringBuilder sb = new StringBuilder();

        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        int t = 1;
        // int t = sc.nextInt();  // 如需多组测试用例可取消注释
        while (t-- > 0) {
            solve();
        }
    }
}
