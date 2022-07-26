package heima.search;

public class binarySearch {

    static int binarySearchTest(int arr[], int target) {
        int l = 0, r = arr.length, m;
        while(l <= r) {
            m = l + (r - l) / 2;
            System.out.println("当前的中间值m=" + m);
            if(arr[m] == target) {
                return m;
            } else if(arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 19;
        System.out.println(binarySearchTest(arr, target));
    }
}
