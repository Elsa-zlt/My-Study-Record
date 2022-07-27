package heima.sort;

import heima.utils.SwapUtil;

import java.util.Arrays;

public class quickSort {

    static void quick(int[] arr, int l, int h) {
        if(l > h) {
            return;
        }
        // p索引值
        int p = partition(arr, l, h);
        // 左边分区范围确定
        quick(arr, l, p - 1);
        // 右边分区范围确定
        quick(arr, p + 1, h);
    }

    static int partition(int[] arr, int l, int h) {
        // 最右边的h作为基准点元素
        int pv = arr[h];
        // 使用i来记录l的初始值
        int i = l;
        for(int j = l; j < h; j++) {
            if(arr[j] < pv) {
                if(i != j) {
                    SwapUtil.swap(arr, i, j);
                }
                i++;
            }
        }
        if(i != h) {
            SwapUtil.swap(arr, h, i);
        }
        System.out.println(Arrays.toString(arr) + " i=" + i);
        // 返回值代表了基准点元素所在的正确索引，用它确定下一轮分区的边界
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {1, 20, 8, 3, 33, 22, 21, 12, 40, 19, 15, 38, 90};
        quick(arr, 0, arr.length - 1);
    }
}
