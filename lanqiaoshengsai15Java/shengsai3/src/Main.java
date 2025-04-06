import java.io.*;
import java.math.*;
import java.util.*;

// 分布式队列
public class Main {

    static Scanner sc = new Scanner(System.in);
    static final long MOD = (long) (1e9+7);

    public static void solve() throws IOException {

        int n=sc.nextInt();

        // 主节点的数字
        int ans1=0;

        // 其余结点
        int arr[]=new int[n-1];
        while(sc.hasNext()) {
            String str=sc.next();
            if(str.equals("add")) {
                // 添加
                int k = sc.nextInt();
                ans1++;
            }else if(str.equals("sync")){
                // 同步
                int k = sc.nextInt()-1;
                if(arr[k]<ans1) {
                    arr[k]++;
                }
            }else if(str.equals("query")) {
                // 查询
                int ans=Integer.MAX_VALUE;
                for(int j=0;j<n-1;j++) {
                    ans=Math.min(ans, arr[j]);
                }
                System.out.println(ans);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {solve();}
    }

}