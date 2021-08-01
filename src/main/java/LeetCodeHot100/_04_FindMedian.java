package LeetCodeHot100;

public class _04_FindMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;

        // len为奇数时 left==right
        int left = (len + 1)/2;
        int right = (len + 2)/2;
        double res = (getKth(nums1,0,m-1,nums2,0,n-1,left) + getKth(nums1,0,m-1,nums2,0,n-1,right)) * 0.5;
        return res;
    }

    private static int getKth(int[] nums1,int l,int r,int[] nums2,int i,int j,int k){
        int len1 = r-l+1;
        int len2 = j-i+1;
        // 保证len1<len2
        if(len1 > len2) return getKth(nums2,i,j,nums1,l,r,k);
        if(len1 == 0) return nums2[i + k - 1];

        if(k == 1) return Math.min(nums1[l],nums2[i]);

        int x = l + Math.min(len1,k/2) - 1;
        int y = i + Math.min(len2,k/2) - 1;

        if(nums1[x] < nums2[y]){
            return getKth(nums1,x+1,r,nums2,i,j,k-(x-l+1));
        }else {
            return getKth(nums1,l,r,nums2,y+1,j,k-(y-i+1));
        }

    }
}
