import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x;
		int y;
		int dist;   // 이동 거리
		boolean destroyed;  // 벽 부셨는지

		public Point(int x, int y, int dist, boolean destroyed) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.destroyed = destroyed;
		}
	}

	static int N;
	static int M;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M][2]; //[x][y][0]=true:이전에 벽을 부수지 않고 도착 [x][y][1]=true:이전에 벽을 부수고 도착

		for (int i = 0; i < N; i++) {
			char[] charArray = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = Character.getNumericValue(charArray[j]);
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();

		queue.offer(new Point(0, 0, 1, false));
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Point point = queue.remove();

			if (point.x == N - 1 && point.y == M - 1) {
				return point.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nX = point.x + dx[i];
				int nY = point.y + dy[i];

				if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
					continue;
				}

				// 이미 벽 부심
				if (point.destroyed) {
					// point.destroyed = true이면 [][][1]로 방문해야함!
					// 갈 수 있고, 방문한 적이 없는지
					if (board[nX][nY] == 0 && !visited[nX][nY][1]) {
						visited[nX][nY][1] = true;
						queue.offer(new Point(nX, nY, point.dist + 1, true));
					}
					continue;
				}

				// 벽이면 부수고 방문
				if (board[nX][nY] == 1) {
					visited[nX][nY][1] = true;
					queue.offer(new Point(nX, nY, point.dist + 1, true));

				} else if (!visited[nX][nY][0]) {  // 벽이 아니고 방문한적이 없으면 방문
					visited[nX][nY][0] = true;
					queue.offer(new Point(nX, nY, point.dist + 1, false));
				}
			}
		}
		return -1;
	}
}
