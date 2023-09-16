public class Solution70Recursion {
    public static int climbStairs(int n) {
        return climbStairsRecur(0, n);
    }
    public static int climbStairsRecur(int curStep, int finalStep) {
        if (curStep > finalStep) return 0;
        if (curStep == finalStep) return 1;
        return climbStairsRecur(curStep + 1, finalStep) + climbStairsRecur(curStep + 2, finalStep);

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
