import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Long> numbers = new ArrayList<>();
    static Set<Long> visited = new HashSet<>();
    static List<Long> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            numbers.add(Long.parseLong(st.nextToken()));
        }

        for (long num : numbers) {
            results = new ArrayList<>();
            visited.clear();

            if (calculate(num)) {
                StringBuilder sb = new StringBuilder();
                for (long result : results) {
                    sb.append(result).append(' ');
                }
                System.out.println(sb);
            }
        }
    }

    static boolean calculate(long num) {
        results.add(num);
        visited.add(num);

        if (results.size() == N) {
            return true;
        }

        if (num % 3 == 0 && numbers.contains(num / 3) && !visited.contains(num / 3)) {
            if (calculate(num / 3)) {
                return true;
            }
        }

        if (numbers.contains(num * 2) && !visited.contains(num * 2)) {
            if (calculate(num * 2)) {
                return true;
            }
        }

        return false;
    }
}
