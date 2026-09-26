import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = maps[0].length;
        int m = maps.length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            for (int i=0; i<4; i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if(nx >= 0 && nx < n && ny >=0 && ny < m && maps[ny][nx] == 1 ){
                    if (maps[ny][nx] > 1) continue;
                    maps[ny][nx] = maps[pos[1]][pos[0]] +1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        int answer = maps[m-1][n-1];
        return answer == 1? -1 : answer;
    }
}