package Hot100.hard;

/**
 * 缺失的第一个正数
 * 思路：置换法【leetcode 官方题解】
 */
public class _41 {
    public int firstMissingPositive(int[] nums) {
        int n  = nums.length;
        //明白这一点：缺失的第一个正数只可能在：【1，n+1】

        //1.遍历数组，将出现在[1,n]的正整数放到自己的位置（交换），数值为 x 放到下标 x-1 处
        for (int i = 0; i < n;) {
            int x = nums[i];
            if (x>=1 && x<=n && i!=x-1) {
                if (nums[i]==nums[x-1]&&nums[x-1]==x) {
                    i++;
                    continue;
                }
                swap(nums,i,x-1);
                //swap 之后可不能 i++，因为可能被新换到nums[i]的元素也需要被考虑置换
            }else {
                i++;
            }
        }

        //2.遍历置换后的数组，在对应下标的元素如果不是期待值（下标 x的元素期待值为 x+1），说明这个值是缺失的第一个正数
        for (int i = 0; i < n; i++) {
            if (nums[i] !=i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
