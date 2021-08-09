package ZuoShen.Class03;

public class _04_netherLandsFlag {
    // arr[L..R] 上进行荷兰国旗的划分 以arr[R]做划分值
    // <arr[R]  ==arr[R]  >arr[R]
    public static int[] partition(int[] arr,int L,int R){
        if(L > R) return new int[]{-1,-1};
        if(L == R) return new int[]{L,R};

        int less = L - 1;
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

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
