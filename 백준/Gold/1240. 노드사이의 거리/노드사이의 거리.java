import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static int N;   // 노드의 개수
    static int M;   // 쌍의 개수
    static List<List<Node>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            tree.get(v).add(new Node(w, d));
            tree.get(w).add(new Node(v, d));
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            sb.append(find(v, w)).append('\n');
        }

        System.out.println(sb);
    }

    public static int find(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr.next == end) {
                return curr.cost;
            }

            for (Node node : tree.get(curr.next)) {
                if (!visited[node.next]) {
                    queue.add(new Node(node.next, curr.cost + node.cost));
                    visited[node.next] = true;
                }
            }
        }
        return 0;
    }
}