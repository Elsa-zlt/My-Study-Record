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

            for(j = i-1; j >= 0; j--){
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

}
```
