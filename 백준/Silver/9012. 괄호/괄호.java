import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        outLoop:
        while (count > 0) {
            stack.clear();
            count--;

            String line = br.readLine();

            // 시작이나 끝이 올바르지 않음
            if (line.charAt(0) == ')' || line.charAt(line.length() - 1) == '(') {
                System.out.println("NO");
                continue;
            }

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(') {
                    stack.push(1);
                } else {
                    if (stack.isEmpty()) {    // 짝이 없음
                        System.out.println("NO");
                        continue outLoop;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
