package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SuShuHuan {
    static int n, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        getQuanpailie(array, 1);

    }

    // 计算各部分结果
    private static boolean isPrime(int i, int j) {
        boolean sign = false;
        int sum = i + j;
        if (sum == 2 || sum == 3 || sum == 5) {
            sign = true;
        } else if (sum % 2 != 0 && sum % 3 != 0 && sum % 5 != 0) {
            sign = true;
        }
        return sign;
    }

    private static void getQuanpailie(int[] data, int k) {
        if (k == data.length) {// 判断边界
            // 将数组分为三部分
            boolean sign = false;
            if (isPrime(1, data[data.length - 1])) {
                sign = true;
                for (int i = 1; i < data.length; i++) {// 第一个到最后一个之间的所有数
                    if (!isPrime(data[i], data[i - 1])) {
                        sign = false;
                        break;
                    }
                }
            }
            // 最后一个和第一个
            if (sign) {
                System.out.println(Arrays.toString(data));
            }
        }
        for (int j = k; j < data.length; j++) {
            // 交换
            swap(data, k, j);
            getQuanpailie(data, k + 1);// 回溯
            // 恢复到最初的状态
            swap(data, k, j);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

