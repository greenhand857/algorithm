package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;

// 3. 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
public class _03_LengthOfLongestSubstring {
/*
    算法思路 ： 滑动窗口
    1. 建立一个256位大小的整形数组，用于建立字符和其 出现位置的 映射关系
    2. 维护一个滑动窗口，窗口内都是没有重复的字符，窗口不断向右移动，尽可能的扩大窗口
        (1) 如果当前遍历到的字符从未出现过，可以直接扩大右边界；
        (2) 如果当前遍历到的字符出现过，则缩小窗口(左侧索引向右移动到 重复位置的下一位置)
        (3) 维护一个结果res，用于更新窗口长度的最大值
 */

    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0,j=0;j<s.length();j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(map.get(ch),i);       // 避免左侧索引 后退 只有当map中的映射位置在滑动窗口内部时才更新左侧索引
            }
            res = Math.max(res,j-i+1);
            map.put(ch,j+1);                      // map的映射主要是用来更新左侧索引i的，不重复位置从j+1开始
        }
        return res;
    }

    // 优化，当字符集较小时，可以使用一个整数数组来替代map，节省额外空间
    // 常用 int[26] 用于字母'a'-'z'或'A'-'Z' int[128] 用于ASCII码  int[256] 用于扩展ASCII码
    public static int lengthOfLongestSubstring1(String s){
        int res = 0;
        int[] map = new int[128];
        for(int i=0,j=0;j<s.length();j++){
            i = Math.max(map[s.charAt(j)],i);
            res = Math.max(res,j-i+1);
            map[s.charAt(j)] = j + 1;
        }
        return res;
    }
}
