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

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for(int e=arr.length-1;e>0;e--){
            for(int i=0;i<e;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
