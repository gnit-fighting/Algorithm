package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 孤岛的总面积
 *
 * 思路：
 * 1.先把四边能触及到的所有陆地遍历了，若当前点遍历过了（加入队列）则把该陆地（1）变成海洋（0）
 * 2.统计去掉四条边之后的矩形的 1 的数量（即孤岛的总面积）
 */
public class kama_101 {
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
        //上边
        for (int j = 0; j < M; j++) {
            if (!visited[0][j] && grid[0][j]==1) {
                queue.add(new int[]{0,j});
                grid[0][j] = 0 ;
                bfs(0);
            }
        }
        //右边
        for (int i = 0; i < N; i++) {
            if (!visited[i][M-1] && grid[i][M-1]==1) {
                queue.add(new int[]{i,M-1});
                grid[i][M-1] = 0 ;
                bfs(0);
            }
        }
        //下边
        for (int j = 0; j < M; j++) {
            if (!visited[N-1][j] && grid[N-1][j]==1) {
                queue.add(new int[]{N-1,j});
                grid[N-1][j] = 0 ;
                bfs(0);
            }
        }
        //左边
        for (int i = 0; i < N; i++) {
            if (!visited[i][0] && grid[i][0]==1) {
                queue.add(new int[]{i,0});
                grid[i][0] = 0 ;
                bfs(0);
            }
        }

        //遍历除去四边后的矩阵，统计1的数量即可
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(grid[i][j]==1){
                    ans+=1;
                }
            }
        }
        System.out.println(ans);
    }

    /**
     * 广度遍历
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
                grid[nextX][nextY]=0;
                curArea++;
            }
        }
        return curArea;
    }

}
