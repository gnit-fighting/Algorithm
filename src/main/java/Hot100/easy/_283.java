package Hot100.easy;

/**
 * 移动零
 */
public class _283 {
    public void moveZeroes(int[] nums) {
        //快慢指针
        int fast = 0; //找不是零的元素
        int slow = 0 ;  //更新数组
        //把非零元素全部更新在前面
        while (slow <= fast && fast < nums.length){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }else {
                fast++;
            }
        }
        //把剩余的全部更新为 0
        while (slow < nums.length){
            nums[slow++] = 0 ;
        }
    }
}
