import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // 读取数组元素
        // 注意：虽然单个元素最大 1e9 (int范围内)，但累加和可能会超过 int，所以用 long 存储和
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        // 滑动窗口初始化
        int left = 0;
        int right = 0;
        long currentSum = 0;
        long currentXor = 0;
        int maxLen = 0;

        // 开始滑动
        while (right < n) {
            // 1. 进窗：将右边的元素加入
            currentSum += a[right];
            currentXor ^= a[right];

            // 2. 出窗：如果条件不满足（和 != 异或和），说明有冲突（进位）
            // 需要收缩左边界，直到条件再次满足
            while (left <= right && currentSum != currentXor) {
                currentSum -= a[left];
                currentXor ^= a[left];
                left++;
            }

            // 3. 更新最大长度
            // 此时窗口 [left, right] 是合法的
            maxLen = Math.max(maxLen, right - left + 1);

            // 继续向右移动
            right++;
        }

        System.out.println(maxLen);
    }
}