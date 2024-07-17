import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * dp[i][j]: i번 부터 j번 까지 페이지를 합한 최소 비용
 * sum[i]: i번 까지의 비용 합
 *
 * A1, A2, A3가 존재하면, 챕터를 합칠 수 있는 경우의 수는
 * 1. (A1, A2), A3 : A1과 A2를 먼저 합친 후 A3와 합치기 -> DP[1][2] + DP[3][3] + sum[3] - sum[0]   // (A1, A2)와 A3 각 최소 비용 + 1~3까지의 비용 합
 * 2. A1, (A2, A3) : A2와 A3를 먼저 합친 후 A1과 합치기 -> DP[1][1] + DP[2][3] + sum[3] - sum[0]
 *
 * 점화식을 세우면 dp[i][j]=min(dp[i][s]+dp[s+1][j]+sum[j]−sum[i−1]) 여기서 (i <= s < j)
 *  */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] sum = new int[K + 1];
            for (int i = 1; i <= K; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            sb.append(mergeFiles(K, sum)).append('\n');
        }

        System.out.println(sb);
    }

    public static int mergeFiles(int k, int[] sum) {
        int[][] dp = new int[k + 1][k + 1];

        for (int mergeSize = 2; mergeSize <= k; mergeSize++) {  // 합칠 파일의 개수
            for (int i = 1; i <= k - mergeSize + 1; i++) {
                int j = i + mergeSize - 1;

                dp[i][j] = Integer.MAX_VALUE;
                for (int s = i; s < j; s++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][s] + dp[s + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }

        return dp[1][k];
    }
}