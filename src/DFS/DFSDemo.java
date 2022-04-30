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
