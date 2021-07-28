package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;
// 1. 两数之和
public class _01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[] {map.get(num),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Such Solution");
    }
}