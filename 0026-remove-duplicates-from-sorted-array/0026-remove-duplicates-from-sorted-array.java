class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        
        int newIdx = 0;        
        if(len==1) {
            return 1;
        }
        for(int i=0;i<len-1;i++){
            if(nums[i] != nums[i+1]){
                nums[newIdx++] = nums[i];
            }
            if(i == len-2){
                nums[newIdx++] = nums[i+1];
            }
        }
        return newIdx;
    }
}