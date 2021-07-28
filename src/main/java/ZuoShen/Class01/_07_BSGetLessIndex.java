package ZuoShen.Class01;

public class _07_BSGetLessIndex {
    // 求无序数组的局部最小值问题
    public static int getLessIndex(int[] arr){
        if(arr == null || arr.length < 1) return -1;  //不存在
        if(arr.length == 1 || arr[0]<arr[1]) return 0;
        if(arr[arr.length-1] < arr[arr.length-2]) return arr.length-1;

        int l = 1;
        int r = arr.length - 2;
        int mid = 0;
        while (l <= r){
            mid = l + ((r-l)>>1);
            if(arr[mid]>arr[mid-1]){
                r = mid - 1;
            }else if(arr[mid]>arr[mid+1]){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        throw new IllegalArgumentException("No Such Solution");
    }
}
