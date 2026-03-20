import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);;
    public static void main(String[] args) {
        int t=sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n=sc.nextInt();
            String str=sc.next();
            char arr[]=str.toCharArray();
            int cnt1=0;
            int cnt2=0;
            for(int i=0;i<arr.length-2;i++){
                if(arr[i]=='1'&&arr[i+2]=='1')arr[i+1]='1';
            }
            for (char c : arr) {
                if(c=='1')cnt2++;
            }
            for(int i=0;i<arr.length-2;i++){
                if(arr[i]=='1'&&arr[i+2]=='1')arr[i+1]='0';
            }
            for (char c : arr) {
                if(c=='1')cnt1++;
            }
            System.out.println(cnt1+" "+cnt2);
        }
    }
}