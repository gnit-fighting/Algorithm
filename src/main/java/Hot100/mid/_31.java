package Hot100.mid;

import java.util.Arrays;

/**
 * 下一个排列
 */
public class _31 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 0, 4, 3, 1};
        new _31().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int k = -1;
        int i;
        for (i = nums.length - 1; i > 0; ) {
            if (nums[i] <= nums[i - 1]) {
                i--;
            } else {
                k = i - 1;
                break;
            }
        }
        if (i == 0) {
            //该序列已经是最大的排列了
            //返回升序序列[翻转]
            reverse(nums, 0, nums.length - 1);
            return;
        }
        //寻找最小的比 k 大的数(倒序找)，交换,交换后 k 后面的序列仍然是降序的
        for (int j = nums.length - 1; j > k; j--) {

            if (nums[j] > nums[k]) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;

                //k 之后的序列需要调整为升序【reverse】
                reverse(nums, k + 1, nums.length - 1);
                return;

            }
        }


    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
