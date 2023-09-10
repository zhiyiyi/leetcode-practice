import java.util.*;

public class Solution15HashSet {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(nums, i, results);
        }
        return results;
    }

    public static void twoSum(int[] nums, int index, List<List<Integer>> results) {
        Set<Integer> seen = new HashSet<>();
        for (int j = index + 1; j < nums.length; j++) {
            int complement = - (nums[index] + nums[j]);
            if (seen.contains(complement)) {
                // only increment after find a triple
                // for this case [-2, 1, 1]
                results.add(Arrays.asList(nums[index], nums[j], complement));
                // stop at the j that it still the same as above j, but j + 1 is different
                // so we won't miss seen.add(nums[j]) as well
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
            }
            seen.add(nums[j]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
