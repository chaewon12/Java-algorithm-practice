import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Graph {
        private List<List<Integer>> adjacencyList;

        private boolean[] visited;

        public Graph(int n) {
            adjacencyList = new ArrayList<>(n+1);
            visited = new boolean[n + 1];
            for (int i = 0; i < n+1; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public List<Integer> getChild(int v) {
            return adjacencyList.get(v);
        }

        public void addEdge(int v, int w) {
            adjacencyList.get(v).add(w);
            adjacencyList.get(w).add(v);
        }
    }

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 그래프에 연결 정보 저장 
        Graph graph = new Graph(N);
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        answer = new int[N + 1];
        
        // 각 부모의 자식들을 순회하며 부모 저장 
        visitChild(graph, 1);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.println(sb);
    }

    public static void visitChild(Graph graph, int parents) {
        graph.visited[parents] = true;
        
        for (int child : graph.getChild(parents)) {
            if (!graph.visited[child]) {
                // 자식 인덱스에 부모 정보 저장
                answer[child] = parents;
                visitChild(graph, child);
            }
        }
    }
}