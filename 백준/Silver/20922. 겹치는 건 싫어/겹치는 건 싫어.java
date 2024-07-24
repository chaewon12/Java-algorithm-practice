import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getSequenceLength(numbers));
    }

    static int getSequenceLength(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < N; end++) {
            int frequency = frequencyMap.getOrDefault(numbers[end], 0);
            frequencyMap.put(numbers[end], frequency + 1);

            // K개 이하가 될 때까지 start 이동 하며 수열 범위 줄이기
            while (frequencyMap.get(numbers[end]) > K) {
                frequencyMap.put(numbers[start], frequencyMap.get(numbers[start]) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
