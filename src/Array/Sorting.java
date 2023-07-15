package Array;

public class Sorting {

    void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public void bubbleSort(int[] arr) {

        int n = arr.length;
        for(int i=0;i<n;i++) {
            boolean swapped = false;
            for(int j=0;j <n-i-1;j++) {

                if(arr[j]>arr[j+1]) {
                    swapped = true;
                    swap(arr, j, j+1);
                }
            }
            if(swapped == false) {
                return;
            }
        }
    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        int min_value_index;
        for(int i=0;i<n;i++) {
            min_value_index = i;

            for(int j=i+1; j<n;j++) {
                if(arr[j] < arr[min_value_index]) {
                    min_value_index = j;
                }
            }
            swap(arr, i, min_value_index);
        }
    }
}
