import java.util.*;
class Solution {
    List<List<Integer>> list;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        
        for (int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for (int[] w : wires){
            list.get(w[0]).add(w[1]);  
            list.get(w[1]).add(w[0]);
        }
        
        for (int[] w : wires){
            visited = new boolean[n+1];
            int count = dfs(w[0], w[1]);
            int diff = Math.abs(count - (n-count));
            
            if (minDiff > diff) minDiff = diff;
            
        }

        return minDiff;
    }
    
    int dfs(int cur, int blocked){
        visited[cur] = true;
        int count = 1;
        
        for (int next : list.get(cur)){
            if ( !visited[next] && next != blocked ){
                count += dfs(next, blocked);
            }   
        }
        
        return count;
    }
    
}