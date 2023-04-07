class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        // 등차수열인지 검사
        boolean isArithmetic=common[1]-common[0] == common[2]-common[1];
        
        // 등차수열이면 공차를 더하고 아니면 공비를 곱한다
        answer=isArithmetic ? common[common.length-1]+(common[1]-common[0])
                            : common[common.length-1]*(common[1]/common[0]);

        return answer;
    }
}