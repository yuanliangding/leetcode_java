public class LeetCode_0004_FindMedianSortedArrays {

    /**
     * 4. 寻找两个有序数组的中位数
     *
     *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     *
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     * */

    public static void main(String[] args) {

        class Solution {

            /**
             *
             * 执行用时 : 97 ms, 在所有 Java 提交中击败了 15.26% 的用户
             * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 5.20% 的用户
             * */
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {

                return 0;
            }

        }

        Solution solution = new Solution();

        assert 2.0 == solution.findMedianSortedArrays(new int[]{1,3},new int[]{2});

        assert 2.5 == solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});

    }


}

