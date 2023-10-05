import java.util.Arrays;

public class Solution213 {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];

        // select the first house (can't select the last house)
        robRange(0, nums.length - 2, nums, dp);
        int selectTheFirstHouse = dp[0];

        Arrays.fill(dp, 0);
        // select the last house (can't select the first house)
        robRange(1, nums.length - 1, nums, dp);
        int selectTheLastHouse = dp[0];
        return Math.max(selectTheFirstHouse, selectTheLastHouse);
    }

    private static void robRange(int first, int last, int[] nums, int[] dp) {
        for (int i = last; i >= first; i--) {
            int skipThisHouse = dp[i+1];
            int notSkipThisHouse = dp[i+2] + nums[i];
            dp[i] = Math.max(skipThisHouse, notSkipThisHouse);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,3,1 };
        System.out.println(rob(nums));
    }
}
