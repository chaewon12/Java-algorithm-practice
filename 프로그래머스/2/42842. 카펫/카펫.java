/*
* 1. r * c = brown + yellow = M
* 2. brown = 2 * ( r + c - 2 )  ->  r + c = brown / 2 + 2 = S
* -> 2번 식에서 나올 수 있는 r, c 조합 중 1번 식을 만족하는 r, c를 구한다.
*
* 문제 조건에서 c <= r 이므로 1 <= c <= S/2, r = S - c
* r와 c의 차가 더 작을 수록 그 곱은 커진다는 성질을 이용하여 이분탐색
* r * c > M 이면 c는 더 작아져야 하고(c가 작아져야 차가 더 커지고 곱이 작아지기 때문), 반대로 r * c < M 이면 c는 더 커져야 한다.
* */

class Solution {
    public int[] solution(int brown, int yellow) {
        int M = brown + yellow;
        int S = brown / 2 + 2;

        int column = ( S / 2 ) / 2; // c의 최댓값의 절반.
        int row = S - column;
        int mid = column;

        while( row * column != M ){
            mid = Math.max(1, mid / 2);

            if( row * column > M){
                column -= mid;
                row += mid;
            } else{
                column += mid;
                row -= mid;
            }
        }

        return new int[]{row, column};
    }
}