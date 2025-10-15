import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();


        // 我们在得到函数氏接口的时候，是可以直接重写这个接口的
        map.put("鲁迅", "这句话是我说的");
        map.put("曹操", "不可能绝对不可能");
        map.put("刘备", "接着奏乐接着舞");
        map.put("柯镇恶", "看我眼色行事");

        // 接入函数式接口
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "=" + value);
            }
        });

        // Lambda表达式
        map.forEach((String key, String value) -> {
                    System.out.println(key + "=" + value);
                }
        );

        // 流
        map.forEach((key, value) -> System.out.println(key + "=" + value));

        map.keySet().forEach(System.out::println);

        map.values().forEach(System.out::println);
    }

}