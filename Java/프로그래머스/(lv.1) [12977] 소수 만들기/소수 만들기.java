class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i<nums.length-2; i++){
            for (int j=i+1; j<nums.length -1; j++){
                for (int k=j+1; k<nums.length; k++){
                    boolean prime = isPrime(nums[i]+nums[j]+nums[k]);
                    if (prime) {
                        System.out.println(prime);
                        count++;
                    }
                }
            }
        }

        return count;
    }
    
    
    boolean isPrime(int n){
        if ( n<2 ) return false;
        if ( n==2 )  return true;
        if ( n%2==0 ) return false;
        
        for (int i=3; i*i<=n; i+=2){
            if ( n%i==0 ) return false;
        }
        
        return true;
    }
}