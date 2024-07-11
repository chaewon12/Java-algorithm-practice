import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] table = br.readLine().split("");

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i].equals("P")) {
                int left = Math.max(i - K, 0);
                int right = Math.min(i + K, N - 1);

                if (eatBerger(left, right, i, table)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static boolean eatBerger(int left, int right, int index, String[] table) {
        // 왼쪽 범위 햄버거 탐색
        for (int i = left; i < index; i++) {
            if (table[i].equals("H")) {
                table[i] = "X"; // 먹은 햄버거 표시
                return true;
            }
        }

        // 오른쪽 범위 햄버거 탐색
        for (int i = index + 1; i <= right; i++) {
            if (table[i].equals("H")) {
                table[i] = "X";
                return true;
            }
        }

        // 양쪽 모두 먹을게 없으면 false 리턴
        return false;
    }
}