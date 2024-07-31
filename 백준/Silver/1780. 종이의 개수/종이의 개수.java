import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int negativeCount = 0, zeroCount = 0, positiveCount = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(negativeCount).append('\n');
        sb.append(zeroCount).append('\n');
        sb.append(positiveCount);
        System.out.println(sb);
    }

    private static void cutPaper(int startRow, int startCol, int length) {
        if (areAllElementsEqual(startRow, startCol, length)) {
            switch (paper[startRow][startCol]) {
                case -1 -> negativeCount++;
                case 0 -> zeroCount++;
                case 1 -> positiveCount++;
            }

            return;
        }

        int nextLength = length / 3;
        cutPaper(startRow, startCol, nextLength);
        cutPaper(startRow, startCol + nextLength, nextLength);
        cutPaper(startRow, startCol + (nextLength * 2), nextLength);

        cutPaper(startRow + nextLength, startCol, nextLength);
        cutPaper(startRow + nextLength, startCol + nextLength, nextLength);
        cutPaper(startRow + nextLength, startCol + (nextLength * 2), nextLength);

        cutPaper(startRow + (nextLength * 2), startCol, nextLength);
        cutPaper(startRow + (nextLength * 2), startCol + nextLength, nextLength);
        cutPaper(startRow + (nextLength * 2), startCol + (nextLength * 2), nextLength);

    }

    private static boolean areAllElementsEqual(int startRow, int startCol, int length) {
        int firstElement = paper[startRow][startCol];

        for (int i = startRow; i < startRow + length; i++) {
            for (int j = startCol; j < startCol + length; j++) {
                if (paper[i][j] != firstElement) {
                    return false;
                }
            }
        }

        return true;
    }
}