import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long k = sc.nextInt();

        if ((n - k) % 2 != 0) {
            System.out.println("-1");
            return;
        }

        if (k == 0) {
            for (long l = 0; l < n; l++) {
                System.out.print("1 ");
            }
            return;
        }

        int temp=1;
        for (; temp < k+1; temp++) {
            System.out.print(temp+" ");
        }

        temp++;

        for (long l = 0; l < n - k; l++) {
            System.out.print(temp+" ");
        }

    }
}