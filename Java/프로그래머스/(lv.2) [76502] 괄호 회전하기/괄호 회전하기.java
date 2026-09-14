import java.util.*;
class Solution {
    String text;
    int n;
    Map<Character, Character> pars = new HashMap<>(); 
    
    public int solution(String s) {
        // [최적화] 홀수 길이는 절대 올바른 괄호가 될 수 없음
        if (n % 2 != 0) return 0;

    
        text = s + s;
        n = s.length();
        pars.put(')', '(');
        pars.put(']', '[');
        pars.put('}', '{');   
        
        int count = 0;
        for (int i=0; i<s.length(); i++){
            if (isParenthesesValid(i)){
                count ++;
            }
        }
        return count;
    }
    
    
    boolean isParenthesesValid(int start){
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i=start; i<start+n; i++){
            char cur = text.charAt(i);
            
            if (pars.containsKey(cur)){   // 닫는 괄호이면
                if (stack.size() <= 0) return false;
                if (stack.pop() != pars.get(cur)) return false;
            }
            else {
                stack.push(cur);
            }
            
        }
        
        return stack.isEmpty();
    }
}