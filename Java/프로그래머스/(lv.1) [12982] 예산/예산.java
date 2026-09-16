import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int dd : d){
            if (budget >= dd) {
                count++;
                budget -= dd;
            }
        }
        
        return count;
    }
}

/*
최대 몇 개의 부서에 물품을 지원할 수 있는지
*/