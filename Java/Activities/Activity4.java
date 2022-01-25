package activities;

import java.util.Arrays;

class Activity4 {
    public static void main(String[] args) {
        int[] arr = { 11, 6, 3, 8, 55 };
        insertionSort(arr);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int size = arr.length;

        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }
}