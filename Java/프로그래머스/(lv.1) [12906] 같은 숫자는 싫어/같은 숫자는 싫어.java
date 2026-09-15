import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(arr[0]);
        
        for (int i=1; i<arr.length; i++){
            int top = queue.peekLast();
            if (arr[i] != top) queue.offer(arr[i]);
        }
        
        return queue.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
/*
문제 해결
- stack 에 넣고 하나씩 peek해서 같은 값이면 스킵, 다르면 stack에 넣기
*/