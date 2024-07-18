import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] pointMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        pointMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                pointMap[i][j] = line.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        makeQuadTree(0, 0, N, sb);
        System.out.println(sb);
    }

    static void makeQuadTree(int startRow, int startCol, int length, StringBuilder sb) {
        if (areAllElementsEqual(startRow, startCol, length)) {
            sb.append(pointMap[startRow][startCol]);
            return;
        }

        sb.append("(");
        int halfLength = length / 2;
        makeQuadTree(startRow, startCol, halfLength, sb);
        makeQuadTree(startRow, startCol + halfLength, halfLength, sb);
        makeQuadTree(startRow + halfLength, startCol, halfLength, sb);
        makeQuadTree(startRow + halfLength, startCol + halfLength, halfLength, sb);
        sb.append(")");

    }

    public static boolean areAllElementsEqual(int startRow, int startCol, int length) {
        int firstElement = pointMap[startRow][startCol];

        for (int i = startRow; i < startRow + length; i++) {
            for (int j = startCol; j < startCol + length; j++) {
                if (pointMap[i][j] != firstElement) {
                    return false;
                }
            }
        }

        return true;
    }
}