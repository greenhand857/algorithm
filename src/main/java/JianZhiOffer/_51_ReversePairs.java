package JianZhiOffer;

public class _51_ReversePairs {
    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length<2) return 0;
        return process(nums,0,nums.length-1);
    }

    public static int process(int[] arr,int l,int r){
        if(l == r) return 0;
        int mid = l + ((r-l)>>1);
        int res = process(arr,l,mid) + process(arr,mid+1,r)
                + merge(arr,l,mid,r);
        return res;
    }

    public static int merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int res = 0;
        while(p1<=mid && p2<=r){
            res += arr[p1]>arr[p2] ? mid-p1+1 : 0;
            help[i++] = arr[p1]<=arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {7,5,6,4};
        System.out.println(reversePairs(arr));
    }
}
