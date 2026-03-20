import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            long sum=0;
            int n=sc.nextInt();
            long arr[]=new long[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1]=sc.nextLong();
                sum+=arr[i1];
            }

            long ans= 2 * arr[0];
            for (int i1 = 0; i1 < n; i1++) {
                if(i1%2==0){
                    ans=Math.min(ans,2*arr[i1]+i1);
                }
                if(i1%2==1){
                    sum+=Math.min(sum,sum-ans+2*arr[i1]+i1);
                }
            }


            System.out.println(sum);
        }
    }
}