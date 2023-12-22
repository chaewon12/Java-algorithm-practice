import java.util.*;

class Solution {
    char[][] maze;
    int[] start = new int[2];
    int[] end = new int[2];
    int[] lever = new int[2];
    int[][] dist = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int answer = 0;
    
    public int solution(String[] maps) {        
        maze = getCharMaze(maps);
        
        if(!findLever()){
            return -1;
        }

        if(!findEnd()){
            return -1;
        }
        
        return answer;
    }
    
    private char[][] getCharMaze(String[] maps){
        char[][] maze = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            maze[i] = maps[i].toCharArray();
            for (int j = 0; j < maze[i].length; j++) {
                switch(maze[i][j]){
                    case 'S':
                        start[0] = i;
                        start[1] = j;
                        break;
                    case 'E':
                        end[0] = i;
                        end[1] = j;
                        break;
                    case 'L':
                        lever[0] = i;
                        lever[1] = j;
                        break;
                    default:
                        break;
                }
            }
        }
        return maze;
    } 
    
    private boolean findLever(){
        boolean isFind = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        queue.add(new int[]{start[0], start[1], 0}); // 큐에 {x, y, 거리} 저장 
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(curr[0] == lever[0] && curr[1] == lever[1]){
                answer += curr[2];
                isFind = true;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nX = curr[0] + dist[i][0];
                int nY = curr[1] + dist[i][1];
                
                // 접근 불가능한 인덱스 필터링 
                if(nX < 0 || nY < 0 || nX >= maze.length || nY >= maze[0].length){
                    continue;
                }
                
                if(maze[nX][nY] != 'X' && !visited[nX][nY]){
                    visited[nX][nY] = true;
                    queue.add(new int[]{nX, nY, curr[2]+1});
                }
            }  
        }
        return isFind;
    }
    
    private boolean findEnd(){
        boolean isFind = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        queue.add(new int[]{lever[0], lever[1], 0}); // 큐에 {x, y, 거리} 저장 
        visited[lever[0]][lever[1]] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(curr[0] == end[0] && curr[1] == end[1]){
                answer += curr[2];
                isFind = true;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nX = curr[0] + dist[i][0];
                int nY = curr[1] + dist[i][1];
                
                // 접근 불가능한 인덱스 필터링 
                if(nX < 0 || nY < 0 || nX >= maze.length || nY >= maze[0].length){
                    continue;
                }
                
                if(maze[nX][nY] != 'X' && !visited[nX][nY]){
                    visited[nX][nY] = true;
                    queue.add(new int[]{nX, nY, curr[2]+1});
                }
            }  
        }
        return isFind;
    }
}