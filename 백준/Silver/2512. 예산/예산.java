import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int totalBudget;
    static int[] budgetRequests;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        budgetRequests = new int[N];
        int requestSum = 0;
        int maxRequest = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(st.nextToken());
            budgetRequests[i] = request;
            requestSum += request;
            maxRequest = Math.max(maxRequest, request);
        }

        totalBudget = Integer.parseInt(br.readLine());

        if (requestSum <= totalBudget) { // 모든 요청이 배정될 수 있는 경우
            System.out.println(maxRequest);
        } else {  // 0부터 요청한 예산 중 최대값을 범위로 하여 상한액 이분탐색
            System.out.println(findOptimalLimit(0, maxRequest));
        }
    }

    static int findOptimalLimit(int left, int right) {
        int optimalLimit = 0;

        while (left <= right) {
            int limit = (left + right) / 2;
            int allocatedBudget = calculateAllocatedBudget(limit);

            if (allocatedBudget > totalBudget) {    // 총 예산을 넘는 경우 right의 범위를 줄인다
                right = limit - 1;
            } else { // 같거나 작은 경우 해당 금액으로 상한액을 갱신한다.
                left = limit + 1;
                optimalLimit = limit;
            }
        }

        return optimalLimit;
    }

    static int calculateAllocatedBudget(int limit) {
        int sum = 0;

        for (int budget : budgetRequests) {
            sum += Math.min(budget, limit);
        }

        return sum;
    }
}