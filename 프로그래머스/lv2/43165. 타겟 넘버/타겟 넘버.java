class Solution {
    int answer = 0;
    
    public void dfs(int[] numbers,int depth, int target, int sum){
        if(depth==numbers.length){  // 마지막 노드 재귀 탈출
            if(target == sum) answer++;
            return;
        }
        dfs(numbers, depth+1,target, sum+numbers[depth]);
        dfs(numbers, depth+1,target, sum-numbers[depth]);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target,0);
        return answer;
    }
}