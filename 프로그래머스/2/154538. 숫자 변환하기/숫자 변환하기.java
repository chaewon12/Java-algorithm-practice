import java.util.*;

class Solution{
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        dp[x] = 0;

        for (int i = x; i < y + 1; i++) {
            if (dp[i] == -1) {
                continue;
            }

            // 현재 인덱스 i에서 +n, *2, *3 한 인덱스에 dp[i]+1과 dp[변환할 수 있는 값] 중 최솟값으로 업데이트
            if (i + n <= y) {
                dp[i + n] = (dp[i + n] == -1) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
            if (i * 2 <= y) {
                dp[i * 2] = (dp[i * 2] == -1) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= y) {
                dp[i * 3] = (dp[i * 3] == -1) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
            
        }

        return dp[y];
    }
}