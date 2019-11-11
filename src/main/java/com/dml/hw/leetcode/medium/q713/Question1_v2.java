package com.dml.hw.leetcode.medium.q713;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/8
 */

public class Question1_v2 {


    /**
     * 给定一个正整数数组 nums。
     *
     * 找出该数组内乘积小于 k 的连续的子数组的个数。
     *
     * 示例 1:
     *
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     * 说明:
     *
     * 0 < nums.length <= 50000
     * 0 < nums[i] < 1000
     * 0 <= k < 10^6
     */

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        List<Integer[]> numSubarrayProduct = new ArrayList<>();

        int size = 0;

        loop_1:
        for (int i = 0; i < nums.length; i++) {

            int product = 1;
            for (int j = 0; j < nums.length - i; j++) {
                product = product * nums[i + j];

                if (product > 0 && product < k) {
                    size++;
                } else {
                    continue loop_1;
                }
            }
        }

        System.out.println(size);
        return size;

//        List<Integer[]> numSubarrayProduct = new ArrayList<>();
//
//        // i 是指取多少个，从一个开始取起
//        for (int i = 1; i <= nums.length; i++) {
//
//            // 从头开始取起，
//            loop_1 :
//            for (int j = 0; j < nums.length; j++) {
//
//                // 取超过两个以上，后面的会 OutOfIndex
//                if (j + i > nums.length) {
//                    continue loop_1;
//                }
//
//                // 要进行乘积的数组块
//                Integer[] subarray = new Integer[i];
//
//                // 从 j 开始取 nums， 取 i 个
//                int z = j;
//                for (int x = 0; x < i; x++) {
//                    subarray[x] = nums[z];
//                    z++;
//                }
//
//                int product = 1;
//                for (int y = 0; y < subarray.length; y++) {
//
//                    product = product * subarray[y];
//                }
//
//                if (product > 0 && product < k) {
//                    numSubarrayProduct.add(subarray);
//                }
//            }
//        }
//
//        for(Integer[] is : numSubarrayProduct) {
//            System.out.print(Arrays.toString(is) + " | ");
//        }
//
//        System.out.println(numSubarrayProduct.size());
//
//        return numSubarrayProduct.size();
    }


    public static void main(String[] args) {

//        int[] num = new int[]{10,5,2,6};
//        int k = 100;

        int[] num = new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;

        numSubarrayProductLessThanK(num, k);
    }

}
