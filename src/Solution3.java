import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int winStart = 0, winEnd = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (winEnd < s.length()) {
            if (map.containsKey(s.charAt(winEnd))) {
                winStart = Math.max(map.get(s.charAt(winEnd)) + 1, winStart);
                System.out.println(winStart);
            }
            longest = Math.max(longest, winEnd - winStart + 1);
            map.put(s.charAt(winEnd), winEnd);
            winEnd++;
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
