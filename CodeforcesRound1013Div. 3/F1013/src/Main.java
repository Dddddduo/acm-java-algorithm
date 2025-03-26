import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt();
        while (t-->0){
            solve();
        }
    }

    static void solve() {

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        long[] f = new long[m];
        long[] g = new long[m];
        long[] pref = new long[m + 1];
        long[] preg = new long[m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    if (i == 0) {
                        f[j] = 1;
                    } else {
                        int l = Math.max(0, j - (d - 1));
                        int r = Math.min(m, j + 1 + (d - 1));
                        f[j] = pref[r] - pref[l] + preg[r] - preg[l];
                    }
                } else {
                    f[j] = 0;
                }
            }

            for (int j = 0; j < m; j++) {
                pref[j + 1] = pref[j] + f[j];
            }

            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    int l = Math.max(0, j - d);
                    int r = Math.min(m, j + 1 + d);
                    g[j] = pref[r] - pref[l] - f[j];
                } else {
                    g[j] = 0;
                }
            }

            for (int j = 0; j < m; j++) {
                preg[j + 1] = preg[j] + g[j];
            }
        }

        long ans = pref[m] + preg[m];
        System.out.println(ans);

    }

}