package leetcode.hot100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution207 {

    private int N = 10010;
    private int[] h = new int[N];
    private int[] e = new int[N];
    private int[] ne = new int[N];
    private int idx = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.fill(h, -1);
        // 拓扑排序
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            add(pre, cur);
            inDegree[cur]++;
        }
        // 所有入度为 0 的点入队
        Deque<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 从入度为 0 的节点开始拓扑排序
        while (!queue.isEmpty()) {
            int x = queue.poll();
            count++;
            for (int i = h[x]; i != -1; i = ne[i]) {
                int next = e[i];
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}