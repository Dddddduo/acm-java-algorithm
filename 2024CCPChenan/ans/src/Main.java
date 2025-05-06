import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abab","ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<p.length();i++){
            hm.put(p.charAt(i),hm.getOrDefault(p.charAt(i),0)+1);
        }
        Set<Character> key = hm.keySet();

        ArrayList<Integer>list=new ArrayList<>();
        if(s.length()<p.length())return list;

        int i=0;
        int j=0;
        HashMap<Character,Integer>newhm=new HashMap<>();
        Deque<Character>deque=new LinkedList<>();
        while(j<p.length()){
            newhm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            deque.addLast(s.charAt(j));
            j++;
        }
//        System.out.println(j);

        loop:while(j<s.length()){
            for (Character c : key) {
                if(hm.get(c)!=newhm.get(c)){
                    continue loop;
                }
            }
            Character c1 = deque.pollFirst();
            deque.addLast(s.charAt(j));
            System.out.println(c1);
            newhm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),1)-1);
            newhm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            i++;
            j++;
            list.add(i);
        }

        return list;
    }

}