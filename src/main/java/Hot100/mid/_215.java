package Hot100.mid;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.Random;

/**
 * 数组中第 K 大元素
 */
public class _215 {
    //桶排序
    public int findKthLargest0(int[] nums, int k) {
        //-10 4 <= nums[i] <= 10 4
        //由于数组元素范围有限制，可以用桶排序
        int[] bucket = new int[20001];
        for (int i : nums) {
            bucket[i + 10000]++;
        }
        //遍历桶，找到第 k 大的元素
        for (int i = bucket.length - 1; i >= 0; i--) {
            k -= bucket[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return -1;
    }

    //快速选择
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        //第 k 大，在 len-k 的位置
        int target = len - k;
        int low = 0;
        int high = len - 1;
        while (true) {
            int partitionpos = partition(nums, low, high);
            if (partitionpos == target) {
                return nums[partitionpos];
            } else {
                if (partitionpos < target) {
                    low = partitionpos + 1;
                } else {
                    high = partitionpos - 1;
                }
            }
        }

    }


    Random random = new Random();

    //每次 partition 可以确定 pivot 的最终位置
    public int partition(int[] nums, int low, int high) {
        //把nums[low]和随机一个元素交换（防止快排退化成 O（n 方））
        //random ： low - high
        int i = random.nextInt(high - low + 1) + low;
        swap(nums, low, i);

        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                --high;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low; //返回 pivot 的位置
    }


    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

}
