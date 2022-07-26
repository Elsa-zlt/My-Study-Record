package heima.utils;

public class SwapUtil {

    public static void swap(int[] data, int a, int b) {
        int temp;
        temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
