public class Solution70Memoization {
    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairsRecur(0, n, memo);
    }
    public static int climbStairsRecur(int curStep, int finalStep, int[] memo) {
        if (curStep > finalStep) return 0;
        if (curStep == finalStep) return 1;
        if (memo[curStep] > 0) return memo[curStep];
        memo[curStep] = climbStairsRecur(curStep + 1, finalStep, memo) + climbStairsRecur(curStep + 2, finalStep, memo);
        return memo[curStep];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
