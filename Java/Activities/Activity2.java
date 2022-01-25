package activities;

import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args) {
        int arr[] = {10, 77, 10, 54, -11, 10};
        System.out.println("Is Sum of Tens equal to 30 in array "+ Arrays.toString(arr)+"?\n"+checkSumOfTens(arr));
    }

    public static boolean checkSumOfTens(int arr[]) {
        int sum = 0;

        for(int num : arr) {
            if(num == 10) {
                sum = sum + num;
            }
        }

        if(sum == 30) {
            return true;
        }
        else {
            return false;
        }
    }

}
