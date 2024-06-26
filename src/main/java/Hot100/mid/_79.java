package Hot100.mid;

/**
 * 单词搜索
 */
public class _79 {
    int wordlen;
    int m, n;
    char[][] BOARD;
    String WORD;
    boolean find = false;


    public boolean exist(char[][] board, String word) {
        wordlen = word.length();
        m = board.length;
        n = board[0].length;
        BOARD = board;
        WORD = word;
        if(n==1 && m==1 && wordlen==1 && board[0][0]==word.charAt(0)){
            return  true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(i, j, 0);
                if(find){
                    return find;
                }
            }
        }
        return find;
    }

    public void backtracking(int i, int j, int k) {
        if(find){
            return;
        }
        //下标越界，返回 false
        if (i < 0 || i == m || j < 0 || j == n) {
            return ;
        }
        //已经匹配完 word 了，收集结果
        if (k == wordlen) {
            find = true;
            return ;
        }
        //该方向上的字符不符合 word 序列,返回 false
        if (BOARD[i][j] != WORD.charAt(k)) {
            return ;
        }

        //到这里，本方向上的字符和 word 序列索引上的字符相同
        //dfs 按照下右上左的顺序
        int[][] ways = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//方向向量
        for (int l = 0; l < 4; l++) {
            //标记当前匹配元素，防止重复匹配
            BOARD[i][j] = '0';
            backtracking(i + ways[l][0], j + ways[l][1], k + 1);

            //回溯
            BOARD[i][j] = WORD.charAt(k);
        }
    }
}
