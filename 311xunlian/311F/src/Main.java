import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 使用 Scanner 读取输入
        Scanner sc = new Scanner(System.in);

        // 检查是否有输入，防止空数据报错
        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            // 使用 long 数组存储价格，虽然单个价格 int 够用，但为了防止计算时溢出，统一定义较好
            // 另外题目中价格高达 10^9，用 long 比较保险
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextLong();
            }

            // 1. 排序
            // Arrays.sort 默认是升序排序 (从小到大: 10, 20, 30...)
            Arrays.sort(p);

            long totalCost = 0;
            int count = 0;

            // 2. 贪心计算
            // 我们需要从最贵的开始分组，所以从数组的最后往前遍历 (从大到小)
            for (int i = n - 1; i >= 0; i--) {
                count++;

                // 每数到第 3 个罐头，这个罐头就是这一组 3 个里最便宜的 -> 免费
                if (count % 3 == 0) {
                    continue; // 跳过累加，相当于免费
                }

                // 否则，需要支付这个罐头的钱
                totalCost += p[i];
            }

            // 输出结果
            System.out.println(totalCost);
        }

        sc.close();
    }
}