import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt();
        for (int i1 = 0; i1 < t; i1++) {
            int n=sc.nextInt();
            long arr[]=new long[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextLong();
            }

            long result[]=new long[n];
            for(int i=1;i<n-1;i++){
                result[i]=((arr[i-1]-arr[i])-(arr[i]-arr[i+1]))/2;
            }

            long temp=arr[0];
            for(int i=1;i<=n-2;i++){
                temp-=result[i]*i;
            }
            result[n-1]=temp/(n-1);

            temp=arr[n-1];
            for(int i=1;i<=n-2;i++){
                temp-=result[i]*(n-i-1);
            }
            result[0]=temp/(n-1);

            StringBuilder sb=new StringBuilder();

            for (long l : result) {
                sb.append(l+" ");
            }
            System.out.println(sb);
        }
    }
}