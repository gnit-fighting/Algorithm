package Hot100.mid;

/**
 * 搜索旋转排序数组
 */
public class _33 {
    public int search(int[] nums, int target) {
        //基本：二分法
        //二分之后，一定有一个有序序列，另一个乱序/有序
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //两个区间[l,mid-1]  [mid+1,r]
            if (mid - 1 < l && mid + 1 > r) {
                return -1;
            }
            //若左区间有序，且 target 落下左区间内
            if (mid - 1 >= l && nums[l] <= nums[mid - 1]) {
                if (nums[l] <= target && target <= nums[mid - 1]) {
                    //到左区间寻找
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (mid + 1 <= r) {
                    if (nums[mid + 1] <= target && target <= nums[r]) {
                        //到右区间寻找
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
