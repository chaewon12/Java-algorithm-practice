import java.util.*;

class Solution {
    static int N, M;
    static int lumpIdx = 1; // 덩어리 번호 인덱스. 시작은 1번부터
    static Map<Integer, Integer> lumpsInfo = new HashMap<>(); // 각 덩어리의 size 정보
    static int[][] fragmentsInfo; // 각 칸이 몇 번 덩어리에 속하는지 저장
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        fragmentsInfo = new int[N][M];
        visited = new boolean[N][M];

        // 모든 덩어리 탐색
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && land[r][c] == 1) {
                    initFragment(land, r, c);
                }
            }
        }

        // 시추 탐색
        int max = 0;
        for (int c = 0; c < M; c++) {
            max = Math.max(calcOilSize(c), max);
        }

        return max;
    }

    private int calcOilSize(int column) {
        Set<Integer> lumps = new HashSet<>();   // 시추와 만나는 덩어리 set
        int oilSize = 0;

        for (int row = 0; row < N; row++) {
            if (fragmentsInfo[row][column] > 0) {
                lumps.add(fragmentsInfo[row][column]);
            }
        }

        // 덩어리들의 크기 합산
        for (int lump : lumps) {
            oilSize += lumpsInfo.get(lump);
        }

        return oilSize;
    }

    // bfs로 덩어리를 탐색하고 덩어리와 각 칸의 정보 저장.
    static void initFragment(int[][] land, int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        // 시작점
        visited[r][c] = true;
        fragmentsInfo[r][c] = lumpIdx;
        q.add(new int[]{r, c});

        // bfs 시작
        int size = 0; // 덩어리 사이즈
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            size++; // 새로운 칸이 들어올 때마다 사이즈 증가

            for (int d = 0; d < 4; d++) {
                int nR = cur[0] + dist[d][0];
                int nC = cur[1] + dist[d][1];

                // 갈 수 없는 칸
                if (nR < 0 || nR >= N || nC < 0 || nC >= M || visited[nR][nC] || land[nR][nC] == 0) {
                    continue;
                }

                visited[nR][nC] = true;
                fragmentsInfo[nR][nC] = lumpIdx; // 각 칸이 속하는 덩어리 번호 저장
                q.add(new int[]{nR, nC});
            }
        }

        lumpsInfo.put(lumpIdx++, size); // 덩어리 사이즈 저장
    }
}