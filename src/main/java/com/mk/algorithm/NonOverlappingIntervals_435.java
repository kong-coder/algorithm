package com.mk.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * <p>注意:
 *
 * <p>可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 示例 1:
 *
 * <p>输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * <p>输出: 1
 *
 * <p>解释: 移除 [1,3] 后，剩下的区间没有重叠。 示例 2:
 *
 * <p>输入: [ [1,2], [1,2], [1,2] ]
 *
 * <p>输出: 2
 *
 * <p>解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。 示例 3:
 *
 * <p>输入: [ [1,2], [2,3] ]
 *
 * <p>输出: 0
 *
 * <p>解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonOverlappingIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 0 || intervals[0].length <= 0) {
            return 0;
        }

        //{1,2},{2,3},{1,3},{1,4}
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int total = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                total++;
            } else {
                prev = intervals[i][1];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals_435 obj = new NonOverlappingIntervals_435();
        System.out.println(obj.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{1,4},{1,3}}));
    }
}