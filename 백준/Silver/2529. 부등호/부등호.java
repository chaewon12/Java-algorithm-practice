import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] signs;
    static boolean[] visit = new boolean[10]; // 0~9 숫자
    static List<String> resultStr = new ArrayList<>(); // 조건을 만족하는 K+1자리 정수 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        signs = br.readLine().split(" ");

        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            backTraking(Integer.toString(i), i, 0);
            visit[i] = false;
        }

        resultStr.sort(Collections.reverseOrder());
        System.out.println(resultStr.get(0));
        System.out.println(resultStr.get(resultStr.size() - 1));
    }

    static boolean validateSign(String sign, int left, int right) {
        return switch (sign) {
            case ">" -> left > right;
            case "<" -> left < right;
            default -> false;
        };
    }

    // integerStr: 이전까지 방문한 정수 문자열, left: 직전 정수. 부등호의 왼쪽, idx: 부등호 참조 인덱스 
    static void backTraking(String integerStr, int left, int idx) {
        if (integerStr.length() == K + 1) {
            resultStr.add(integerStr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i] && validateSign(signs[idx], left, i)) {
                visit[i] = true;
                backTraking(integerStr + i, i, idx + 1);
                visit[i] = false;
            }
        }
    }
}