import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, List<Integer>> graph = new HashMap<>(); // <from, List<to>>
		int[] indegree = new int[N + 1];    // 선수 과목 개수
		int[] semester = new int[N + 1];    // 이수 학기

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			indegree[to] += 1;
			List<Integer> temp = graph.getOrDefault(from, new ArrayList<>());
			temp.add(to);
			graph.put(from, temp);
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int now = 1;
		while (!queue.isEmpty()) {
			int qSize = queue.size();

			for (int i = 0; i < qSize; i++) {
				int sub = queue.poll();
				semester[sub] = now;

				if (graph.containsKey(sub)) {
					for (Integer node : graph.get(sub)) {
						indegree[node] -= 1;
						if (indegree[node] == 0) {
							queue.add(node);
						}
					}
				}
			}

			now++;
		}
		System.out.println(Arrays.stream(semester).skip(1).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}