```
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same.
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]


```

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        
        int insertIndex =1;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i-1] != nums[i]){
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}
```
