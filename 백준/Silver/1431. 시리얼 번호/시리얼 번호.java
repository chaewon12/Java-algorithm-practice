import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static class SerialNumber {
        public final int length;
        public final int numberSum;
        public final String serial;

        public SerialNumber(String serial) {
            this.serial = serial;
            this.length = serial.length();
            this.numberSum = calDigitSum(serial);
        }

        private int calDigitSum(String str) {
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (Character.isDigit(c)) {
                    sum += c - '0';
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Comparator comarator = (Comparator<SerialNumber>) (s1, s2) -> {
            if (s1.length > s2.length) {   
                return 1;
            } else if (s1.length < s2.length) {
                return -1;
            } else {
                if (s1.numberSum > s2.numberSum) { 
                    return 1;
                } else if (s1.numberSum < s2.numberSum) {
                    return -1;
                } else {
                    return s1.serial.compareTo(s2.serial);
                }
            }
        };

        Queue<SerialNumber> serialNumbers = new PriorityQueue<>(comarator);

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            serialNumbers.add(new SerialNumber(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        while (!serialNumbers.isEmpty()) {
            sb.append(serialNumbers.remove().serial);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}