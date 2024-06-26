package Hot100.mid;

/**
 * 搜索二维矩阵 II
 */
public class _240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //利用矩阵的元素规律
        //每次可以砍掉一行/一列

        int starti = 0;
        int endi = matrix.length - 1;
        int startj = 0;
        int endj = matrix[0].length - 1;

        while (starti <= endi && startj <= endj) {
            //和右上角元素比较
            if (matrix[starti][endj] == target) {
                return true;
            }
            if (matrix[starti][endj] > target) {
                endj--;
                continue;
            }
            if (matrix[starti][endj] < target) {
                starti++;
            }
        }

        return false;
    }
}
