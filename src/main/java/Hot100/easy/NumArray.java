package Hot100.easy;

public class NumArray {
    int[] nums;
    int[] preSum;


    public NumArray(int[] nums) {
        this.nums = nums;
        getPreSum(nums);

    }

    public int sumRange(int left, int right) {

        return  preSum[right+1] - preSum[left];
    }
    public void getPreSum(int[] nums){
        preSum = new int[nums.length+1];
        int sum = 0 ;
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            preSum[i+1] = sum;
        }


    }


}
