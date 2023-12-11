import java.util.ArrayList;
import java.util.List;

/*
 * 다른 dfs 문제와 다른점
 * - 이미 지났던 정점을 다시 지나쳐서(되돌아가기) 다른 정점으로 갈 수 있다.
 * - 즉, 해당 정점에 대한 반영은 한 번만 이루어지지만 재방문은 제약이 없음(최초 방문시 합류한 동물이 계속 따라다니기 때문)
 * => 양방향 그래프 X, 단방향 + 다음에 이동 가능한 정점 정보 기억
 *    다음에 이동 가능한 정점 += 현재 방문 정점의 자식 정점
 * */

class Solution {
    public static class Graph {
        private List<List<Integer>> adjacencyList;

        public Graph(int n) {
            adjacencyList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public List<Integer> getChild(int v) {
            return adjacencyList.get(v);
        }

        public void addEdge(int v, int w) {
            adjacencyList.get(v).add(w);
        }
    }

    static int maxSheep = 0;
    static int[] vertexInfo;
    static Graph graph;

    public int solution(int[] info, int[][] edges) {
        vertexInfo = info;
        graph = new Graph(info.length);
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // 다음 차례에 이동 가능한 정점
        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(0, 0, 0, next);

        return maxSheep;
    }

    private void dfs(int v, int sheep, int wolf, List<Integer> next) {
        if (vertexInfo[v] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        // 재귀 탈출 조건 
        if (wolf >= sheep) {
            return;
        }

        // 양 최대값 갱신
        maxSheep = Math.max(maxSheep, sheep);

        // 독립적인 객체로 복사해서 재귀 호출해야함. 다른 탐색에 영향을 주면 안되기 때문
        List<Integer> currNext = new ArrayList<>(next);

        // 방문 정점 제거
        currNext.remove(Integer.valueOf(v));

        // 방문 정점의 자식 정점 추가
        currNext.addAll(graph.getChild(v));

        // 제귀 호출
        for (int n : currNext) {
            dfs(n, sheep, wolf, currNext);
        }
    }
}