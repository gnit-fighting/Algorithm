package Hot100.mid;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        //二分查找找 target 的边界 - 二分查找变形
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        if (nums.length==0|| leftBound>= nums.length||nums[leftBound] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{leftBound, rightBound};
    }

    public static int leftBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] >= target) {
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        //否target 不存在的话，l 指向应该插入的位置
        return l;//左边界存在的话，l 指向左边界
    }

    public static int rightBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            }
            if (nums[mid] <= target) {
                l = mid + 1;
            }
        }
        return r;//右边界存在的话，r指向左边界
    }
}
