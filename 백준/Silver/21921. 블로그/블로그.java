import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        analyzeVisits(N, X, visits);
    }

    static void analyzeVisits(int N, int X, int[] visits) {
        int maxVisitorSum = 0;
        int currentVisitorSum = 0;
        int frequency = 0;

        // 초기 윈도우의 방문자 합 계산
        for (int i = 0; i < X; i++) {
            currentVisitorSum += visits[i];
        }
        maxVisitorSum = currentVisitorSum;
        frequency = 1;

        // 슬라이딩 윈도우를 사용하여 나머지 방문자 합 계산
        for (int i = X; i < N; i++) {
            currentVisitorSum = currentVisitorSum - visits[i - X] + visits[i];

            if (currentVisitorSum > maxVisitorSum) { // 새로운 최대 방문자수 갱신
                maxVisitorSum = currentVisitorSum;
                frequency = 1;
            } else if (currentVisitorSum == maxVisitorSum) { // 기존 최대 방문자 수와 동일하다면 기간 증가 
                frequency++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (maxVisitorSum == 0) {
            sb.append("SAD");
        } else {
            sb.append(maxVisitorSum).append('\n').append(frequency);
        }
        System.out.println(sb);
    }
}