package Hot100.mid;

import java.util.ArrayDeque;

public class _200 {
    static int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    /**
     岛屿数量
     图论-bfs、dfs
     */
    public int numIslands(char[][] grid) {
        int res = 0 ;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j]&&grid[i][j]=='1'){
                    queue.add(new int[]{i,j});
                    visited[i][j] =  true;
                    res++;
                    bfs(queue,grid,visited);
                }
            }
        }
        return  res;
    }
    public void bfs(ArrayDeque<int[]> queue,char[][] grid,boolean[][] visited){
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0]+directions[i][0];
                int nextY = poll[1]+directions[i][1];

                if (nextX< 0 || nextX>= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY]=='0') {
                    continue;
                }
                if (!visited[nextX][nextY]) {
                    queue.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
