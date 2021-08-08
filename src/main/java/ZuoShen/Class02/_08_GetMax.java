package ZuoShen.Class02;

public class _08_GetMax {
    // 递归方法实现求数组arr[L..R]上的最大值
    // 算法思路：将整个数据分为左右两部分，分别求最大值，再比较
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int L,int R){
        if(L == R) {   // base case 只有一个数时直接返回
            return arr[L];
        }

        int mid = L + ((R - L)>>1);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }

    // 递归是用系统栈 来实现 二叉树的深度优先遍历

    // Master公式  N/b 表示子问题的规模是一致的 调用了a次 O(N^d)表示除了子问题以外的复杂度
    //    T(N) = a * T(N/b) + O(N^d)(其中的a、b、d都是常数)
    //    的递归函数，可以直接通过Master公式来确定时间复杂度
    //    如果 log(b,a) < d，复杂度为O(N^d)
    //    如果 log(b,a) > d，复杂度为O(N^log(b,a))
    //    如果 log(b,a) == d，复杂度为O(N^d  * logN)

}
