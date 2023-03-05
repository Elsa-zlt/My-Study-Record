package test;

import java.text.DateFormat;
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
        String time = "2010-3-4 18:14:20.0";
        String Time = time.substring(0, time.length() - 2);
        System.out.println(Time);
//        System.out.println(hashMapTest());
//        System.out.println();
        //红色底色格式较为常用，效果如：2008-6-16 20:54:53
//        Date now = new Date();
//        Calendar cal = Calendar.getInstance();
//
//        DateFormat d1 = DateFormat.getDateInstance(); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
//        String str1 = d1.format(now);
//        System.out.println("str1:" + str1);
//
//        DateFormat d2 = DateFormat.getDateTimeInstance();
//        String str2 = d2.format(now);
//        System.out.println("str2:" + str2);
//
//        DateFormat d3 = DateFormat.getTimeInstance();
//        String str3 = d3.format(now);
//        System.out.println("str3:" + str3);
//
//        DateFormat d4 = DateFormat.getInstance(); //使用SHORT风格显示日期和时间
//        String str4 = d4.format(now);
//        System.out.println("str4:" + str4);
//
//        DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，时间（精确到秒）
//        String str5 = d5.format(now);
//        System.out.println("str5:" + str5);
//
//        DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
//        String str6 = d6.format(now);
//        System.out.println("str6:" + str6);
    }

}
