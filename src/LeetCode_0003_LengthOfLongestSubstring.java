import java.util.HashMap;
import java.util.Map;

public class LeetCode_0003_LengthOfLongestSubstring {

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

        class Solution {

            /**
             * 执行用时 : 125 ms, 在所有 Java 提交中击败了 12.20% 的用户
             * 内存消耗 : 49 MB , 在所有 Java 提交中击败了 5.20% 的用户
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
                        MoveResult moveResult = tryMove(s, i+1, maxLen+1);
                        begin = moveResult.start;
                        end = moveResult.end;
                        index = moveResult.index;
                        c = s.charAt(end);
                    }
                    index.put(c, end);

                    if (maxLen < index.size()) {
                        maxLen = index.size();
                System.out.println(s.substring(begin, end + 1));
                    }
                }

                return maxLen;
            }

            class MoveResult {
                Map<Character, Integer> index;
                int start;
                int end;
                MoveResult(Map<Character, Integer> index, int start, int end){
                    this.index = index;
                    this.start = start;
                    this.end = end;
                }
            }

            private MoveResult tryMove(String s, int start, int len) {
                Map<Character, Integer> index = new HashMap<>();
                int last = start+len-1;
                if (last >= s.length()) {
                    return new MoveResult(index, s.length()-1, s.length()-1);
                }
                for (int i=last;i>=start;--i) {
                    char c = s.charAt(i);
                    if (index.containsKey(c)) {
                        return tryMove(s, i+1, len);
                    } else {
                        index.put(c, i);
                    }
                }

                return new MoveResult(index, start, last);
            }

            /**
             *
             * 执行用时 : 97 ms, 在所有 Java 提交中击败了 15.26% 的用户
             * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 5.20% 的用户
             * */
//            public int lengthOfLongestSubstring(String s) {
//                int maxLen = 0;
//                int begin = 0;
//                int end = -1;
//                Map<Character, Integer> index = new HashMap<>();
//                while (++end < s.length()) {
//                    char c = s.charAt(end);
//                    if (index.containsKey(c)) {
//
//                        int i = index.get(c);
//                        end += i - begin + 1;
//                        if (end >= s.length()) {
//                            break;
//                        }
//                        begin = end + 1;
//                        index.clear();
//
//                        while (end - begin < maxLen) {
//                            --begin;
//
//                            char c2 = s.charAt(begin);
//                            if (index.containsKey(c2)) {
//                                end = begin + maxLen + 1;
//                                if (end >= s.length()) {
//                                    break;
//                                }
//                                begin = end + 1;
//                                index.clear();
//                            } else {
//                                index.put(c2, begin);
//                            }
//                        }
//                    } else {
//                        index.put(c, end);
//                    }
//
//                    if (maxLen < index.size()) {
//                        maxLen = index.size();
////                System.out.println(s.substring(begin, end + 1));
//                    }
//                }
//
//                return maxLen;
//            }

            /**
             * 优化后，返回慢了
             *
             * 执行用时 : 97 ms, 在所有 Java 提交中击败了 15.26% 的用户
             * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 5.20% 的用户
             * */
//    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        int begin = 0;
//        int end = -1;
//        Map<Character, Integer> index = new HashMap<>();
//        while (++end < s.length()) {
//            char c = s.charAt(end);
//            if (index.containsKey(c)) {
//
//                int i = index.get(c);
//                index.clear();
//                end += i - begin;
//                begin = end + 1;
//
//                do {
//                    if (end >= s.length()) {
//                        break;
//                    }
//                    --begin;
//
//                    char c2 = s.charAt(begin);
//                    if (index.containsKey(c2)) {
//                        end = begin + maxLen;
//                        begin = end + 1;
//                        index.clear();
//                    } else {
//                        index.put(c2, begin);
//                    }
//                } while (index.size() < maxLen);
//            } else {
//                index.put(c, end);
//                if (maxLen < end - begin + 1) {
//                    maxLen = end - begin + 1;
////                    System.out.println(s.substring(begin, end + 1));
//                }
//            }
//        }
//
//        return maxLen;
//    }


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

        Solution solution = new Solution();

        assert 3 == solution.lengthOfLongestSubstring("abcabcbb");

        assert 1 == solution.lengthOfLongestSubstring("bbbbb");

        assert 3 == solution.lengthOfLongestSubstring("pwwkew");

        assert 5 == solution.lengthOfLongestSubstring("tmmzuxt");

        assert 6 == solution.lengthOfLongestSubstring("ggububgvfk");

        assert 6 == solution.lengthOfLongestSubstring("bbtablud");


        System.out.println(solution.lengthOfLongestSubstring("bbtablud"));


    }




}