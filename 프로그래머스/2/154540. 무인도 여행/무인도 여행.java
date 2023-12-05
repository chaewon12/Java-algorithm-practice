import java.util.*;

class Solution {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int mapX;
    static int mapY;
    static int[][] islandMap;
    static int day; // 머물 수 있는 날짜 
    static boolean[][] visited;
    
    
    public int[] solution(String[] maps) {
        List<Integer> days = new ArrayList<>();
        
        mapX = maps[0].length();
        mapY = maps.length;
        
        // 지도 생성 
        islandMap = new int[mapY][mapX];
        visited = new boolean[mapY][mapX];
        for(int i=0; i< mapY; i++){
            String[] mapStr = maps[i].split("");
            for(int j=0; j< mapX; j++){
                islandMap[i][j] = mapStr[j].equals("X") ? 0 : Integer.parseInt(mapStr[j]);
            }
        }

        // 탐색
        for(int i=0; i< mapY; i++){
            for(int j=0; j< mapX; j++){
                if(islandMap[i][j] != 0 && !visited[i][j]){
                    day = islandMap[i][j];
                    dfs(i,j);
                    days.add(day);
                }
            }
        }
            
        
        if(days.isEmpty()){
            return new int[]{-1};
        }
        
        return days.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    private static void dfs(int y, int x){
		visited[y][x] = true;

		for(int i = 0; i < dir.length; i++){
			int nX = x + dir[i][0];
			int nY = y + dir[i][1];

			if(nX >= 0 && nY >= 0 && nX < mapX && nY < mapY 	// 지도 상에 존재할 수 있는 좌표인지
				&& islandMap[nY][nX] != 0 && !visited[nY][nX]){ // 식량이 있고 방문 전 인지
				day += islandMap[nY][nX];
				dfs(nY,nX);
			}
		}
	}
}