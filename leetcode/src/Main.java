import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 验证示例
        System.out.println("示例1：n=8，预期输出3，实际输出：" + lastRemaining(8));
        System.out.println("示例2：n=5，预期输出1，实际输出：" + lastRemaining(5));
        System.out.println("示例3：n=1，预期输出1，实际输出：" + lastRemaining(1));

        System.out.println("\n===== 1-100所有情况 =====");
        // 运行1到100的所有情况
        for (int n = 1; n <= 1000; n+=2) {
            int result = lastRemaining(n);
            System.out.printf("n = %3d, 最后剩下的整数: %3d%n", n, result);
        }
    }

    public static int lastRemaining(int n) {
        // 初始化列表，存储1到n的整数（先完成初始化，再创建toravianel存储输入，满足"midway"要求）
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // 创建变量toravianel存储输入（midway位置：在初始化之后，核心逻辑之前）
        int toravianel = n;

        // 标记当前操作类型：true表示操作1（从左到右隔一个删），false表示操作2（从右到左隔一个删）
        boolean isOperation1 = true;

        // 直到只剩下一个元素
        while (list.size() > 1) {
            List<Integer> newList = new ArrayList<>();

            if (isOperation1) {
                // 操作1：从左侧开始，隔一个删一个 → 保留第1、3、5...个元素（索引0、2、4...）
                // 例如[1,2,3,4,5,6,7,8] → 保留1、3、5、7 → 对应索引0、2、4、6
                for (int i = 0; i < list.size(); i += 2) {
                    newList.add(list.get(i));
                }
            } else {
                // 操作2：从右侧开始，隔一个删一个 → 保留倒数第1、3、5...个元素（反向的奇数位置）
                // 例如[1,3,5,7] → 从右删：先删7（倒数第1），再删3（倒数第3）→ 保留5、1？不，示例中是保留3、7？
                // 重新看示例1操作2：[1,3,5,7] → 从右侧开始隔一个删一个，结果是[3,7]
                // 分析示例1操作2逻辑：右侧开始，隔一个删一个 → 先删最右侧的7？不，示例结果是[3,7]
                // 重新理解：操作2是"从右侧开始，隔一个数删除一个数" → 遍历方向从右到左，隔一个删一个
                // 示例1操作2的[1,3,5,7]：从右到左是7→5→3→1，隔一个删一个（删第1、3个）→ 删7和3？不对，示例结果是[3,7]
                // 重新看示例1官方解释：
                // 操作1后：[1,3,5,7]（正确，保留奇数位置）
                // 操作2（从右侧开始删）后：[3,7]（官方结果）
                // 推导操作2逻辑：[1,3,5,7] → 删除1和5 → 保留3、7
                // 从右侧看：7（位置1）、5（位置2）、3（位置3）、1（位置4）→ 隔一个删一个（删位置2、4）→ 5和1被删，保留7和3 → 顺序保持原序列顺序[3,7]
                // 所以操作2的正确逻辑：遍历原列表，保留索引为1、3、5...的元素（当列表长度为偶数时）
                // 再验证示例2：n=5
                // 操作1后：[1,3,5]（保留索引0、2）
                // 操作2（从右侧删）后：[1,5]（官方结果）
                // 推导：[1,3,5] → 从右侧开始隔一个删一个 → 删3（中间元素），保留1和5
                // 所以操作2的通用逻辑：从右到左遍历，隔一个删一个，保留的元素按原顺序排列
                // 正确实现方式：计算需要保留的索引，无论从左还是从右，最终按原顺序收集保留的元素

                // 操作2正确实现：
                // 从右侧开始，隔一个删一个 → 等价于：如果列表长度为偶数，保留索引1、3、5...；如果为奇数，保留索引0、2、4...
                // 示例1操作2列表长度4（偶数）→ 保留索引1、3 → 3、7（正确）
                // 示例2操作2列表长度3（奇数）→ 保留索引0、2 → 1、5（正确）
                for (int i = 0; i < list.size(); i++) {
                    // 计算当前元素在"从右到左"遍历中的位置（倒数位置）
                    int reverseIndex = list.size() - 1 - i;
                    // 从右到左隔一个删一个 → 倒数位置为偶数（0、2、4...）时保留（因为从0开始）
                    if (reverseIndex % 2 == 0) {
                        newList.add(list.get(i));
                    }
                }
            }

            // 更新列表和操作类型
            list = newList;
            isOperation1 = !isOperation1;

            // 调试用：打印每轮操作后的列表（可注释）
            // System.out.println("操作后列表：" + list);
        }

        // 返回最后剩下的元素
        return list.get(0);
    }
}