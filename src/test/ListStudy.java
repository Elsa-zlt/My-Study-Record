package test;

import java.util.*;

public class ListStudy {

    static List<Integer> listTest() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        if(list.contains(1)) {
            System.out.println("list包含1");
        }
        if(list.size() >= 10) {
            System.out.println("list大于10");
            list.clear();
        }
        if(list.isEmpty()) {
            return new ArrayList<>();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(listTest());
    }


}
