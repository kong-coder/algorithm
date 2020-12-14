package com.mk.algorithm;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * Input: {2, 3, 1, 0, 2, 5}
 * Output: 2
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/3.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97.md
 */

import java.util.Arrays;

/**
 * @author mukong
 */
public class DuplicateNumber {

    public boolean duplicate(int[] nums,int length,int [] duplication) {

        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length - 1; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] arrays, int i, int j) {
        int t = arrays[j];
        arrays[j] = arrays[i];
        arrays[i] = t;
    }

    public static void main(String[] args) {

        DuplicateNumber duplicateNumber = new DuplicateNumber();
        int[] nums = {3,1,0,4,2,1};
        int[] duplication = new int[1];
        duplicateNumber.duplicate(nums, nums.length, duplication);
        System.out.println(Arrays.toString(duplication));
    }
}
