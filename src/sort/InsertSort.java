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
