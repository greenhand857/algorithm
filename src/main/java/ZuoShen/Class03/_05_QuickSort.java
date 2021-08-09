package ZuoShen.Class03;

import java.util.Arrays;

public class _05_QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length<2) return;
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr,int L,int R){
        if(L >= R) return;
        swap(arr,L + (int)(Math.random()*(R-L+1)),R);
        int[] equalArea = partition(arr,L,R);
        process(arr,L,equalArea[0]-1);
        process(arr,equalArea[1]+1,R);
    }

    public static int[] partition(int[] arr,int L,int R){
        int less = L-1;
        int more = R;
        int index = L;
        while (index < more){
            if(arr[index] < arr[R]){
                swap(arr,index++,++less);
            }else if(arr[index] > arr[R]){
                swap(arr,index,--more);
            }else {
                index++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            quickSort(arr);
            Arrays.sort(arr1);
            if (!isEqual(arr, arr1)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }

}
