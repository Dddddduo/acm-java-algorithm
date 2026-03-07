import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i1 = 0; i1 < n; i1++) {
            int num=sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb=new StringBuilder();

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            Integer i = map.get(integer);
            if(i%2==0){
                for (Integer i1 = 0; i1 < i; i1++) {
                    sb.append(integer+" ");
                }
            }else{
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        System.out.println(sb.toString());

    }
}