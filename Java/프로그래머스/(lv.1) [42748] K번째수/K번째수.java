import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            int[] cur = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cur);
            answer[i] = cur[commands[i][2]-1];
        }
        
        return answer;
    }
}

/*
문재 해결
- 인덱스는 1부터 시작을 기준으로. j번째 인덱스까지 포함
- 단계
    1. 값 자르기
    2. sort하기
    3. k번째 수 찾기


*/