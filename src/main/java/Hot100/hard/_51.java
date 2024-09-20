package Hot100.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 */
public class _51 {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);

    }

    //回溯
    //1.回忆回溯树的结构。
    //2.递归深度：行数 n （每次处理一行，每行只能放一个皇后）
    //3.for 循环宽度 ： 遍历当前行的所有列，考察该位置能否放置皇后

    public static List<List<String>> solveNQueens(int n) {
        //1.初始化棋盘
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();


        backtracking(chessBoard, 0, n,ans);
        return ans;
    }

    /**
     * @param chessBoard 棋盘
     * @param row        本轮将要处理的行
     * @param n          总行数
     */
    public static void backtracking(char[][] chessBoard, int row, int n,List<List<String>> ans ) {
        if (row == n) {
            //收集结果
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(chessBoard[i]));
            }
            ans.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(chessBoard, row, j, n)) {
                chessBoard[row][j] = 'Q';
                backtracking(chessBoard, row + 1, n,ans);
                chessBoard[row][j] = '.';
            }
        }

    }

    public static boolean isValid(char[][] chessBoard, int row, int col, int n) {
        if (chessBoard[row][col] == 'Q') {
            return false;
        }
        //检查同列、同斜线有没有已经放置的皇后（不用检查同行，因为本来就是按照行递归的）
        //同列
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        //同斜线(45度)
        for (int i = 1; i < n; i++) {
            //45度
            if (row - i >= 0 && col - i >= 0 && chessBoard[row - i][col - i] == 'Q') {
                return false;
            }
            //135度
            if (row - i >= 0 && col + i < n && chessBoard[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true;
    }

}
