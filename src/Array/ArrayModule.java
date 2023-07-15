package Array;

import java.util.Arrays;

public class ArrayModule {

    public int linearSearch(int[] arr, int target) {
        int n=arr.length;
        for(int i=0;i<n;i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int [] arr, int target) {
        int n = arr.length;
        int l=0, r=arr.length-1;
        int mid;

        while(l<=r) {

            mid = l + (r-l)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid]<target) {
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        return -1;
    }

    public int missingNumber(int[] arr, int N) {
        int xor =0;

        for(int i =1;i<=N;i++) {
            xor = xor^i;
        }

        System.out.println(xor);

        for (int i=0;i<arr.length;i++) {
            xor = xor^arr[i];

        }

        return xor;
    }

    public int getMajorityElement(int[] arr) {
        int n= arr.length;
        int majorityElement = arr[0], count =1;

        for(int i=1;i<n;i++) {

            if(arr[i] == majorityElement) {
                count++;
            } else {
                count--;
            }

            if(count==0) {
                majorityElement=arr[i];
                count=1;
            }
        }
        return majorityElement;
    }

    public int max_difference_Higher_Index(int[] arr) {

        int n=arr.length;
        int min_element = arr[0], max_diff = Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {

            if(arr[i]>min_element) {
                max_diff = Math.max( max_diff, arr[i] - min_element);
            }

            min_element = Math.min(min_element, arr[i]);
        }
        return max_diff;
    }

    public int closestSum_Approach1(int[] arr) {

        int n= arr.length, current_sum, closest_sum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {

            for(int j=i+1;j<n;j++) {
                current_sum = arr[i] + arr[j];

                if( (Math.abs(current_sum) < Math.abs(closest_sum)) ||
                        ((Math.abs(closest_sum) == Math.abs(current_sum)) &&   (closest_sum<current_sum))) {
                    closest_sum = current_sum;
                }
            }
        }
        return  closest_sum;
    }

    public int closestSum_Approach2(int[] arr) {

        int n= arr.length, current_sum, closest_sum = Integer.MAX_VALUE;
        int l =0, r=n-1;
        Arrays.sort(arr);
        while(l<r) {
            current_sum = arr[l] + arr[r];

            if( (Math.abs(current_sum) < Math.abs(closest_sum)) ||
                    ((Math.abs(closest_sum) == Math.abs(current_sum)) &&   (closest_sum<current_sum))) {
                closest_sum = current_sum;
            }

            if(current_sum<0)
                l++;
            else
                r--;
        }
        return  closest_sum;
    }

    public int[] repeated_ArrayIndexMarking(int[] arr) {
        int k=0;
        int[] repeated =  new int[2];
        for(int i=0; i<arr.length; i++) {
            int abs_val = Math.abs(arr[i]);
            if(arr[abs_val] > 0) {
                arr[abs_val] = -arr[abs_val];
            } else {
                repeated[k++] = abs_val;
            }
        }
        return repeated;
    }

    public int[] repeated_XOR(int[] arr, int N) {
        int xor =0;

        //xor of array
        for(int i=0;i<arr.length;i++) {
            xor = xor^arr[i];
        }

        //xor with (1..N)
        for(int i=1;i<=N;i++) {
            xor = xor^i;
        }

        //xor = a^b

        //find rightMostSetBit Number
        int rightMostSetBitNumber = xor & (~(xor-1));

        int xor1=0, xor2=0;

        for(int i=0;i<arr.length;i++) {
           if((rightMostSetBitNumber&arr[i])==0) {
               xor1 = xor1 ^ arr[i];
           } else {
               xor2 = xor2 ^ arr[i];
           }
        }

        //xor with (1..N)
        for(int i=1;i<=N;i++) {
            if((rightMostSetBitNumber& i)==0) {
                xor1 = xor1 ^ i;
            } else {
                xor2 = xor2 ^ i;
            }
        }

        int[] repeated = new int[2];

        repeated[0] = xor1;
        repeated[1] = xor2;

        return repeated;

    }

    public boolean findTriplet(int[] arr, int target) {

        Arrays.sort(arr);

        int n=arr.length;
        for(int i=0;i<n-2;i++) {

            int pair_sum = target - arr[i];
            int l =i+1, r = n-1;
            while(l<r) {

                if(arr[l] + arr[r] == pair_sum) {
                    return true;
                }
                else if(arr[l] + arr[r] < pair_sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return false;
    }

    public int bitonicPoint(int[] arr) {

        int l =0, r=arr.length-1;

        while(l<=r) {
            int mid = l+ (r-l)/2;

            if(arr[mid-1]<arr[mid] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if(arr[mid] < arr[mid+1]) {
                l= mid+1;
            } else {
                r=mid-1;
            }
        }
        return -1;
    }

    public void leftRotate(int[] arr, int d) {

        int n = arr.length;
        d=d%n;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);

    }

    void reverseArray(int[] arr, int l, int r) {
        int temp;
        while(l<r) {
            temp = arr[r];
            arr[r] =arr[l];
            arr[l] = temp;

            l++;
            r--;
        }
    }

    public boolean subArraySum(int[] arr, int target) {
        int sum=0, l=0, r=0;
        int n = arr.length;
        int[] x = new int[2];
        int sub_size = Integer.MAX_VALUE;
        while(l<=r && r<n) {

            if(sum==target) {
                if(sub_size > r-l+1) {
                    x[0] = l;
                    x[1] = r;
                }
            } else if(sum < target) {
                sum+= arr[r++];
            } else {
                sum-= arr[l++];
            }
        }
        return  false;
    }
}
