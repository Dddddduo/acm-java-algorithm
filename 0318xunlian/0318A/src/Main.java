import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t=sc.nextInt();
        for (int i1 = 0; i1 < t; i1++) {
            int n=sc.nextInt();
            long m=sc.nextLong();
            Long arr[]=new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextLong();
            }
            Arrays.sort(arr,Collections.reverseOrder());
            long sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i]*m;
                m--;
                if(m==0)break;
            }
            System.out.println(sum);
        }
    }
}