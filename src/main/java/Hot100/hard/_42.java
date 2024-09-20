package Hot100.hard;

/**
 * 接雨水
 */
public class _42 {
    public int trap(int[] height) {
        //双指针-前后缀最大值
        int n = height.length;
        int ans = 0;
        int preMax = 0;
        int sufMax = 0 ;
        int left = 0;
        int right = n-1;

        while (left <= right){
            preMax = Math.max(preMax,height[left]);
            sufMax = Math.max(sufMax,height[right]);

            if (preMax<sufMax) {
                ans+=preMax-height[left];
                left++;
            }else {
                ans += sufMax-height[right];
                right--;
            }

        }
        return  ans;

    }
}
