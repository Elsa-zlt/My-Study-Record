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
