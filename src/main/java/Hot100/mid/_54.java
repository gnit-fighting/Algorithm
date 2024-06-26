package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class _54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        //处理只有一行的情况
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                result.add(matrix[0][j]);
            }
            return result;
        }

        //处理只有一列的情况
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }

        //处理矩形的情况
        int startX = 0;
        int startY = 0;
        int endY = n - 2;
        int endX = m - 2;

        while (true) {
            int i = startX, j = startY;
            if (startX > endX && startY > endY) {
                break;
            }
            //上
            for (j = startY; j <= endY; j++) {
                result.add(matrix[i][j]);
            }
            //右
            for (i = startX; i <= endX; i++) {
                result.add(matrix[i][j]);
            }
            //下
            if (endX < startX) {
                //当某一圈只有上下边没有左右边的情况
                //上边已经把这行除了最后一个元素都遍历了
                //下边只需要添加最后一个元素
                result.add(matrix[i][j]);
            } else {
                for (; j >= startY + 1; j--) {
                    result.add(matrix[i][j]);

                }
            }

            //左
            if (endY < startY) {
                //当某一圈只有左右边没有上下边的情况
                //右边已经把这列除了最后一个元素都遍历了
                //左边只需要添加最后一个元素
                result.add(matrix[i][j]);
            } else {
                for (; i >= startX + 1; i--) {
                    result.add(matrix[i][j]);
                }
            }

            startX++;
            startY++;
            endY--;
            endX--;
            if (endY < 0 || endX < 0) {
                break;
            }
        }
        //特殊处理边长为奇数的正方形，输出中间元素
        if (m == n && m % 2 != 0) {
            result.add(matrix[m / 2][n / 2]);
        }


        return result;
    }
}
