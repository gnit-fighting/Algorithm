package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 水流问题
 * 题目解读：类似岛屿问题，修改判定“相邻”的条件即可
 * 思路：
 * 1.bfs 修改将点加入 queue 的逻辑：四个方向相邻 && 领居较低/等高
 * 优化：
 * 1.不需要对每个点 bfs，直接从两种边界bfs 即可，标记从边界能访问的点
 * 2.对于两种边界都能访问到的点，收集答案
 */
public class kama_103 {
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] grid;
    static ArrayDeque<int[]> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//行数
        int M = scanner.nextInt();//列数

        grid = new int[N][M];//图

        //读取输入的图
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        queue = new ArrayDeque<>();
        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                queue.add(new int[]{i, j});
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                boolean[] touchedBorder = bfs(new boolean[]{false, false}, visited);
                if (touchedBorder[0] && touchedBorder[1]) {
                    ans.add(new int[]{i, j});
                }
            }
        }


        //输出结果
        for (int[] ansItem : ans) {
            System.out.println(ansItem[0] + " " + ansItem[1]);
        }

    }

    /**
     * 广度遍历-遍历从起点开始水流能流向的区域
     *
     * @param touchedBorder 是否触及两条边界（第一条：上左；第二条：右下）
     * @return touchedBorder
     */
    public static boolean[] bfs(boolean[] touchedBorder, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            int curX = pop[0];
            int curY = pop[1];

            //如果触及了第一组边界
            if (curX == 0 || curY == 0) {
                touchedBorder[0] = true;
            }
            //如果触及了第二组边界
            if (curX == grid.length - 1 || curY == grid[0].length - 1) {
                touchedBorder[1] = true;
            }
            //如果触及了两条边界，则返回
            if (touchedBorder[0] == true && touchedBorder[1] == true) {
                //注意清空 queue
                queue.clear();
                return touchedBorder;
            }

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dir[k][0];
                int nextY = curY + dir[k][1];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || visited[nextX][nextY] || grid[nextX][nextY] > grid[curX][curY]) {
                    continue;
                }

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
        return touchedBorder;
    }

}
