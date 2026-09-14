import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        /*
        [[0,0,0,0,0],
         [0,0,1,0,3],
         [0,2,5,0,1],
         [4,2,4,4,2],
         [3,5,1,3,1]]
        */
        
        int n = board.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;

        for (int m : moves){
            int locate = m-1;
            for (int i=0; i<n; i++){
                if(board[i][locate] == 0) continue;
                int target = board[i][locate];
                
                if ( !stack.isEmpty() && stack.peek() == target ) {
                    stack.pop();
                    count+=2;
                }
                else stack.push(target);
                
                board[i][locate] = 0;
                break;
            }
        }
        
        return count;
    }
}

/*
문제 해석
- "N x N" 크기의 정사각 격자에 오른쪽 바구니가 있음
- 각 격자 칸에서 가장 위에 있는 인형 집어서 바구니에 넣을 수 있음
- 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라짐
    + 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 큼
    
in  : board(게임 화면의 격자의 상태 2차원 배열), moves(크레인을 작동시킨 위치가 담긴 배열)
out : 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수 

문제 해결
1. 바구니는 stack로 저장.
2. stack 배열을 만들어, 각 stack에 board의 row를 넣고, pop()로 moves 수행. 
    => 코드 간단할 것 같음. 대신 메모리 2배로 차지
3. 인형  : boardTopIdx[board.length]에 각 row마다 top 인덱스 저장하기? 
    => 그냥 board 내 이미 뽑은 인형은 0으로 변환하기

*/