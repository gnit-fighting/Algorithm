package Hot100.easy;


/**
 * 有序数组转为平衡二叉搜索树
 */
public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return toBSTbyBinary(nums, 0, nums.length - 1);
    }

    public TreeNode toBSTbyBinary(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBSTbyBinary(nums, left, mid - 1);
        root.right = toBSTbyBinary(nums, mid + 1, right);
        return root;
    }
}
