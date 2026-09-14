import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {        
        Integer[] sorted = Arrays.stream(priorities)
                                .boxed()
                                .toArray(Integer[]::new);
        
        Arrays.sort(sorted, Collections.reverseOrder());
        
        int sortedIdx = 0;
        int count = 0;
        
        while (true){
            for(int i=0; i<priorities.length; i++){
                if (priorities[i] == sorted[sortedIdx]){
                    sortedIdx++;
                    count++;
                    if (i == location) return count;
                }
                
            }
            
        }
    }
}

/*
문제 해결 :
    1. 내림차순 sort 후 해당 값 만나면 해당 위치 반환 -> 같은 priority인 값 경우 순서 꼬일 수 있음
    2. 그렇다면 같은 priority인 값은 어떻게 추적할 것이냐
        => 일단 sort한 array하나 두고, 포인터로 하나씩 이동시키며 최대값 트래킹
           + queue 안의 값 poll해서 최대값인지 비교 (해당되는 값이면 그대로 poll, 아니면 다시 offer)
           인덱스 값을 queue에 넣기?

*/