import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int[][] matrix;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(matrix[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			for (int i = 0; i < 4; i++) {
				int nX = currX + dx[i];
				int nY = currY + dy[i];

				if (nX < 0 || nX >= N || nY < 0 || nY >= M ||
					matrix[nX][nY] == 0 || visited[nX][nY]) {
					continue;
				}
				visited[nX][nY] = true;    // 방문 처리
				matrix[nX][nY] = matrix[currX][currY] + 1;    // 시작점과의 거리 = 이전 지점 + 가중치(1칸 이동) 
				q.offer(new int[] {nX, nY});
			}
		}
	}
}