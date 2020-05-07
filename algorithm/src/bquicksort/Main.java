package bquicksort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 3, 1, 7, 8, 9, 4, 19};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;
        int tmp = arr[low];
        while (low < high) {
            for (; high > low; high--) {
                if (arr[high] < tmp) {
                    arr[low] = arr[high];
                    break;
                }
            }
            for (; low < high; low++) {
                if (arr[low] > tmp) {
                    arr[high] = arr[low];
                    break;
                }
            }
        }
        arr[low] = tmp;
        sort(arr, start, low - 1);
        sort(arr, low + 1, end);
    }
}
