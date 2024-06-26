package Hot100.mid;

/**
 * 盛最多水的容器
 */
public class _11 {

    public int maxArea(int[] height) {
        int len = height.length;


        int i = 0;
        int j = len - 1;
        int max = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                int water = (j - i) * height[i];
                max = max > water ? max : water;
                //此时，固定 i（高度小的） 不动的话，j 减小，水的面积也不会超过 water
                //所以等于 i 这一行的值可以不用看了
                i++;
            } else {
                int water = (j - i) * height[j];
                max = max > water ? max : water;

                //此时，固定j不动，i 增大，水的面积也不会超过 water
                //所以等于 j 这一列的值可以不同看了
                j--;
            }
        }

        return max;


    }
}
