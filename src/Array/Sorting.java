package Array;

import java.util.Arrays;

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

    public void insertionSort(int[] arr) {
        int n = arr.length, value, hole;
        for(int i=1;i<n;i++) {
            value = arr[i];
            hole = i-1;

            while(hole>=0 && arr[hole]>=value) {
                arr[hole+1] = arr[hole];
                hole--;
            }
            arr[hole+1] = value;
        }
    }

    void printArray(int[] arr, int l, int r) {
        System.out.print("[");
        for(int i=l;i<=r;i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("]");
    }
    void merge(int[] arr, int l, int mid, int r) {

        int n1 = mid-l+1;
        int n2 = r-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++) {
            left[i] = arr[i+l];
        }

        for(int i=0;i<n2;i++) {
            right[i] = arr[i+mid+1];
        }

        int i=0, j=0, k=l;

        while(i<n1 && j<n2) {

            if(left[i]<right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
            k++;
        }

        while(i<n1) {
            arr[k++] = left[i++];
        }

        while(j<n2) {
            arr[k++] = right[j++];
        }
    }
    void splitAndMerge(int[] arr, int l, int r) {
        int mid;

        if(l<r) {
            mid = l+ (r-l)/2;

            splitAndMerge(arr, l, mid);
            System.out.print("LEFT ->");
            printArray(arr, l, mid);
            splitAndMerge(arr, mid+1, r);
            System.out.print("RIGHT -> ");
            printArray(arr, mid+1, r);

            merge(arr, l, mid, r);

            System.out.print("MERGED -> ");
            printArray(arr, l, r);

        }
    }
    public void mergeSort(int[] arr) {
        splitAndMerge(arr, 0, arr.length-1);
    }


    int partition(int[] arr, int l, int r) {

        int pivotValue = arr[r];
        int i=l, j=l-1;
        while(i<r) {
            if(arr[i]<pivotValue)  {
                j++;
                swap(arr, i,j);
            }
            i++;
        }
        swap(arr,i,j+1);
        return j+1;
    }

    void partitionAndSort(int[] arr, int l, int r) {
        if(l<r) {
            int pivotIndex = partition(arr, l,r);

            //split into 2 array according to pivot

            partitionAndSort(arr, l, pivotIndex-1);
            partitionAndSort(arr, pivotIndex+1, r);
        }

    }



    public void quickSort(int[] arr) {
        partitionAndSort(arr, 0, arr.length-1);
    }
}
