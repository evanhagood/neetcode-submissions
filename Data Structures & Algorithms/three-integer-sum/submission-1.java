class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // O(nlogn)

        for(int i = 0; i < nums.length; i++) {
            // check: if nums[i] is above 0, we cannot possibly sum to 0.
            if(nums[i] > 0) {
                break;
            }
            // if we've seen a value before, we do not need to recompute it
            // except for the first one. cause then nums[-1] is OOB
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        // if we've already seen the next left value
                        // we don't need to compute it. and even if we do,
                        // the answer will be wrong, cause it'll find dupes.
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
