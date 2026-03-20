import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);;
    public static void main(String[] args) {
        int t=sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n=sc.nextInt();
            long k=sc.nextLong();
            long arr[]=new long[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1]=sc.nextLong();
            }
            if(k%2!=0){
                StringBuilder sb=new StringBuilder();
                for (long l : arr) {
                    if(l%2!=0)sb.append((l+k)+" ");
                    else sb.append(l+" ");
                }
                System.out.println(sb);
            }else{
                StringBuilder sb=new StringBuilder();
                for (long l : arr) {
                    sb.append(l%(k+1)*k+l+" ");
                }
                System.out.println(sb);
            }
        }
    }
}