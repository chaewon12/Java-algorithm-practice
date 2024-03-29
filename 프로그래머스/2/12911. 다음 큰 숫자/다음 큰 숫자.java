class Solution {
    public static int solution(int n) {
        int count = Integer.bitCount(n);

        return findNextBiggerNumber(count, n);
    }

    private static int findNextBiggerNumber(int count, int n) {
        while (true) {
            n++;
            if (Integer.bitCount(n) == count) {
                return n;
            }
        }
    }
}