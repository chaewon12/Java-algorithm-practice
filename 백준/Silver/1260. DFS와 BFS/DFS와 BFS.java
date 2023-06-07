import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N ;	// 정점 개수
	private static int M ;// 간선 개수
	private static int V ;// 시작 정점
	private static List<List<Integer>> graph;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for(int i=0;i<N+1;i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int v1 =Integer.parseInt(st.nextToken());
			int v2 =Integer.parseInt(st.nextToken());

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		// 문제 조건: 정점 번호가 작은 것을 먼저 방문
		for(int i=1;i<N+1;i++){
			Collections.sort(graph.get(i));
		}

		boolean[] visitedDFS = new boolean[N+1];
		boolean[] visitedBFS = new boolean[N+1];

		dfs(V,visitedDFS);
		sb.append('\n');
		bfs(V,visitedBFS);

		System.out.println(sb);
	}

	private static void dfs(int vertex,boolean[] visited) {
		if(visited[vertex]){
			return;
		}

		visited[vertex]=true;
		sb.append(vertex).append(" ");

		for(int v :graph.get(vertex)){
			dfs(v,visited);
		}
	}

	private static void bfs(int vertex,boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(vertex);
		visited[vertex]=true;
		sb.append(vertex).append(" ");

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int v : graph.get(curr)) {
				if (!visited[v]) {
					queue.offer(v);
					visited[v] = true;
					sb.append(v).append(" ");
				}
			}
		}
	}
}