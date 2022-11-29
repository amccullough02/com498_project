import java.util.Arrays;

public class Quick {

    public static void main(String[] args) {
        int[] a = {56,32,153,88,21,236,303,111,13,15,29};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static void quickSort (int[] arr, int first, int last) {
        int pivot = arr[last];
        int indexFromLeft = first, indexFromRight = last;

        while (indexFromLeft <= indexFromRight) {
            while (arr[indexFromLeft] < pivot) indexFromLeft++;
            while (arr[indexFromRight] > pivot) indexFromRight--;
            if (indexFromLeft <= indexFromRight) swap(arr, indexFromLeft++, indexFromRight--);
        }

        if (first < indexFromRight) quickSort(arr, first, indexFromRight);
        if (indexFromLeft < last) quickSort(arr, indexFromLeft, last);

    }

}
