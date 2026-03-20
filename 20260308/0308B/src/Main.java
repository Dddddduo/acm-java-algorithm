import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;
//        t = sc.nextInt();
        多多世界第一可爱:
        for (int i1 = 0; i1 < t; i1++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int i11 = 0; i11 < m; i11++) {
                    arr[i][i11] = -1;
                }
            }
            boolean[][] visited = new boolean[n][m];
            int[][] time = new int[n][m];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});
            visited[x][y] = true;
            time[x][y] = 0;
            int px[]=new int[]{2,2,-2,-2};
            int py[]=new int[]{2,-2,2,-2};
            while (!queue.isEmpty()) {
                int current[] = queue.poll();
                int currentX=current[0];
                int currentY=current[1];
                arr[currentX][currentY]=time[currentX][currentY];
                for (int i = 0; i < 4; i++) {
                    int newX=currentX+px[i];
                    int newY=currentY+py[i];
                    if(newX>=0&&newX<n&&newY>=0&&newY<m&&visited[newX][newY]==false) {
                        queue.offer(new int[]{newX, newY});
                        time[newX][newY]=time[currentX][currentY]+1;
                        visited[newX][newY]=true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int i11 = 0; i11 < m; i11++) {
                    sb.append(arr[i][i11] + " ");
                }
                System.out.println(sb.toString());
            }
        }
    }
}