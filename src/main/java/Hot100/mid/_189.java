package Hot100.mid;

import java.util.Arrays;

public class _189 {
    public void rotate(int[] nums, int k) {
        //跟翻转字符串是一样的思路 - 空间复杂度为O(1)
        if (k == 0) {
            return;
        }
        //细节：处理一下轮转次数 k 大于等于nums.length的情况： 模nums.length
        if (k >= nums.length) {
            k = k % nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    //双指正法 - 翻转数组
    public void reverse(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //拷贝新数组法
    public void rotate1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int j = 0;
        k = k % nums.length;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }

}
