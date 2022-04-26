package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(0);
        list.add(3);
        list.add(4);
        List<Integer> bucketSort = bucketSort(list, 2);
        System.out.println(bucketSort);

    }
    public static List<Integer> bucketSort(List<Integer> array,int bucketSize) {
        //合法性校验
        if (array == null || array.size() < 2 || bucketSize < 1) {
            return array;
        }
        //找出集合中元素的最大值和最小值
        int max = array.get(0);
        int min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        //计算桶的个数   集合中的最小值到最大值 判断桶的个数
        int bucketCount = (max - min) / bucketSize + 1;
        //按照顺序创建桶 创建一个list带下标
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        //将待排序的集合依次添加到对应的桶中
        //首先找到元素所对应的桶的顺序  再将元素添加到桶中
        for (int j = 0; j < array.size(); j++) {
            int bucketIndex = (array.get(j) - min) / bucketSize;
            bucketList.get(bucketIndex).add(array.get(j));
        }

        //将桶内的元素进行排序
        List<Integer> resultList = new ArrayList<>();
        for (int j = 0; j < bucketList.size(); j++) {
            List<Integer> everyBucket = bucketList.get(j);
            if (everyBucket.size() >0) {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                //递归调用  进行排序
                List<Integer> temp = bucketSort(everyBucket,bucketSize);
                for (int i = 0; i < temp.size(); i++) {
                    //合并数据
                    resultList.add(temp.get(i));
                }
            }
        }
        return resultList;
    }
}

