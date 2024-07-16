import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
     * 배낭 문제(냅색 알고리즘)는 크게 두 가지 문제로 분류 된다.
     * 1. 짐을 쪼갤 수 있는 경우 Fraction Knapsack Problem -> 탐욕 알고리즘(Greedy)으로 해결
     * 2. 짐을 쪼갤 수 없는 경우 0/1 Knapsack Problem -> 동적 계획법(Dynamic Programming)을 사용하여 해결
     *
     * dp[i][w]는 첫 번째 물건부터 i번째 물건까지 고려했을 때, 최대 무게 w인 배낭에 넣을 수 있는 최대 가치를 의미한다.
     * 점화식 구성
     * 물건을 넣지 않는 경우: dp[i][w] = dp[i-1][w]
     * 물건을 넣는 경우: dp[i][w] = max(dp[i-1][w], dp[i-1][w - W[i]] + V[i])
     * -> dp[i-1][w - W[i]] + V[i]: i번째 물건을 배낭에 넣는 경우의 가치는 i-1번째 물건까지 고려했을 때 최대 무게 (w - W[i])에서의 최대 가치에 i번째 물건의 가치를 더하여 계산함
     *
     * Top-Down(재귀) 방식과 Bottom-Up 방식으로 풀어낼 수 있는데,
     * Bottom-Up 방식의 특성상 작은 것부터 맞추기 때문에 dp 배열을 2차원이 아니라 1차원으로 생성 하고 중복 탐색을 피해 가는 방식으로 바꿀 수 있다.
     * 1부터 K까지 탐색하는 것이 아니라 K-W[i] 에 대하여 0보다 크거나 같을 때 까지만 탐색함으로 불필요한 탐색을 줄일 수 있고, 중복 카운트 또한 피할 수 있다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // DP 진행
        for (int i = 1; i <= N; i++) {

            // 배낭의 무게 제한을 고려하여 최대 무게 K부터 현재 물건의 무게까지 역순으로 탐색
            for (int j = K; j - W[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }

        System.out.println(dp[K]);
    }
}