import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    ;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1] = sc.nextInt();
            }
            int min = 1;
            int max = n;
            int i = 0;
            int j = n - 1;
            while (i < j && (arr[i] == min || arr[j] == max) || (arr[i] == max || arr[j] == min)) {
                if (arr[i] == min) {
                    i++;
                    min++;
                }
                if(i>=n||j<0)break;
                if (arr[i] == max) {
                    i++;
                    max--;
                }
                if(i>=n||j<0)break;
                if (arr[j] == min) {
                    j--;
                    min++;
                }
                if(i>=n||j<0)break;
                if (arr[j] == max) {
                    j--;
                    max--;
                }
                if(i>=n||j<0)break;
            }
            if (i >= j) {
                System.out.println("-1");
            } else {
                System.out.println((i+1) + " " + (j+1));
            }
        }
    }
}