class Solution {
    boolean solution(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (cur == ')'){
                if (count <= 0){
                    return false;
                }
                count--;
            }
            
            if (cur == '('){
                count++;
            }            
        }
        
        if (count != 0){
            return false;
        }
        return true;
    }
}