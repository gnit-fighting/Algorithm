package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

public class _797_2 {
    int N;
    List<List<Integer>> result;
    List<Integer> path;
    boolean[] visited;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        new _797_2().allPathsSourceTarget(graph);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //获取节点个数
        N = graph.length;
        visited = new boolean[N];

        path = new ArrayList<>();
        result = new ArrayList<>();

        path.add(0);
        dfs(graph, 0);

        return result;
    }

    public void dfs(int[][] graph, int idx) {

        //终止条件
        if (idx == N - 1) {
            //收集结果
            result.add(new ArrayList<>(path));
            return;
        }

        //依次访问当前节点的领结节点
        for (int i = 0; i < graph[idx].length; i++) {
            //当前领结节点未访问过，访问之
            if (!visited[graph[idx][i]]) {
                visited[graph[idx][i]] = true;
                path.add(graph[idx][i]);

                //dfs递归
                dfs(graph, graph[idx][i]);

                //回溯
                path.remove(path.size() - 1);
                visited[graph[idx][i]] = false;
            }
        }
    }
}
