package amergesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {4, 9, 3, 5, 7, 1, 2, 6, 8, 11, 10, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid + 1, right, temp);
        }
    }

    private static void merge(int[] arr, int left , int rightStart, int right, int[] temp) {
        int li = left;
        int ri = rightStart;
        if (right + 1 - left >= 0) {
            System.arraycopy(arr, left, temp, left, right + 1 - left);
        }
        for (int i = left; i <= right; i++) {
            if (ri < right && (li >= rightStart || temp[li] > temp[ri])) {
                arr[i] = temp[ri];
                ri ++;
            } else {
                arr[i] = temp[li];
                li ++;
            }
        }
    }
}
