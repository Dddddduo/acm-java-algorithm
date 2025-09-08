import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Long> ji_list = new ArrayList<>();
            ArrayList<Long> odd_list = new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                long ans = sc.nextLong();
                if ((ans & 1) == 1) {
                    ji_list.add(ans);
                } else {
                    odd_list.add(ans);
                }
            }
            Collections.sort(ji_list);
            Collections.sort(odd_list);
            for (Long l : odd_list) {
                System.out.print(l + " ");
            }
            for (Long l : ji_list) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}