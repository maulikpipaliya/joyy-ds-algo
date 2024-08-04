class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<len;i++){
            map.put(nums[i], i);   
        }
    
        
        for(int i=0;i<len;i++){
            Integer x = target - nums[i];
            Integer indexOfX = map.get(x);
            if(indexOfX != null && indexOfX != i){
                return new int[]{i, indexOfX};
            }
        }
        
        return new int[]{};
    }
}