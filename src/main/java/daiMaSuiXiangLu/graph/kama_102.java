package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 沉没孤岛
 * 题目解读：将孤岛的 1 变成 0
 *
 * 思路：
 * 1.先遍历四条边能触及的所有岛屿，标记为 visted
 * 2.遍历剩下的矩阵，把【1&&!visited】的点变成 0
 *
 * 优化：
 * 不需要定义二维数组 visted，遍历四边标记访问过可以用特殊数字比如 2，输出结果的时候判断一下就行
 */
public class kama_102 {
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int[][] grid;
    static boolean[][] visited;

    static ArrayDeque<int[]> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//行数
        int M = scanner.nextInt();//列数

        grid = new int[N][M];//图
        visited = new boolean[N][M];

        //读取输入的图
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        queue = new ArrayDeque<>();
        int ans = 0;
        //先把四边能触及到的所有陆地遍历了，这样每个岛屿的起始点都是边边上的点
        //访问过某个点，直接赋值该点为 0 即可
        //上边、下边
        for (int j = 0; j < M; j++) {
            if (!visited[0][j] && grid[0][j] == 1) {
                queue.add(new int[]{0, j});
                visited[0][j] = true;
                bfs(0);
            }
            if (!visited[N - 1][j] && grid[N - 1][j] == 1) {
                queue.add(new int[]{N - 1, j});
                visited[N - 1][j] = true;
                bfs(0);
            }
        }
        //右边、左边
        for (int i = 0; i < N; i++) {
            if (!visited[i][M - 1] && grid[i][M - 1] == 1) {
                queue.add(new int[]{i, M - 1});
                visited[i][M - 1] = true;
                bfs(0);
            }
            if (!visited[i][0] && grid[i][0] == 1) {
                queue.add(new int[]{i, 0});
                visited[i][0] = true;
                bfs(0);
            }
        }


        //遍历除去四边后的矩阵，统计1的数量即可
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    grid[i][j] = 0;
                }
            }
        }

        //输出沉没孤岛之后的岛屿
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 广度遍历
     *
     * @param curArea 当前面积,调用本方法时传入 0
     * @return 本岛屿的面积（只要是连成岛屿，从一个点出发的 bfs 肯定能遍历完整个岛屿）
     */
    public static int bfs(int curArea) {
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            int curX = pop[0];
            int curY = pop[1];
            for (int k = 0; k < 4; k++) {
                int nextX = curX + dir[k][0];
                int nextY = curY + dir[k][1];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || visited[nextX][nextY] || grid[nextX][nextY] == 0) {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                curArea++;
            }
        }
        return curArea;
    }

}
