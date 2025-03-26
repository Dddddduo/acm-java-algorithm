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
        int n=sc.nextInt();

        int arr[]=new int[10];
        arr[2]=2;arr[0]=3;arr[1]=1;arr[3]=1;arr[5]=1;

        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        loop:for (int i = 0; i < n; i++) {
            int ans=a[i];
            if(arr[ans]>0){
                arr[ans]--;
            }
            for (int i1 = 0; i1 < 10; i1++) {
                if(arr[i1]!=0){
                    continue loop;
                }
            }
            System.out.println(i+1);
            return;
        }
        System.out.println("0");
    }


}