package sort;

class QuickSort {

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