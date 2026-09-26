class Solution {
    int[][] dungeons;
    boolean[] visited;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        dfs (k, 0);
        return max;
    }
    
    void dfs (int curK, int count){
        if(max<count) max = count;
        if(curK<=0) return;
        
        for (int i=0; i<dungeons.length; i++){
            if (!visited[i] && curK >= dungeons[i][0]){
                visited[i] = true;
                dfs(curK - dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}