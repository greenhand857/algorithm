package ZuoShen.Class01;

public class _08_EvenOddTimes {
    // 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int num : arr){
            eor ^= num;
        }
        System.out.println(eor);
    }

    // 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int num : arr){
            eor ^= num;
        }

        // eor = a ^ b eor != 0  eor必然有一个位置上是1
        // 怎么把一个int类型的数，提取出最右侧的1来   n & (~n + 1)
        int rightOne = eor & (~eor + 1);
        int val = 0;
        for(int i=0;i<arr.length;i++){
            if((arr[i] & rightOne) != 0){
                val ^= arr[i];
            }
        }
        System.out.println(val + "," + (eor ^ val));
    }

    public static void main(String[] args){
        int[] arr1 = { 3, 3, 2, 2, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 4, 2 };
        printOddTimesNum2(arr2);
    }

}
