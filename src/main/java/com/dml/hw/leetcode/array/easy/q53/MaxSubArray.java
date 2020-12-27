package com.dml.hw.leetcode.array.easy.q53;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        List<Entity> test = new ArrayList<>();
        test.add(new Entity(new int[]{-2,1,-3,4,-1,2,1,-5,4}, new int[]{4,-1,2,1}, 6));
        test.add(new Entity(new int[]{-2,4,-3,4,-1,2,1,-5,4}, new int[]{4,-1,2,1}, 6));
        test.add(new Entity(new int[]{-2,-4,-3,-4,-1,-2,-11,-5,-4}, new int[]{4,-1,2,1}, 6));

        for (Entity e : test) {
            System.out.println(maxSubArray(e.nums));
        }

    }

    public static int maxSubArray(int[] nums) {

        int temp = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];
            if (i == 0 || a > result) {
                result = a;
            }

            if (temp + a > temp) {
                if (temp < 0) {
                    temp = 0;
                }
                temp += a;

                if (temp > result) {
                    result = temp;
                }
            } else {
                temp += a;
            }
        }
        if (temp > result) {
            result = temp;
        }

        return result;
    }
}

class Entity {
    public int[] nums;
    public int[] subNums;
    public int expect;

    Entity(int[] nums, int[] subNums, int expect) {
        this.nums = nums;
        this.subNums = subNums;
        this.expect = expect;
    }
}
