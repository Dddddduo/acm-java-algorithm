import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        多多世界第一可爱:
        for (int tt = 0; tt < t; tt++) {
            long sum = 0;
            int n = sc.nextInt();
            long arr[] = new long[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1] = sc.nextLong();
                if (i1 % 2 == 0) sum += arr[i1];
                else sum -= arr[i1];
            }

            if(n==1){
                System.out.println(sum);
                continue 多多世界第一可爱;
            }

            long result = sum;

            long temp = n % 2 == 0 ? n - 2 : n - 1;
            result = Math.max(result, sum + temp);

            long ans = 2 * arr[0] + 1;
            for (int i1 = 0; i1 < n; i1++) {
                if (i1 % 2 == 0) {
                    ans = Math.min(ans, 2 * arr[i1] + (i1 + 1));
                }
                if (i1 % 2 == 1) {
                    result = Math.max(result, sum - ans + 2 * arr[i1] + (i1 + 1));
                }
            }

            ans = 2 * arr[1] - 2;
            for (int i1 = 0; i1 < n; i1++) {
                if (i1 % 2 == 1) {
                    ans = Math.max(ans, 2 * arr[i1] - (i1 + 1));
                }
                if (i1 % 2 == 0) {
                    result = Math.max(result, sum + ans - 2 * arr[i1] + (i1 + 1));
                }
            }

            System.out.println(result);
        }
    }
}