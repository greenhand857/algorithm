package LeetCodeHot100;
// 盛最多水的容器
public class _011_MaxArea {
    // 算法思路： 设置双指针 i,j 分别位于容器壁两端。
    // 每次向内移动较小的一侧，并且更新面积最大值 res，直到 i == j 时返回 res。
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while(i < j){

            res = Math.max(res,height[i]<height[j] ? (j-i)*height[i++]
                    : (j-i)*height[j--]);
        }
        return res;
    }

    public int maxArea_1(int[] height){
        int i=0;
        int j = height.length-1;
        int res = 0;

        while (i < j){
            if(height[i] < height[j]){
                res = Math.max(res,height[i]*(j-i));
                i++;
            }else {
                res = Math.max(res,height[j]*(j-i));
                j--;
            }
        }
        return res;
    }
}
