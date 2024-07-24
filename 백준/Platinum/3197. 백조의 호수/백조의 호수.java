import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int R, C;
    static int[] swanA, swanB;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> moveQueue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                // 백조 위치 저장 & map에 물로 변경하여 저장
                if (map[i][j] == 'L') {
                    if (swanA == null) {
                        swanA = new int[]{i, j};
                    } else {
                        swanB = new int[]{i, j};
                    }

                    map[i][j] = '.';
                }

                // 물 위치 저장
                if (map[i][j] == '.') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        // 시작 지점 백조A
        visited = new boolean[R][C];
        visited[swanA[0]][swanA[1]] = true;
        moveQueue.add(swanA);

        int days = 0;
        while (!canMeet()) {
            meltIce();
            days++;
        }

        System.out.println(days);
    }
    
    /*
    * 탐색 시간 단축을 위하여 백조의 위치를 갱신 해야한다.
    * 1. 백조A 를 빙판을 만날 때까지 이동시킨다.
    * 2. 빙판 위치를 새로운 큐에 저장해둔다.
    * 3. 이 위치는 다음날 녹아 물이 된다. 즉, 다음 탐색의 시작 위치이다. 
    * 4. 이동 큐를 새로운 큐로 갱신한다 (=백조의 위치를 갱신) 
    * */
    static boolean canMeet() {
        Queue<int[]> nextMoveQueue = new LinkedList<>();

        while (!moveQueue.isEmpty()) {
            int[] location = moveQueue.poll();

            // 백조B 만남
            if (location[0] == swanB[0] && location[1] == swanB[1]) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = location[0] + dx[d];
                int ny = location[1] + dy[d];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] == '.') {
                        moveQueue.add(new int[]{nx, ny});   // 계속 이동
                    } else { 
                        nextMoveQueue.add(new int[]{nx, ny}); // 다음 탐색 위치 저장
                    }
                }
            }
        }

        moveQueue = nextMoveQueue;
        return false;
    }

    static void meltIce() {
        int size = waterQueue.size();

        for (int i = 0; i < size; i++) {
            int[] water = waterQueue.poll(); // 현재 물 위치를 꺼냄

            for (int d = 0; d < 4; d++) {
                int nx = water[0] + dx[d];
                int ny = water[1] + dy[d];

                // 인접한 얼음이 발견되면
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 'X') {
                    map[nx][ny] = '.'; // 얼음을 녹임
                    waterQueue.add(new int[]{nx, ny}); // 새로 물이 된 위치를 추가
                }
            }
        }
    }
}