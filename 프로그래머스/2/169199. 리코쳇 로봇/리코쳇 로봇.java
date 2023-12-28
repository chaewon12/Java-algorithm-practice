import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char[][] maze;
    int row;
    int column;
    int[] start = new int[2];
    int[] end = new int[2];
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int answer = -1;

    public int solution(String[] board) {
        maze = getCharMaze(board);
        find();
        return answer;
    }

    private char[][] getCharMaze(String[] board) {
        row = board.length;
        column = board[0].length();
        char[][] maze = new char[row][column];

        for (int i = 0; i < row; i++) {
            maze[i] = board[i].toCharArray();

            for (int j = 0; j < column; j++) {
                switch (maze[i][j]) {
                    case 'R':
                        start[0] = i;
                        start[1] = j;
                        break;
                    case 'G':
                        end[0] = i;
                        end[1] = j;
                        break;
                    default:
                        break;
                }
            }
        }

        return maze;
    }

    private void find() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];

        queue.add(new int[]{start[0], start[1], 0}); // 큐에 {x, y, 거리} 저장
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == end[0] && curr[1] == end[1]) {
                answer = curr[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nX = curr[0] + dir[i][0];
                int nY = curr[1] + dir[i][1];

                if (!isWithinBoundaries(nX, nY)) {
                    continue;
                }

                int[] finalPosition = slide(nX, nY, i);

                if (!visited[finalPosition[0]][finalPosition[1]]) {
                    queue.add(new int[]{finalPosition[0], finalPosition[1], curr[2] + 1});
                    visited[finalPosition[0]][finalPosition[1]] = true;
                }
            }
        }
    }

    private boolean isWithinBoundaries(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }

    private int[] slide(int x, int y, int dirIndex) {
        while (isWithinBoundaries(x, y) && maze[x][y] != 'D') {
            x += dir[dirIndex][0];
            y += dir[dirIndex][1];
        }
        return new int[]{x - dir[dirIndex][0], y - dir[dirIndex][1]};
    }
}