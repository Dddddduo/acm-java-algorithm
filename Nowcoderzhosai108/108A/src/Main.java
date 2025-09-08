import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();
        if (s < 425 && ((s1 < 60) || (s2 < 60) || (s3 < 60))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}