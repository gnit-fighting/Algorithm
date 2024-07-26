package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 岛屿数量-bfs
 */
public class kama_99_2 {
    static int[][] grid;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static   ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//行数
        int M = scanner.nextInt();//列数

        grid = new int[N][M];//图
        visited = new boolean[N][M];
        int ans = 0 ;//统计结果

        //读取输入的图
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && grid[i][j]==1){
                    ans++;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    bfs();
                }
            }
        }


        System.out.println(ans);
    }

    public  static void bfs(){
        while (!queue.isEmpty()) {
            //对头元素出队
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            //遍历当前节点（队头元素）的四个方向，如果没访问过的陆地，入队
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX < 0 || nextX >= grid.length || nextY < 0|| nextY >= grid[0].length) {
                    continue;
                }
                if (!visited[nextX][nextY]&&grid[nextX][nextY] == 1) {
                    //访问该节点
                    visited[nextX][nextY] = true;//细节：加入队列就代表该陆地被访问过，如果等到取出后才标记访问的话，会导致某些节点被重复加入
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
    }
}
