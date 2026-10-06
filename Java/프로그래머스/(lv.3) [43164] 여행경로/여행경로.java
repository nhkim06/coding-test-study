import java.util.*;
class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> answer = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        
        for (String[] t : tickets){
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>())
                 .offer(t[1]);
        }
        
        dfs("ICN");
        
        return answer.toArray(new String[0]);
    }
    
    
    void dfs(String airport){
        
        PriorityQueue<String> nextAirports = graph.get(airport);
        
        while (nextAirports != null && !nextAirports.isEmpty()) {
            String next = nextAirports.poll();
            dfs(next);
        }
        
        answer.addFirst(airport);
    }
}