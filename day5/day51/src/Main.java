import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        long arr[] = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            System.out.println("0");
            return;
        }
//        System.out.println(sum/3);
        int cnt = 0;
        long k = sum / 3; // 要达到的数
//        System.out.println(k);

        ArrayList<Integer>list1 =new ArrayList<>(); // 前
        ArrayList<Integer>list2 =new ArrayList<>(); // 后

        long ans1=0;
        boolean judge1=false;
        for(int i=0;i<n;i++){
            if(judge1==false&&arr[i]>0){
                judge1=true;
            }
            ans1+=arr[i];
            if(ans1==k&&judge1==true){
                list1.add(i);
            }
        }

        long ans2=0;
        boolean judge2=false;
        for(int i=n-1;i>=0;i--){
            if(judge2==false&&arr[i]>0){
                judge2=true;
            }
            ans2+=arr[i];
            if(ans2==k&&judge2==true){
                list2.add(i);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

//        for (Integer i : list1) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        for (Integer i : list2) {
//            System.out.print(i+" ");
//        }
//        System.out.println();

        for(int i=0;i<list1.size();i++){
            long a1=list1.get(i);
            for(int j=0;j<list2.size();j++){
                long a2=list2.get(j);
                if(a2>a1+1){
                    for(long ii=a1+1;ii<=a2-1;ii++){
                        if(arr[(int) ii]>0){
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}