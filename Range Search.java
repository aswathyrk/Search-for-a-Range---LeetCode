public class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res=new int[2];
        res[0]=res[1]=-1;
        
        int l=0;int r=nums.length-1;
        int mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(target<nums[mid]){
                r=mid-1;
            }
            else if(target>nums[mid]){
                l=mid+1;
            }
            else{
                res[0]=res[1]=mid;//if there are no duplicates
                
                //checking duplicates on either side of mid
                //on left
                int start=mid;
                while(start>l && nums[start]==nums[start-1]){
                    start--;
                    res[0]=start;
                }
                
                //on right
                int end=mid;
                while(end<r && nums[end]==nums[end+1]){
                    end++;
                    res[1]=end;
                }
                return res;
            }
        }
        return res;
    }
}