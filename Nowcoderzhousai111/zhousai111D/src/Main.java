import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        // 结论:奇数位数字之和与偶数位数字之和的差是11的倍数能被11整除
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 存储每个数的长度是否为偶数，以及其奇偶位差mod 11的值
        boolean[] isEven = new boolean[n];
        int[] dArray = new int[n];

        for (int i = 0; i < n; i++) {
            String s = String.valueOf(arr[i]);
            int len = s.length();
            int sOdd = 0, sEven = 0;

            // 计算奇数位和与偶数位和
            for (int j = 0; j < len; j++) {
                int digit = s.charAt(j) - '0';
                int pos = j + 1;
                if (pos % 2 == 1) { // 奇数位
                    sOdd += digit;
                } else { // 偶数位
                    sEven += digit;
                }
            }

            // 计算奇偶位差，并调整为0-10之间的数
            int diff = sOdd - sEven;
            int d = (diff % 11 + 11) % 11;

            isEven[i] = (len % 2 == 0);
            dArray[i] = d;
        }

        // 统计不同奇偶位差的数量（按长度奇偶分类）
        int[] cntEven = new int[11]; // 长度为偶数的数的奇偶位差计数
        int[] cntOdd = new int[11];  // 长度为奇数的数的奇偶位差计数
        for (int i = 0; i < n; i++) {
            if (isEven[i]) {
                cntEven[dArray[i]]++;
            } else {
                cntOdd[dArray[i]]++;
            }
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            boolean evenB = isEven[i];
            int dB = dArray[i];

            // 计算A为偶数长度时的符合条件的数量
            int targetEven = (11 - dB) % 11;
            long evenPart = cntEven[targetEven];
            // 减去自身（如果B自身是偶数长度且符合条件）
            if (evenB && dB == targetEven) {
                evenPart--;
            }

            // 计算A为奇数长度时的符合条件的数量
            int targetOdd = dB;
            long oddPart = cntOdd[targetOdd];
            // 减去自身（如果B自身是奇数长度且符合条件）
            if (!evenB && dB == targetOdd) {
                oddPart--;
            }

            total += evenPart + oddPart;
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }
}
