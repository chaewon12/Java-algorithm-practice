class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            answer[i] = getMinDistanceSquare(m, n, startX, startY, targetX, targetY);
        }

        return answer;
    }

    // 거리 제곱의 최솟값 리턴
    private int getMinDistanceSquare(int m, int n, int startX, int startY, int targetX, int targetY) {
        /*
         * 두 점이 x축 또는 y축으로 평행한 경우 대칭 이동 시 원쿠션이 불가능한 방향이 생김
         * 1. sx == tx이고 sy > ty이면, 아래로 원쿠션 불가능
         * 2. sx == tx이고 sy < ty이면, 위로 원쿠션 불가능
         * 3. sy == ty이고 sx > ty이면, 왼쪽으로 원쿠션 불가능
         * 4. sy == ty이고 sx < ty이면, 오른쪽으로 원쿠션 불가능
         * */
        int currDistance, minDistance = Integer.MAX_VALUE;

        // 상
        if (!(startX == targetX && startY < targetY)) {
            currDistance = getDistanceSquare(startX, startY, targetX, n + (n - targetY));
            minDistance = Math.min(currDistance, minDistance);
        }

        // 하
        if (!(startX == targetX && startY > targetY)) {
            currDistance = getDistanceSquare(startX, startY, targetX, targetY * (-1));
            minDistance = Math.min(currDistance, minDistance);
        }

        // 좌
        if (!(startY == targetY && startX > targetX)) {
            currDistance = getDistanceSquare(startX, startY, targetX * (-1), targetY);
            minDistance = Math.min(currDistance, minDistance);
        }

        // 우
        if (!(startY == targetY && startX < targetX)) {
            currDistance = getDistanceSquare(startX, startY, m + (m - targetX), targetY);
            minDistance = Math.min(currDistance, minDistance);
        }

        return minDistance;
    }

    // 거리의 제곱 계산
    public int getDistanceSquare(int startX, int startY, int targetX, int targetY) {
        return (int) (Math.pow(startX - targetX, 2) + Math.pow(startY - targetY, 2));
    }
}