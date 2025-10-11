import java.math.BigDecimal;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        char arr[]=scanner.next().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='0'){
                int j=i+1;
                while(j<arr.length&&arr[j]=='0'){
                    j++;
                }
                if(j>=arr.length){
                    break;
                }else{
                    for(int p=i;p<=j;p++){
                        if(arr[p]=='0'){arr[p]='1';}
                        else if(arr[p]=='1'){arr[p]='0';}
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for (char c : arr) {
//            if(c!='0'){
                sb.append(c);
//            }
        }
        System.out.println(sb.toString());

    }
}