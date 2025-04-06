import java.util.Scanner;

public class Main {

    static int[][] d = new int[1010][1010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m, Q;
        n = sc.nextInt();
        m = sc.nextInt();
        Q = sc.nextInt();

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i == j){
                    d[i][j] = 0;
                }
                else {
                    d[i][j] = (int) 1e9;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            d[a][b] = d[b][a] = 1;
        }

        // Floyd算法
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);


        double ans = 0;
        for (int i = 0; i < Q; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            for (int j = 1; j <= n; j++){
                if (d[x][j] <= y) {
                    ans = ans + 1;
                }
            }
        }

        System.out.printf("%.2f", ans / Q);
    }
}