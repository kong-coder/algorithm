package com.mk.algorithm;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * <p>你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * <p>每个孩子至少分配到 1 个糖果。 相邻的孩子中，评分高的孩子必须获得更多的糖果。 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * <p>示例 1:
 *
 * <p>输入: [1,0,2] 输出: 5 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。 示例 2:
 *
 * <p>输入: [1,2,2] 输出: 4 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/candy 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy_135 {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            } else {
                candies[i + 1] = 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }

        return sum(candies);
    }

    public int sum(int[] candies) {
        if (candies == null || candies.length <=0) {
            return 0;
        }

        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        //
        Candy_135 candy = new Candy_135();
        int sum = candy.candy(new int[]{1, 0, 2});
        System.out.println(sum);
    }
}