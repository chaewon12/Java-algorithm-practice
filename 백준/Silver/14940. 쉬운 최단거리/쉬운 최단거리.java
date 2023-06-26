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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static Point target;
    static int[][] map;
    static boolean[][] visited;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if (temp == 2) {
                    target = new Point(i, j);
                    map[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append((!visited[i][j] && map[i][j] == 1) ? -1 : map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(target);

        while (!queue.isEmpty()) {
            Point curr = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nX = curr.x + dX[i];
                int nY = curr.y + dY[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M && !visited[nX][nY] && map[nX][nY] == 1) {
                    map[nX][nY] = map[curr.x][curr.y] + 1;
                    visited[nX][nY] = true;
                    queue.add(new Point(nX, nY));
                }
            }
        }
    }
}