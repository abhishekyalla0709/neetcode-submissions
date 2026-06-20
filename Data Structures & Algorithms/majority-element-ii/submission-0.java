class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(c1 == 0 && n2!=nums[i] || c1!=0 && n1==nums[i]){
                c1++;
                n1=nums[i];
            }
            else if(c2 == 0 && n1!=nums[i] || c2!=0 && n2==nums[i]){
                c2++;
                n2=nums[i];
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==n1){
                c1++;
            }
            if(nums[i]==n2){
                c2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(c1>nums.length/3){
            ans.add(n1);
        }
        if(c2>nums.length/3){
            ans.add(n2);
        }
        return ans;
    }
}