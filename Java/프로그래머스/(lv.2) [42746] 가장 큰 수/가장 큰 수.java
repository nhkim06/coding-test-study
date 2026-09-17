import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] strNums = new String[n];
        
        for (int i=0; i<n; i++){
            strNums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNums, (a, b) -> (b+a).compareTo(a+b));
        
        if (strNums[0].equals("0")) return "0";
        
        StringBuilder str = new StringBuilder();
        for (String s : strNums){
            str.append(s);
        }
                
        return str.toString();
    }
}