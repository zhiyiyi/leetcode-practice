import java.util.*;

public class Solution49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            // reset count to 0 every time first
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i + "-");
            }
            String key = sb.toString();
            if (groups.get(key) == null) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(s);
        }
//        List<List<String>> ans = new ArrayList<>();
//        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
//            ans.add(entry.getValue());
//        }
//        return ans;
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
    }
}
