import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int days = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        int count = 1; 

        for (int i = 1; i<progresses.length; i++){
            int need = 100 - progresses[i];
            if ( days * speeds[i] >= need)
                count ++;
            else {
                list.add(count);
                days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
                count = 1;
            }
        }
        list.add(count);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}