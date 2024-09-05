package daiMaSuiXiangLu.graph.disjointSet;

import java.util.Scanner;

/**
 * 寻找存在的路径
 * 题目解读：
 * 1.并查集的应用：在用一个集合的元素都是连通的（存在路径）
 * 2.故即检查两个节点是否属于同一个集合：isSame（u，v）
 */
public class kama_107 {
    //初始化并查集
    static int[] father = new int[101];//0弃用 1<=M,N<=100

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//节点个数(节点 1-N)
        int M = scanner.nextInt();//边数

        init(N);

        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            join(s,t);
        }

        int source = scanner.nextInt();
        int destination = scanner.nextInt();
        if (isSame(source,destination)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

    }

    //初始化并查集
    public static void init( int N) {
        for (int i = 1; i <= N + 1; i++) {
            father[i] = i;
        }
    }

    //查找根节点
    public static int find(int x) {
        if (x != father[x]) {
            father[x] = find(father[x]);
        }
        return father[x];
    }

    //判断两个节点的根是否相同（判断连通性/判断是否在同一个集合）
    public static boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    //合并集合
    public static void join(int x, int y) {
        //理解为什么join(x,y)的时候需要找到各自的根之后再建立连接
        //为什么不能直接 father[y] = x?
        //答：举例子 先join（1，2），再 join（3，2） 看看知道了
        //直接 father[y] = x ： 结果是 1 和 3 就不同源了；
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            father[fy] = fx;
        }
    }
}
