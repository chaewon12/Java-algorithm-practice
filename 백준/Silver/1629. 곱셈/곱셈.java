import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(modularExponentiation(A, B, C));
    }

    /*
     * 거듭제곱을 계산할 때, 모든 곱셈을 차례대로 수행하지 않고 적절히 쪼개서 계산.
     * 이를 위해 지수 B를 이진수로 표현하여 각 비트가 1일 때만 곱셈을 수행.
     * 예를 들어, 𝐵 = 13일때 이진수로 표현하면 1101 이다.
     * 즉, A^13 = A^8 * A^4 * A^0 이다.
     * 따라서 B의 이진수 표현에서 각 비트가 1일 때만 곱셈을 수행하면 된다.
     * */
    static long modularExponentiation(int A, int B, int C) {
        long result = 1;
        long base = A % C;

        while (B > 0) {
            if (B % 2 == 1) {   // 현재 비트가 1일 때
                result = (result * base) % C;
            }

            base = (base * base) % C;
            B /= 2;
        }

        return result;
    }
}