import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        for (int s : scoville){
            pq.add(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            
            int a = pq.poll();
            int b = pq.poll();
            int scov = a+b*2;
            
            pq.add(scov);
            
            count ++;
            
        } 
        return count;
    }
}

/*
문제 해결
- 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)


*/