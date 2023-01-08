package test;

/**
 * @ClassName : test1  //类名
 * @Author : elsa //作者
 */

import java.util.ArrayList;
import java.util.List;

/**
 *有一批订单(订单号和订单价格)录入系统*运行过程中可以执行以下操作:
 * 添加订单、删除订单、修改订单价格(订单号不存在修改失败)、计算
 *价格、根据订单号获取价格
 *实时计算所有订单中当前的最大价格、最小价格和平均价格
 *请尽可能地降低复杂度*/

public class test1 {

    List list = new ArrayList<order>();

    public void add(int id, int price) {
        list.add(new order(id, price));
    }

    public void remove(int id) {
        list.remove(id);
    }

    public void modify(int id, int price) {
        list.set(id, price);
    }

    public int getPrice(int id) {
        return (int) list.get(id);
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            if((int)list.get(i) > max) {
                max = (int)list.get(i);
            }
        }
        return max;
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            if((int)list.get(i) < min) {
                min = (int)list.get(i);
            }
        }
        return min;
    }

    public int avg() {
        int avg = 0;
        for(int i = 0; i < list.size(); i++) {
            avg = (int)list.get(i);
        }
        avg = avg / list.size();
        return avg;
    }

}
