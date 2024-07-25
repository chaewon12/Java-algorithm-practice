import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수
        int[] streetLamps = new int[M]; // 가로등 위치

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int point = Integer.parseInt(st.nextToken());
            streetLamps[i] = point;
        }

        System.out.println(calcMinHeight(N, streetLamps));
    }

    private static int calcMinHeight(int N, int[] streetLamps) {
        int minHeight = 0;
        boolean flag; // 굴다리 모두를 비출 수 있는지

        int low = 1; // 최소 높이
        int high = N; // 최대 높이 = 굴다리 길이
        while (low <= high) {
            flag = true; // 플래그 초기화

            int mid = (low + high) / 2; // 이분 탐색

            // mid 높이로 가능한 지 가로등 체크
            int point = 0; // 이전에 가로등이 비추었던 위치
            for (int streetLamp : streetLamps) {
                if (streetLamp - mid <= point) { // 좌측 최대로 비출 수 있는 곳이 이전 위치보다 같거나 작으면 빠진 곳 없이 연속적으로 비췄다는 의미
                    point = streetLamp + mid; // 가로등이 우측 최대로 비출 수 있는 곳 저장
                } else {
                    flag = false;
                }
            }

            // 마지막 가로등의 오른쪽 검사
            if (point < N) flag = false;

            if (flag) { // 모두를 비출 수 있음
                minHeight = mid; // 최소 높이 갱신
                high = mid - 1; 
            } else { // 모두 비출 수 없음
                low = mid + 1; 
            }
        }

        return minHeight;
    }
}
