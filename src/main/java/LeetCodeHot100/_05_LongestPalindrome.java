package LeetCodeHot100;

public class _05_LongestPalindrome {
    // Q:返回一个字符串的最长回文子串
    // 注意：牛客17题是求最长回文子串的长度，力扣是返回最长回文子串
    // 1. 暴力解法 判断每一个子串是否为回文串 n^3
    public String longestPalindrome_1(String s) {
        if(s.length() < 2) return s;

        int maxlen = 1;  // 记录最长回文子串的长度
        int begin = 0;   // 记录起始位置
        char[] chs = s.toCharArray();

        // 枚举所有长度>1的子串，判断是否是回文串
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(j-i+1>maxlen && validPalindrome(chs,i,j)){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    // 判断子串是否为回文串
    private boolean validPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 2. 中心扩展法 枚举所有回文子串的中心位置 中心位置可能为一个字符，也可能是两个相邻字符
    public static String longestPalindrome_2(String s){
        if(s.length() < 2) return s;

        int maxLen = 1;
        int begin = 0;
        char[] chs = s.toCharArray();

        for(int i=0;i<s.length()-1;i++){  //不需要遍历到最后，因为不会从s.length()-1位置扩散的
            int oddLen = expandAroundCentter(chs,i,i);  // 以i为中心的奇数回文子串长度
            int evenLen = expandAroundCentter(chs,i,i+1); // 以i 和i+1为中心的偶数回文子串长度

            int curMaxLen = Math.max(oddLen,evenLen);
            if(curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (maxLen-1)/2;    // 细节定制 在纸上画一下
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private static int expandAroundCentter(char[] chs,int left,int right){
        // 当left = right时，回文中心是一个字符，回文串的长度是奇数
        // 当 right = left+1 时，回文中心是两个字符，长度为偶数
        while(left >=0 && right < chs.length){
            if(chs[left] == chs[right]){
                left--;
                right++;
            }else{
                break;
            }
        }
        // 跳出循环时，恰好满足s.charAt(i) != s.charAt(j) 回文串长度为 j-i+1-2 --> j-i-1
        return right-left-1;
    }

    // 动态规划算法
    // 定义状态  dp[i][j] 表示子串s[i..j]是否为回文子串
    // 状态转移方程：dp[i][j] = (s[i]==s[j] && (j-i<3 || dp[i+1][j-1]))
    // 边界条件 当j-1 - (i+1) + 1 < 2时，不用检查是否回文，直接返回true 即j-i<3
    // 初始化 dp[i][i] = true
    // 在得到一个状态的值为true时 记录起始位置和长度
    public static String longestPalindrome_3(String s){  //暴力解的优化 o(n^2)
        if(s.length() < 2) return s;

        int maxlen = 1;
        int begin = 0;
        char[] chs = s.toCharArray();

        // 动态规划
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){   // 对角线初始化
            dp[i][i] = true;
        }
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(chs[i] != chs[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 只要dp[i][j]==true成立，就表示该子串时回文的，需要更新最长子串的长度和起始位置
                if(dp[i][j] && j-i+1 > maxlen){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    // Manacher算法 专门用于查找最长回文子串的算法 时间复杂度o(n)
    // 对原始字符串进行预处理，再在预处理的字符串上执行中心扩散算法  #A#B#A#A#B#A
    // （预处理后的最长回文子串长度 - 1)/2 = 原始字符串的最长回文子串长度
    public static String longestPalindrome_4(String s){
        if(s.length() < 2) return s;

        int maxlen = 1;
        int begin = 0;
        char[] chs = s.toCharArray();


        return s.substring(begin,begin+maxlen);
    }

}
