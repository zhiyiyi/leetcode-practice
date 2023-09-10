public class Solution11 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int curArea;
            if (height[left] <= height[right]) {
                // area is limited by the shorter line
                curArea = height[left] * (right - left);
                left++;
            } else {
                curArea = height[right] * (right - left);
                right--;
            }
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 1,8,6,2,5,4,8,3,7 };
        System.out.println(maxArea(height));
    }
}
