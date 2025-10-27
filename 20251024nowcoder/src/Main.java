import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int maxK = 1;
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                if (i <= a && i > maxK) {
                    maxK = i;
                }
                int j = n / i;
                if (j <= a && j > maxK) {
                    maxK = j;
                }
            }
        }
        System.out.println(a - maxK);
    }
}