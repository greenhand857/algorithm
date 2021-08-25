package LeetCodeHot100;

public class _055_JumpGame {
    /*
    算法思路：遍历数组中的每个位置，并实时更新最远可以到达的位置。
            每次更新后判断 最远可到达位置 是否 超过了数组长度 是的话返回true
            如果遍历数组后，最远可到达位置 小于数组长度 则返回false;
     */
    public boolean canJump(int[] nums) {
        // 贪心算法
        int len = nums.length;
        int rightmost = 0;
        for(int i=0;i<len;i++){
            if(i <= rightmost){
                rightmost = Math.max(rightmost,i+nums[i]);
                if(rightmost >= len-1){
                    return true;
                }
            }
        }
        return false;
    }
}
