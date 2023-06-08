import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int v; // 나가는 정점
	int w; // 들어오는 정점
	int cost;

	public Edge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
}

public class Main {
	static final long INF = Long.MAX_VALUE;
	static int N;
	static int M;
	static List<Edge> graph = new ArrayList<>();
	static final int start=1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.add(new Edge(v, w, cost));
		}

		long[] dist = new long[N + 1];
		if (!bellmanFord(dist)) {
			System.out.println(-1);
			return;
		}

		for(int i=start+1;i<dist.length;i++){
			System.out.println(dist[i] == INF ? -1 : dist[i]);
		}
	}

	public static boolean bellmanFord(long[] dist) {
		Arrays.fill(dist, INF);
		dist[start] = 0;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = graph.get(j);
				if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
					dist[edge.w] = dist[edge.v] + edge.cost;
				}
			}
		}

		// 음수 사이클 존재 하면 false
		for (int i = 0; i < M; i++) {
			Edge edge = graph.get(i);
			if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
				return false;
			}
		}

		return true;
	}
}