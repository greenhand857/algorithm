package ZuoShen.Class01;

import java.util.Arrays;

// 二分法 在一个有序数组中 查找某个数是否存在
public class _04_BSExist {
    public static boolean isExist(int[] arr,int num){
        if(arr==null || arr.length<1) return false;
        int l = 0;
        int r = arr.length-1;
        int mid = 0;
        while (l <= r){
            mid = l + ((r-l)>>1);
            if(arr[mid] > num){
                r = mid - 1;
            }else if(arr[mid] < num){
                l = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    // 对数器
    public static boolean comparator(int[] arr,int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean res = true;

        for(int i=0;i<testTime;i++){
            int[] arr = generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int num = (int) (maxValue * Math.random());
            boolean flag1 = isExist(arr,num);
            boolean flag2 = comparator(arr,num);

            if(flag1 != flag2){
                res = false;
                printArray(arr);
                System.out.println(num);
                break;
            }
        }

        System.out.println(res ? "Nice" : "Fail");
    }
}
