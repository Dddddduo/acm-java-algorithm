import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt();
        for (int i1 = 0; i1 < t; i1++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(b-a);
        }
    }
}