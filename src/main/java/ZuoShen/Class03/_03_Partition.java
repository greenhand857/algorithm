package ZuoShen.Class03;

public class _03_Partition {
    // 给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。

    // 要求额外空间复杂度O(1)，时间复杂度O(N)
    public static int partition(int[] arr,int num){
        // 1) [i]<=num时，将当前数 与 <=区的下一个数交换，然后<=区向右扩一个位置，i++
        // 2) [i]>num时，直接跳下一个 i++
        int L = -1;
        int i=0;
        while (i<arr.length){
            if(arr[i]<=num){
                swap(arr,i,++L);
            }
            i++;
        }
        return L;
    }

    // 荷兰国旗问题 < | = | >
    // [i] == num , i++
    // [i] < num , [i]与<区右一个交换，<区右扩，i++
    // [i] > num , [i]与>区左一个交换，>区左扩，i原地
    public static int[] partition1(int[] arr,int num){
        int L = -1;
        int R = arr.length;
        int i=0;
        while(i<R){
            if(arr[i] < num){
                swap(arr,i++,++L);
            }else if(arr[i] > num){
                swap(arr,i,--R);
            }else {
                i++;
            }
        }
        return new int[]{L+1,R-1};
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray ( int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = {3,2,7,5,3,4,1};
        int res = partition(arr,3);
        printArray(arr);
        System.out.println(res);

        System.out.println("==========");

        int[] arr2 = {3,2,7,5,3,4,1};
        int[] ans = partition1(arr2,3);
        printArray(arr2);
        printArray(ans);
    }

}
