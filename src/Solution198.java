import java.util.Arrays;

public class Solution198 {
    private static int[] memo;

    public static int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robFrom(0, nums);
    }

    private static int robFrom(int pos, int[] nums) {
        if (pos >= nums.length) return 0;
        if (memo[pos] > -1) return memo[pos];
        memo[pos] = Math.max(robFrom(pos+1, nums), robFrom(pos+2, nums) + nums[pos]);
        return memo[pos];
    }

    public static void main(String[] args) {
        int[] nums = { 2,7,9,3,1 };
        System.out.println(rob(nums));
    }
}