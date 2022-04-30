# 算法学习记录

## 冒泡排序

```Java
package sort;

import java.util.Arrays;

class BubbleSort{

    private static int[] arr = {3,2,1,5,4};

    public static void main(String[] args) throws Exception {
        int []a = BubbleSort(arr);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] BubbleSort(int[] sourceArray) throws Exception {

        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }

        }

        return arr;
    }
}
```

## 快速排序

```Java
package sort;

class quick_sort {

    private static int[] arr = {3,2,1,5,4};

    public static void main(String[] args) throws Exception {
        int []a = quick_sort(arr);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void quick_sort_recursive(int start, int end) {
        if (start >= end)
            return;

        int mid = arr[end];
        int left = start, right = end - 1;

        while (left < right) {
            while (arr[left] <= mid && left < right)
                left++;

            while (arr[right] >= mid && left < right)
                right--;

            swap(left, right);
        }

        if (arr[left] >= arr[end])
            swap(left, end);
        else
            left++;

        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }

    public static int[] quick_sort(int[] arrin) {
        arr = arrin;
        quick_sort_recursive(0, arr.length - 1);
        return arrin;
    }

}
```

## 插入排序

```java
package sort;

public class InsertSort {
    private static int[] a = {3,2,1,5,4};

    public static void main(String[] args) throws Exception {
        InsertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        a = new int[]{3, 2, 1, 5, 4};
        BinaryInsertSort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    // 插入排序
    private static void InsertSort(int arr[]){
        int len = arr.length;

        // 检查数据合法性
        if(arr == null || len <= 0){
            return;
        }

        for(int i = 1; i < len; i++){
            int tmp = arr[i];
            int j;

            for(j = i - 1; j >= 0; j--){
                //如果比tmp大把值往后移动一位
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }
                else{
                    break;
                }
            }

            arr[j+1] = tmp;
        }
    }

    // 插入排序改进：二分插入排序
    private static void BinaryInsertSort(int arr[], int len)
    {
        int key, left, right, middle;
        for (int i = 1; i < len; i++)
        {
            key = a[i];
            left = 0;
            right = i - 1;
            while (left <= right)
            {
                middle = (left + right)/2;
                if (a[middle] > key)
                    right = middle - 1;
                else
                    left = middle + 1;
            }

            for(int j=i - 1; j >= left; j--)
            {
                a[j+1] = a[j];
            }

            a[left] = key;
        }
    }

}

```

## 希尔排序

```java
package sort;

public class shell_sort {

    private static int[] arr = {3,2,1,5,4};

    public static void main(String[] args) throws Exception {
        shell_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1;
        for (; gap > 0; gap /= 3)
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
    }

}
```

## 选择排序

```java
package sort;

import java.util.Arrays;

public class SelectionSort {
    private static int[] arr = {3,2,1,5,4,9};

    public static void main(String[] args) throws Exception {
        int []a = SelectionSort(arr);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] SelectionSort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }

}
```

## 桶排序

```java
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
```

## 归并排序

```java
package sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        //int a[]={5,2,4,7,1,3,2,2};
        int temp[]=new int[a.length];
        mergesort(a,0,a.length-1,temp);
        System.out.println(Arrays.toString(a));
    }

    private static void mergesort(int[] a, int left, int right, int[] temp) {
        //分解
        if (left<right) {
            int mid=(left+right)/2;
            //向左递归进行分解
            mergesort(a, left, mid, temp);
            //向右递归进行分解
            mergesort(a, mid+1, right, temp);
            //每分解一次便合并一次
            merge(a,left,right,mid,temp);
        }
    }
    /**
     *
     * @param a  待排序的数组
     * @param left  左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param mid  中间索引
     * @param temp 做中转的数组
     */
    private static void merge(int[] a, int left, int right, int mid, int[] temp) {
        int i=left; //初始i，左边有序序列的初始索引
        int j=mid+1;//初始化j，右边有序序列的初始索引（右边有序序列的初始位置即中间位置的后一位置）
        int t=0;//指向temp数组的当前索引，初始为0

        //先把左右两边的数据（已经有序）按规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完成为止
        while (i<=mid && j<=right) {
            //如果左边有序序列的当前元素小于或等于右边的有序序列的当前元素，就将左边的元素填充到temp数组中
            if (a[i]<=a[j]) {
                temp[t]=a[i];
                t++;//索引向后移
                i++;//i后移
            }else {
                //反之，将右边有序序列的当前元素填充到temp数组中
                temp[t]=a[j];
                t++;//索引向后移
                j++;//j后移
            }
        }
        //把剩余数据的一边的元素填充到temp中
        while (i<=mid) {
            //此时说明左边序列还有剩余元素
            //全部填充到temp数组
            temp[t]=a[i];
            t++;
            i++;
        }
        while (j<=right) {
            //此时说明左边序列还有剩余元素
            //全部填充到temp数组
            temp[t]=a[j];
            t++;
            j++;
        }
        //将temp数组的元素复制到原数组
        t=0;
        int tempLeft=left;
        while (tempLeft<=right) {
            a[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }

}
```

## DFS（全排列）

```java
package DFS;

import java.util.Arrays;

// 全排列
class DFS {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 3 };
        quanPai(array, 0);
    }

    public static void quanPai(int[] array, int k) {
        if (k == array.length) {
            System.out.println(Arrays.toString(array));
        }
        for (int i = k; i < array.length; i++) {
            if (isSwap(array, k, i)) {//这一步为了去重的，不懂点代码后面的链接
                swap(array, k, i);
                quanPai(array, k + 1);
                swap(array, k, i);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static boolean isSwap(int[] array, int start, int end) {
        boolean sign = true;
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                sign = false;
            }
        }
        return sign;
    }
}
```
