class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int n = nums.length;
        int val = 0;
        if(n==1){
            return 1;
        }
        //  0 0 1 1 1 2 2 3 3 4

        // int idx;
        // for(int i=0;i<n;i++){
        //     val = nums[i];
        //     idx = i;
        //     while(nums[idx] == val){
        //         idx++;    
        //     }
        //     nums[count++] = val;
        //     i = idx;
        // }
        
        int x = 0;
        for(int i=0;i<n-1;i++){
            if(nums[i] != nums[i+1]){
                nums[count++] = nums[i];
                x=nums[i];
            }
            
            if(i == n-2){
                nums[count++] = nums[i+1];
            }
        }
        
        
        return count;
    }
}