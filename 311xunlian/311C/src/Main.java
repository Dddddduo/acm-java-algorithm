import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt();
        for (int i1 = 0; i1 < t; i1++) {
            long x=sc.nextLong();
            long y=sc.nextLong();
            long k=sc.nextLong();

            long tempx=x/k;
            long tempy=y/k;
            if(x%k!=0)tempx++;
            if(y%k!=0)tempy++;

            if(tempx>tempy){
                System.out.println(tempx*2-1);
            }else if(tempx<=tempy){
                System.out.println(tempy*2);
            }

//            boolean judge=true;
//            long cnt=0;
//            while(true){
//                if(judge==true){
//                    // x
//                    if(x>=k){
//                        x-=k;
//                        cnt++;
//                    }else {
//                        x=0;
//                        cnt++;
//                    }
//                    judge=false;
//                }else{
//                    // y
//                    if(y>=k){
//                        y-=k;
//                        cnt++;
//                    }else {
//                        y=0;
//                        cnt++;
//                    }
//                    judge=true;
//                }
//                if(x<=0&&y<=0)break;
//            }
//            System.out.println(cnt);
        }
    }
}