package Hot100.easy;

/**
 * 搜索插入位置
 */
public class _35 {
    public int searchInsert(int[] nums, int target) {

        int l = 0 ;
        int r = nums.length-1;
        int mid ;
        while (l<=r){
            mid= l + ((r-l)>>1);
            if(nums[mid] == target){
                return  mid;
            }
            if(nums[mid] > target){
                r = mid-1;
            }
            if(nums[mid]<target){
                l = mid+1;
            }
        }
        return  l;

    }
}
