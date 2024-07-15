import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, Q;
    private static ArrayList<ArrayList<Node>> list = new ArrayList<>();//정점, 간선 저장 리스트

    private static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // n+1 개의 정점 생성(i=0은 비워둠)
        for (int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        // n-1개의 간선 저장
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //양방향
            list.get(v1).add(new Node(v2, cost));
            list.get(v2).add(new Node(v1, cost));
        }

        // 계산 및 출력.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(findVideo(k, v)).append("\n");
        }

        System.out.println(sb);
    }

    // bfs 수행
    public static int findVideo(int k, int v) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        // 시작 영상 추가
        q.add(new Node(v, Integer.MAX_VALUE));
        visited[v] = true;

        int cnt = 0;
        int USADO;  // 두 쌍의 유사도

        //v와 k이상 연관된 영상 모두 찾기.
        while (!q.isEmpty()) {
            Node curr = q.poll();
            ArrayList<Node> link = list.get(curr.v); // 연결된 영상들

            // 연결된 영상들 모두 탐색
            for (Node node : link) {
                // 이미 확인한 영상 제외
                if (visited[node.v]) continue;

                // 현재 영상과 연결된 경로의 최솟값 갱신.
                USADO = Math.min(node.cost, curr.cost);

                /*
                 * v1와 연결된 정점 v2가 있을때 만약 유사도가 k보다 작다면, 그뒤로 v2와 연결된 모든 정점은 k보다 낮은 유사도를 갖는다.
                 * 연결된 정점들의 최소 가중치를 구하기 때문 -> 따라서 k이상 연관된 영상만 탐색을 계속 진행한다.
                 * */
                if (USADO >= k) {
                    visited[node.v] = true;
                    cnt++;
                    q.add(new Node(node.v, USADO));
                }
            }
        }

        return cnt;
    }
}
