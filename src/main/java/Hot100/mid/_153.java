package Hot100.mid;

/**
 * 寻找旋转排序数组的最小值
 */
public class _153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int maybe_min = 5001;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            //左区间【l , mid】
            //右区间【mid+1，r】
            //如果左区间有序
            if (nums[l] <= nums[mid]) {
                maybe_min = maybe_min < nums[l] ? maybe_min : nums[l];
                //去无序序列（右区间）继续二分
                l = mid + 1;
            } else {
                //如果右区间有序
                if (r >= mid + 1) {
                    maybe_min = maybe_min < nums[mid + 1] ? maybe_min : nums[mid + 1];
                    //去无序序列（左）继续二分
                    r = mid;
                }
            }

        }
        return maybe_min;
    }
}
