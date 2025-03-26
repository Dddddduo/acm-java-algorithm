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
        if(n%2==0){
            System.out.println("-1");
        }else{
            System.out.print("1 ");
            for(int i=3;i<=n;i+=2){
                System.out.print(i+" ");
            }
            for(int i=2;i<=n;i+=2){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }

}