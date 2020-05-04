import java.util.HashMap;
import java.util.Map;

public class LeetCode_0004_LengthOfLongestSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(
                solution.lengthOfLongestSubstring("abcabcbb")
        );

        System.out.println(
                solution.lengthOfLongestSubstring("bbbbb")
        );

        System.out.println(
                solution.lengthOfLongestSubstring("pwwkew")
        );

        //5 提交时报错
        System.out.println(
                solution.lengthOfLongestSubstring("tmmzuxt")
        );
    }



}

class Solution {

    /**
     * 执行用时 : 9 ms, 在所有 Java 提交中击败了 62.40% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 5.20% 的用户
     * */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int begin = 0;
        int end = -1;
        Map<Character, Integer> index = new HashMap<>();
        while (++end < s.length()) {
            char c = s.charAt(end);
            if (index.containsKey(c)) {
                int i = index.get(c);
                for (int j=begin;j<=i;++j) {
                    index.remove(s.charAt(j));
                }
                begin = i + 1;
            } else {
                if (maxLen < end - begin + 1) {
                    maxLen = end - begin + 1;
                    System.out.println(s.substring(begin, end + 1));
                }
            }
            index.put(c, end);
        }

        return maxLen;
    }
}
