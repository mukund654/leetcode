class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
int key = -1;
for(int i =n-2;i>=0;i--){
    if(nums[i]<nums[i+1]){
        key = i;
        break;
    }
}
if(key==-1){
    for(int i =0;i<n/2;i++){
        int temp = nums[i];
        nums[i] = nums[n-1-i];
        nums[n-i-1] = temp;            
    }
}
else{
     for(int i = key+1;i<n;i++){
        if(nums[i]<=nums[key]){
            int temp = nums[i-1];
            nums[i-1] = nums[key];
            nums[key] = temp;
            break;
        }
        if(i==n-1){
            int temp = nums[n-1];
            nums[n-1] = nums[key];
            nums[key] = temp;
            break;
        }
    }
    int j =0;
    for(int i =key+1;i<=(n-key-1)/2+key;i++){
        int temp = nums[i];
        nums[i] = nums[n-1-j];
        nums[n-1-j] = temp;
        j++;
    }
}

    }
}