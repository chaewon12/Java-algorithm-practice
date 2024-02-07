class Solution {
    public int maxArea(int[] height) {  
        int start = 0;
        int end = height.length - 1;
        int maxResult = calcArea(height, start, end);
                                 
        while(start < end){
            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
            
            maxResult = Math.max(maxResult, calcArea(height, start, end));
        }
       return maxResult;
    }
    
    private int calcArea(int[] heights, int start, int end){
        int width = end - start;
        int height = Math.min(heights[start], heights[end]);
        
        return width * height;
    }
}