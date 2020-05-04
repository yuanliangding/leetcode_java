import java.util.HashMap;
import java.util.Map;

public class LeetCode_0004_LengthOfLongestSubstring {

    /**
     * 3. 无重复字符的最长子串
     *
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     *
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert 3 == solution.lengthOfLongestSubstring("abcabcbb");

        assert 1 == solution.lengthOfLongestSubstring("bbbbb");

        assert 3 == solution.lengthOfLongestSubstring("pwwkew");

        assert 5 == solution.lengthOfLongestSubstring("tmmzuxt");

        System.out.println(solution.lengthOfLongestSubstring("ggububgvfk"));

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
                index.clear();
                end += i - begin;
                begin = end + 1;

                do {
                    if (end >= s.length()) {
                        break;
                    }
                    --begin;

                    char c2 = s.charAt(begin);
                    if (index.containsKey(c2)) {
                        end = begin + maxLen;
                        begin = end;
                        index.clear();
                    } else {
                        index.put(c2, begin);
                    }
                } while (index.size() < maxLen);
            } else {
                index.put(c, end);
                if (maxLen < end - begin + 1) {
                    maxLen = end - begin + 1;
//                    System.out.println(s.substring(begin, end + 1));
                }
            }
        }

        return maxLen;
    }


    /**
     * 执行用时 : 9 ms, 在所有 Java 提交中击败了 62.40% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 5.20% 的用户
     * */
//    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        int begin = 0;
//        int end = -1;
//        Map<Character, Integer> index = new HashMap<>();
//        while (++end < s.length()) {
//            char c = s.charAt(end);
//            if (index.containsKey(c)) {
//                int i = index.get(c);
//                for (int j=begin;j<=i;++j) {
//                    index.remove(s.charAt(j));
//                }
//                begin = i + 1;
//            } else {
//                if (maxLen < end - begin + 1) {
//                    maxLen = end - begin + 1;
//                    System.out.println(s.substring(begin, end + 1));
//                }
//            }
//            index.put(c, end);
//        }
//
//        return maxLen;
//    }
}
