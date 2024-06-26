package Hot100.mid;

import java.util.Random;
import java.util.RandomAccess;

/**
 * 快排
 */
public class _912 {
    Random random = new Random();

    public int[] sortArray(int[] nums) {
        //升序
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotpos = partition(nums, low, high);
            quickSort(nums, low, pivotpos - 1);
            quickSort(nums, pivotpos + 1, high);
        }
        return nums;
    }

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
        return low;
    }


    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
