import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 첫 시도 시,재귀를 이용하여 풀려고 함 -> 각 체크포인트에서 두 가지 선택이 있으므로 시간 복잡도는 𝑂(2^𝑁)에 가까워 비효율적
 * 제출 코드:  최적 부분 구조를 이용하여 최적의 해답을 찾는 '그리디 알고리즘' 활용 -> 전체 체크포인트를 순회하면서 한 번의 건너뛰기를 고려하여 O(N) 소요
 * 1. 각 체크포인트를 건너뛰었을 때의 거리를 계산하는 과정 -> 현재 상태(부분 문제)에서 가장 최적의 해 구하기
 * 2. 이전 최소 거리와 각 체크포인트를 건너뛰었을 때의 거리를 비교하는 과정: 문제의 최적 해를 부분 문제의 최적 해로 구성 */
public class Main {
    static int N;
    static int[][] checkPoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        checkPoints = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            checkPoints[i][0] = Integer.parseInt(st.nextToken());
            checkPoints[i][1] = Integer.parseInt(st.nextToken());
        }

        // 전체 거리 계산
        int totalDistance = 0;
        for (int i = 0; i < N - 1; i++) {
            totalDistance += calcDistance(checkPoints[i], checkPoints[i + 1]);
        }

        // 각 체크포인트를 건너뛰었을 때의 최소 거리 계산
        int minDistance = totalDistance;
        for (int i = 1; i < N - 1; i++) {
            // 건너뛴 체크포인트 이전과 이후의 체크포인트를 직접 연결한 거리로 대체
            int distanceWithoutI = totalDistance
                    - calcDistance(checkPoints[i - 1], checkPoints[i])
                    - calcDistance(checkPoints[i], checkPoints[i + 1])
                    + calcDistance(checkPoints[i - 1], checkPoints[i + 1]);

            minDistance = Math.min(minDistance, distanceWithoutI);
        }

        System.out.println(minDistance);
    }

    static int calcDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
