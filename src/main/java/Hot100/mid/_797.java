package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 */
public class _797 {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0);
        return result;

    }

    public void dfs(int[][] graph, int idx) {
        if (path.size() > 0 && path.get(path.size() - 1) == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[idx].length; i++) {
            path.add(graph[idx][i]);

            dfs(graph, graph[idx][i]);

            path.remove(path.size() - 1);

        }
    }

}
