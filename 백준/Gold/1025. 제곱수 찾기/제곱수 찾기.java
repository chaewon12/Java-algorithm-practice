import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int maxNumber = -1;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = input.charAt(j) - '0';
            }
        }

        startFind();

        // 결과 출력
        System.out.println(maxNumber);
    }

    // 가장 큰 완전 제곱수를 찾는 시작점
    static void startFind() {
        // 모든 위치와 방향에 대해 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N; di < N; di++) {
                    for (int dj = -M; dj < M; dj++) {
                        if (di == 0 && dj == 0) {
                            continue;
                        }

                        findPerfectSquare(i, j, di, dj);
                    }
                }
            }
        }
    }

    // 주어진 방향에 따라 탐색하며 완전 제곱수를 찾는 함수
    static void findPerfectSquare(int startX, int startY, int deltaX, int deltaY) {
        int num = 0;

        // 주어진 방향으로 이동하며 정수 문자열 생성
        while (startX >= 0 && startX < N && startY >= 0 && startY < M) {
            num = num * 10 + table[startX][startY];

            if (isPerfectSquare(num)) {
                maxNumber = Math.max(maxNumber, num);
            }

            startX += deltaX;
            startY += deltaY;
        }
    }

    // 주어진 숫자가 완전 제곱수인지 확인하는 함수
    static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
