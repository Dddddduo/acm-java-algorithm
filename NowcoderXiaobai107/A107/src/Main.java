import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt=0;

        while(true){
            if(n>=a){
                n-=a;
                cnt++;
            }
            else if(n>=b){
                n-=b;
                cnt++;
            }
            else if(n>=c){
                n-=c;
                cnt++;
            }
            else if(n<c) break;
        }

        System.out.println(cnt);

    }
}