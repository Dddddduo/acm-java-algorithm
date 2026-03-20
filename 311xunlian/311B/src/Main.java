import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 读取第一行参数
        if (!sc.hasNext()) return;
        double v0 = sc.nextDouble(); // 初始速度
        double mu = sc.nextDouble(); // 摩擦系数
        int n = sc.nextInt();        // 轨道段数

        // 2. 读取起点坐标
        double prevX = sc.nextDouble();
        double prevY = sc.nextDouble();

        // 3. 维护当前速度的平方 (v^2)
        // 使用平方计算避免频繁开根号，提高精度和效率
        double currentV2 = v0 * v0;
        double g = 9.8;

        boolean isStopped = false;

        // 4. 逐段处理
        for (int i = 0; i < n; i++) {
            double currX = sc.nextDouble();
            double currY = sc.nextDouble();

            // 计算位移差
            double dx = currX - prevX;      // 水平位移
            double dy = prevY - currY;      // 高度落差 (注意：前 - 后，向下为正)

            // 动能定理更新 v^2
            // v^2_new = v^2_old + 2*g*h - 2*mu*g*dx
            double gravityEffect = 2 * g * dy;
            double frictionLoss = 2 * mu * g * dx;

            currentV2 = currentV2 + gravityEffect - frictionLoss;

            // 5. 检查是否停止
            // 如果速度平方小于 0 (或极小值)，说明动能耗尽
            if (currentV2 < 0) {
                isStopped = true;
                // 即使停下了，也可以选择 break 跳出，或者把剩余输入读完
                // 为了逻辑简单，直接标记并跳出
                break;
            }

            // 更新坐标，准备下一段
            prevX = currX;
            prevY = currY;
        }

        // 6. 输出结果
        if (isStopped) {
            System.out.println("0.00");
        } else {
            // 开根号得到速度，保留两位小数
            System.out.printf("%.2f%n", Math.sqrt(currentV2));
        }

        sc.close();
    }
}