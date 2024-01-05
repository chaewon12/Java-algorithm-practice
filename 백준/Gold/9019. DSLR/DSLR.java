import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Register {
        int value;
        String command;

        public Register(int value, String command) {
            this.value = value;
            this.command = command;
        }
    }

    static String[] commandArray = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commandList = calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(commandList).append('\n');
        }

        System.out.println(sb);
    }

    private static int executeCommand(String command, int n) {
        return switch (command) {
            case "D" -> (2 * n) % 10000;
            case "S" -> n != 0 ? (n - 1) % 10000 : 9999;
            case "L" -> (n % 1000) * 10 + n / 1000;
            case "R" -> (n % 10) * 1000 + n / 10;
            default -> 0;
        };
    }

    // BFS
    private static String calc(int start, int target) {
        Queue<Register> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new Register(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Register curr = queue.remove();

            for (String command : commandArray) {
                int result = executeCommand(command, curr.value);

                if (result == target) {
                    return curr.command + command;
                }

                if (!visited[result]) {
                    visited[result] = true;
                    queue.add(new Register(result, curr.command + command));
                }
            }
        }

        return "";
    }
}
