package test;

import java.util.*;

public class HashMapStudy {

    static Map<String, String> hashMapTest() {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("map的大小为：" + map.size());
        for (int i = 0; i < 10; i++) {
            map.put(Integer.toString(i), Integer.toString(i + 1));
        }
        Map<String, String> map2 = new HashMap<String, String>(map);
        System.out.println("map2的大小为：" + map2.size());
        String str1 = "1";
        if(map.containsKey(str1)) {
            System.out.println("有包含1的key");
        }
        if(map.containsValue(str1)) {
            System.out.println("有包含1的value");
        }
        if(map.isEmpty()) {
            return new HashMap<>();
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(hashMapTest());
        System.out.println();
    }

}
