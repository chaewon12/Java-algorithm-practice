import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int mod = 10007;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 1;

        System.out.println(fillTile(N));
    }

    // dp[N] = dp[N - 1] + dp[N - 2]
    private static int fillTile(int n) {
        if (dp[n] == null) {
            dp[n] = (fillTile(n - 1) + fillTile(n - 2)) % mod;
        }

        return dp[n];
    }
}