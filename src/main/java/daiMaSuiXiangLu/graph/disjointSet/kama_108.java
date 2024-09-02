package daiMaSuiXiangLu.graph.disjointSet;

import java.util.Scanner;

/**
 * 冗余连接
 * 思路：
 * 1.读取输入，依次将边加入并查集，如果两个节点属于同一个集合，则说明存在环，返回该边(即这条边一定是冗余边)
 * 2.依题意，冗余边有且只有一条（对 n 个节点的树，一定有且仅有 n-1 条边）
 */
public class kama_108 {
    static int[] father = new int[1001];

    static void init(int N) {
        for (int i = 1; i <= N; i++) {
            father[i] = i;
        }
    }

    static int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }


    static boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            father[fy] = fx;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        init(N);
        for (int i = 0; i < N; i++) {
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();

            if (isSame(i1, i2)) {
                System.out.println(i1 + " " + i2);
                return;
            } else {
                join(i1, i2);
            }
        }
    }
}
