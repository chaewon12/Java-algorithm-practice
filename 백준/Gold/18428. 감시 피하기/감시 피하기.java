import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[][] map;
    static List<int[]> teachers;
    static List<int[]> empties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 입력
        map = new String[N][N];
        teachers = new ArrayList<>();
        empties = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 선생님 및 빈칸 위치 저장 
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();

                if (map[i][j].equals("T")) {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j].equals("X")) {
                    empties.add(new int[]{i, j});
                }
            }
        }

        if (isPossible(0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean isPossible(int index, int count) {
        if (count == 3) {
            // 장애물 설치 완료, 감시 시뮬레이션
            return simulate();
        }

        // 빈 칸에 장애물 설치하기
        for (int i = index; i < empties.size(); i++) {
            int[] position = empties.get(i);
            int x = position[0];
            int y = position[1];

            map[x][y] = "O"; // 장애물 설치
            if (isPossible(i + 1, count + 1)) {
                return true;    // 감시 피하기 성공
            }
            map[x][y] = "X"; // 장애물 제거 (백트래킹)
        }

        return false;    // 모든 경우를 돌아도 simulate()에서 true가 안뜨면 실패 
    }

    static boolean simulate() {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        for (int[] teacher : teachers) {
            int tx = teacher[0];
            int ty = teacher[1];

            for (int d = 0; d < 4; d++) {
                int nx = tx;
                int ny = ty;
                while (true) {
                    nx += dx[d];    // 장애물 또는 끝에 도달하기 전까지 계속 이동 
                    ny += dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        break; // 범위를 벗어나면 해당 방향 탐색 종료
                    }
                    if (map[nx][ny].equals("O")) {
                        break;  // 장애물을 만나면 해당 방향 탐색 종료
                    }
                    if (map[nx][ny].equals("S")) {
                        return false; // 학생을 발견하면 실패
                    }
                }
            }
        }

        return true; // 모든 선생님의 감시를 피했을 경우 성공
    }
}