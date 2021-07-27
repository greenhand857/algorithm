package Sort;

public class SelectSort {
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for(int i=0;i<arr.length-1;i++){
            int minindex = i;
            for(int j=i+1;j<arr.length;j++){
                minindex = arr[j]>arr[minindex] ? minindex : j;
            }
            swap(arr,minindex,i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
