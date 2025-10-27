import java.util.*;

public class Main {

    // 计算列表中的最小值
    private static int getMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // 计算列表中的严格次小值（排除最小值后的最小值）
    private static int getSecondMin(List<Integer> list) {
        int min = getMin(list);
        int secondMin = Integer.MAX_VALUE;
        for (int num : list) {
            if (num > min && num < secondMin) {
                secondMin = num;
            }
        }
        return secondMin;
    }

    // 计算列表中的最大值
    private static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // 计算两个数的最大公约数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 计算列表中所有元素的最大公约数
    private static int multiGcd(List<Integer> list) {
        int currentGcd = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            currentGcd = gcd(currentGcd, list.get(i));
            if (currentGcd == 1) {
                break;
            }
        }
        return currentGcd;
    }

    // 计算列表中所有元素的异或和
    private static int xorSum(List<Integer> list) {
        int res = 0;
        for (int num : list) {
            res ^= num;
        }
        return res;
    }

    // 计算相邻元素的最大公约数之和
    private static int adjacentGcdSum(List<Integer> list) {
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += gcd(list.get(i), list.get(i + 1));
        }
        return res;
    }

    // 计算一个数的因子数量
    private static int countFactors(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    // 计算列表中所有元素的最小公倍数
    private static int multiLcm(List<Integer> list) {
        int currentLcm = list.get(0);
        for (int i = 1; i < list.size()-1; i++) {
            currentLcm = lcm(currentLcm, list.get(i));
        }
        return currentLcm;
    }

    // 计算两个数的最小公倍数
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        // 6层for循环暴力枚举（每位数字范围1-9）
        for (int a1 = 1; a1 <= 9; a1++) {
            for (int a2 = 1; a2 <= 9; a2++) {
                for (int a3 = 1; a3 <= 9; a3++) {
                    for (int a4 = 1; a4 <= 9; a4++) {
                        for (int a5 = 1; a5 <= 9; a5++) {
                            for (int a6 = 1; a6 <= 9; a6++) {
                                List<Integer> list = Arrays.asList(a1, a2, a3, a4, a5, a6);

                                // 条件1：密码包含不止一种数字
                                Set<Integer> set = new HashSet<>(list);
                                if (set.size() == 1) {
                                    continue;
                                }

                                int minVal = getMin(list);
                                int secondMin = getSecondMin(list);
                                int maxVal = getMax(list);

                                // 条件2：min ⊕ second_min == max
                                if ((minVal ^ secondMin) != maxVal) {
                                    continue;
                                }

                                // 条件3：所有数字的gcd等于最小值
                                if (multiGcd(list) != minVal) {
                                    continue;
                                }

                                // 条件4：所有数字的异或和等于次小值
                                if (xorSum(list) != secondMin) {
                                    continue;
                                }

                                // 条件6：最小公倍数的因子数恰好为6
                                int lcmVal = multiLcm(list);
                                if (countFactors(lcmVal) != 6) {
                                    continue;
                                }

                                // 输出符合条件的组合
                                System.out.println(a1 + " " + a2 + " " + a3 + " " + a4 + " " + a5 + " " + a6);
                                return; // 找到第一个符合条件的即退出
                            }
                        }
                    }
                }
            }
        }
    }
}