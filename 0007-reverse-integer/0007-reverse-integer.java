class Solution {
    public int reverse(int x) {
        int sign = x>0? 1:-1;
        if(x==0){
            return 0;
        }
        while(x%10==0){
            x/=10;
        }
        x = x*sign;
        long ans = 0;
        while(x>0){
           ans = ans*10+ x%10;
            x/=10;
        }

        ans*=sign;
        if(ans>Integer.MAX_VALUE){
            return 0;
        }
        else if(ans<Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;

    }
}